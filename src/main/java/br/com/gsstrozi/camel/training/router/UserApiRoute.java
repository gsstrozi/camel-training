package br.com.gsstrozi.camel.training.router;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
public class UserApiRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		restConfiguration().component("servlet").bindingMode(RestBindingMode.off);
		
		rest().get("/user").to("direct:httpRoute");
		
		from("direct:httpRoute")
        .log("Http Route started")
        .setHeader(Exchange.HTTP_METHOD).constant(HttpMethod.GET);
//        .to("http:www.mocky.io/v2/5d8d0b7d2e0000fbcfabde94?bridgeEndpoint=true&amp;throwExceptionOnFailure=false");
	}
}
