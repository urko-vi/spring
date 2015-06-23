package com.campus2b.formacion.component;

import org.springframework.stereotype.Component;

import com.campus2b.formacion.Persona;
@Component
public class PersonService implements IPersonService{

	@Override
	public Persona getPersonDetail(Integer id) {
		Persona persona = new Persona();
		persona.setId(id);
		persona.setDireccion("Bilbao");
		persona.setNombre("Jon");
		
		return persona;
	}

}
