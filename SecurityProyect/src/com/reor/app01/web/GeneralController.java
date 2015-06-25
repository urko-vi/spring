package com.reor.app01.web;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reor.app01.security.SecurityContextFacade;
import com.reor.app01.type.AllowedAuthorities;

@Controller
public class GeneralController {

	private static final Logger logger = Logger.getLogger(GeneralController.class);
	
	/**
	 * 
	 * inicio: http://localhost:8080/app01/index.htm
	 * 
	 * */
	@RequestMapping(value="/index.htm")
	public String index() {
		return "index";
	} 
	
	@RequestMapping(value="/secured/access.htm")
	public String loginAction(Model model) {
		
		String paginaInicio = "main/index"; 
		try {
				paginaInicio = "index";

				if (SecurityContextFacade.hasAuthenticatedUserRole(AllowedAuthorities.ROLE_ADMIN)) {
					paginaInicio = "redirect:/secured/adm/index.htm";
				} else if (SecurityContextFacade.hasAuthenticatedUserRole(AllowedAuthorities.ROLE_STAFF)) {
					paginaInicio = "redirect:/secured/stf/index.htm";
				} else if (SecurityContextFacade.hasAuthenticatedUserRole(AllowedAuthorities.ROLE_USER)) {
					paginaInicio = "redirect:/secured/usr/index.htm";
				} 
				else { throw new AccessDeniedException("El usuario no tiene suficientes permisos para acceder a la aplicación."); } 				
		
		} catch (Exception e) { logger.error(e.getMessage(), e); }
		return paginaInicio;
	}

	@RequestMapping(value="/secured/adm/index.htm")
	public String adminsHome() {
		return "foradmins/index";
	} 
	@RequestMapping(value="/secured/stf/index.htm")
	public String staffsHome() {
		return "forotherusers/index";
	} 	
	@RequestMapping(value="/secured/usr/index.htm")
	public String usersHome() {
		return "forotherusers/index";
	} 	
	
	
	
}

