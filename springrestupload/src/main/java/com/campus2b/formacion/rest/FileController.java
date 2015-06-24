package com.campus2b.formacion.rest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	
	  // The Environment object will be used to read parameters from the 
	  // application.properties configuration file
	  @Autowired
	  private Environment env;
	  
	  
	  @RequestMapping(value="/")
	  public String index() {
		  return "index.html";
	  }
	  
	  @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	  @ResponseBody
	  public ResponseEntity<HttpStatus> uploadFile(
	      @RequestParam("file") MultipartFile uploadfile) {
		  ResponseEntity<HttpStatus> type = null;
		  BufferedOutputStream stream = null;
	    try {
	    	// Get the filename and build the local file path
	    	String filename = uploadfile.getOriginalFilename();
	    	String directory = env.getProperty("springrestupload.paths.uploadedFiles");
	    	String filepath = Paths.get(directory, filename).toString();
  
	    	stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
	    	stream.write(uploadfile.getBytes());
	    	stream.close();
	    } catch (Exception e) {
	      //System.out.println(e.getMessage());
	       type = new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	    }
	    type = new ResponseEntity<HttpStatus>(HttpStatus.OK);
	    return type;
	  } // method uploadFile
}