package com.campus2b.formacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campus2b.formacion.component.IPersonService;
@RestController
@RequestMapping("/data")
public class PersonController {
	@Autowired
	private IPersonService personService;
	@RequestMapping("/persona")
	public Persona getPersonDetail(@RequestParam(value = "id",required = false,
	                                                    defaultValue = "0") Integer id) {
		Persona persona = personService.getPersonDetail(id);
		return persona;
	}
}
