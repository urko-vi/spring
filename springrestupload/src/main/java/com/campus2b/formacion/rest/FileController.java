package com.campus2b.formacion.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	

	@RequestMapping(value="/uploadFile")
	public String handleFileUpload(@RequestParam("file") MultipartFile file){
		String mensaje = "test";
		System.out.println(mensaje);

		if (!file.isEmpty()) {
			
		}

	 //   logger.info("initialization of object");
	    //----------------------------------------

	//     System.out.Println("name of File : " + fileName);  

	    //----------------------------------------
		
		return mensaje;
	}

}