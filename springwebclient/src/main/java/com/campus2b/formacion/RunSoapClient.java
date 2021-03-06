package com.campus2b.formacion;

import java.net.URLClassLoader;
import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.campus2b.formacion.wsdl.GetStudentResponse;

public class RunSoapClient {

	public static void main(String[] args) {
        URLClassLoader classLoader = (URLClassLoader)RunSoapClient.class.getClassLoader();
        System.out.println(Arrays.toString(classLoader.getURLs()));
        
		AnnotationConfigApplicationContext ctx =null;
		StudentClient studentClient = null;
		try{
			ctx = new AnnotationConfigApplicationContext();
	        ctx.register(ClientAppConfig.class);
	        ctx.refresh();
			studentClient = ctx.getBean(StudentClient.class);
		} finally{
			ctx.close();
		}
		System.out.println("For Student Id: 1");
		GetStudentResponse response = studentClient.getStudentById(1);
		System.out.println("Name:"+response.getStudent().getName());
		System.out.println("Age:"+response.getStudent().getAge());
		System.out.println("Class:"+response.getStudent().getClazz());

	}

}
