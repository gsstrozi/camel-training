package br.com.gsstrozi.camel.training.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestApiRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		restConfiguration().component("servlet").bindingMode(RestBindingMode.off);
		/**
		 * Mapeamento rest.
		 */
		rest("/api/").id("api-route").post("/jms/").route().to("activemq:queue:restQueue?disableReplyTo=true");
	}
}
