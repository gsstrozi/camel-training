package br.com.gsstrozi.camel.training.router;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import br.com.gsstrozi.camel.training.validator.DadosValidator;

@Component
public class UserValidationRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		restConfiguration().component("servlet").bindingMode(RestBindingMode.off);

		rest().post("/validator").to("direct:userValidator");

		from("direct:userValidator")
		.doTry()
			.choice()
				.when(new DadosValidator())
					.throwException(new Exception("Usuario nao encontrado"))
				.otherwise().process(new Processor() {
					@Override
					public void process(Exchange exchange) throws Exception {
						exchange.getIn().setBody("Usuário Válido");
					}
				})
		.endDoTry()
		.doCatch(Exception.class)
			.process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					 final Throwable ex = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
	                    exchange.getIn().setBody(ex.getMessage());
				}
			})
		.end();

	}
}
