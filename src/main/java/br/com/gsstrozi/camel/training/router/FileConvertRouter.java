package br.com.gsstrozi.camel.training.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class FileConvertRouter extends RouteBuilder {

	private static final String FILE_DEFAULT_CONFIG = "?initialDelay=2000&delete=true";

	private static final String FILE_CONVERT_SOURCE_FOLDER_IN = "C:\\ApacheCamel\\FileRouter\\ConvertFiles\\in";
	private static final String FILE_CONVERT_SOURCE_FOLDER_OUT = "C:\\ApacheCamel\\FileRouter\\ConvertFiles\\out";

	@Override
	public void configure() throws Exception {
		/**
		 * Convertendo arquivos e movendo de pasta
		 */
		XmlJsonDataFormat xmlJsonFormat = new XmlJsonDataFormat();
		xmlJsonFormat.setEncoding("UTF-8");
		xmlJsonFormat.setForceTopLevelObject(true);
		xmlJsonFormat.setTrimSpaces(true);
		xmlJsonFormat.setSkipNamespaces(true);
		xmlJsonFormat.setRemoveNamespacePrefixes(true);

		from("file:" + FILE_CONVERT_SOURCE_FOLDER_IN + FILE_DEFAULT_CONFIG).convertBodyTo(String.class).marshal(xmlJsonFormat)
				.to("file:" + FILE_CONVERT_SOURCE_FOLDER_OUT + "?fileName=pessoa.json");
	}
}
