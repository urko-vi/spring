package com.campus2b.formacion;

import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class ClientAppConfig {
	public static final String URIWSDL = "http://localhost:8080/springwebservice/soapws/students.wsdl";

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.campus2b.formacion.wsdl");
		return marshaller;
	}
	@Bean
	public StudentClient studentClient(Jaxb2Marshaller marshaller) {
		StudentClient client = new StudentClient();
		client.setDefaultUri(URIWSDL);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
