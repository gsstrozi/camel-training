package br.com.gsstrozi.camel.training.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class JmsWriteRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
        from("file:C:\\ApacheCamel\\FileRouter\\ConvertFiles\\out").to("log:?level=INFO&showBody=true").to("activemq:queue:testQueue");
	}
}
