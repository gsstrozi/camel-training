package br.com.gsstrozi.camel.training.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileMoveRouter extends RouteBuilder {

	private static final String FILE_DEFAULT_CONFIG = "?initialDelay=2000&delete=true";

	private static final String FILE_MOVE_SOURCE_FOLDER_IN = "C:\\ApacheCamel\\FileRouter\\MoveFiles\\in";
	private static final String FILE_MOVE_SOURCE_FOLDER_OUT = "C:\\ApacheCamel\\FileRouter\\MoveFiles\\out";

	@Override
	public void configure() throws Exception {
		/**
		 * Movendo arquivos de pasta
		 */
		from("file:" + FILE_MOVE_SOURCE_FOLDER_IN + FILE_DEFAULT_CONFIG).to("file:" + FILE_MOVE_SOURCE_FOLDER_OUT);
	}
}
