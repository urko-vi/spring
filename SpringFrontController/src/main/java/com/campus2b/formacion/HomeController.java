package com.campus2b.formacion;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.campus2b.formacion.pojo.Persona;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private Environment env;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		/*
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		//String formattedDate = dateFormat.format(date);
		
		//model.addAttribute("serverTime", formattedDate );
		*/
		return "home";
	}
	
	@ModelAttribute
	public Persona putPersonaInModel() {
		Persona persona = new Persona();
		persona.setNombre("Jon");
		
		return persona; 
	}

		
	@ModelAttribute("usuario")
	public void putMultipleStuffInModel(Model model) {
		model.addAttribute("primer", new Persona());
		model.addAttribute("segundo", new Persona());
	       //.....
	}
	
	@ModelAttribute
	public Persona putPersonInModel(@RequestParam("id") int personId) {
		Persona persona = null;
		// cargar persona desde la capa de negocio
		return persona;
	}
}
