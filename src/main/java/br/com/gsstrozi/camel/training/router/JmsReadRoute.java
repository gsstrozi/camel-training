package br.com.gsstrozi.camel.training.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class JmsReadRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("activemq:queue:testQueue").to("log:?level=INFO&showBody=true").to("direct:readQueue");
		
		from("direct:readQueue").to("log:?level=INFO&showBody=true");
	}
}
