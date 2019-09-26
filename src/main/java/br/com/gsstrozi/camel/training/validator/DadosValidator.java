package br.com.gsstrozi.camel.training.validator;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;

public class DadosValidator implements Predicate {

	@Override
	public boolean matches(Exchange exchange) {
		final String body = exchange.getIn().getBody(String.class);
		
		return !body.equals("charlinho");
	}
}
