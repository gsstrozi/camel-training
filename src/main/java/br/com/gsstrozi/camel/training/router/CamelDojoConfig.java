package br.com.gsstrozi.camel.training.router;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe de configurações.
 */
@Configuration
public class CamelDojoConfig {

	/**
	 * Bean necessário se utilizar versão anterior a 2.19 do apache camel para definir servlet.
	 */
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean servlet = new ServletRegistrationBean(new CamelHttpTransportServlet(), "/*");
		servlet.setName("CamelServlet");
		return servlet;
	}

}
