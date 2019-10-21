package com.ustglobal.demo.route;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Component
@ConfigurationProperties(prefix="camel-demo-route")
@Data
@EqualsAndHashCode(callSuper=true)

public class CamelDemoRoute extends RouteBuilder {

		
	

	@Override
	public void configure() throws Exception {

		// @formatter:off
		
//		errorHandler(deadLetterChannel("seda:errorQueue").maximumRedeliveries(5).redeliveryDelay(1000));

		//from("file://{{inputFolder}}?delay=10s&noop=true&maxMessagesPerPoll=2")
		from("file://{{inputFolder}}?delay=10s&noop=true")
		.routeId("InputFolderToTestSedaRoute")
		.setHeader("isLastFile", simple("${exchangeProperty.CamelBatchComplete}"))
		.to("seda://testSeda")
		.log("****STEP 10 Input File Pushed To seda *****");

		from("seda://testSeda")
		.routeId("TestSedaToOutputFolderRoute")
		//Do whatever you want in a processor or bean end point. I send it to another folder
		.to("file://{{outputFolder}}")
		.log("*****STEP 20 ${header.CamelFileName} isLastFile: ${header.isLastFile} *****")
		.choice()
			.when(new IsLastFilePredicate())
				.to("seda:fireNextRouteSeda")
		.endChoice()
		;
				
		
		from("seda:fireNextRouteSeda")
		.routeId("LastMessageOnlyRoute")
		.log("*****STEP 30 I should see only the last message - filename:${header.CamelFileName} *****")
		;
		
		
		// @formatter:on
		


	}
	
	private final class IsLastFilePredicate implements Predicate {
		@Override
		public boolean matches(Exchange exchange) {
			boolean isLastFile = exchange.getIn().getHeader("isLastFile", Boolean.class);
			return isLastFile;
		}
	}

}
