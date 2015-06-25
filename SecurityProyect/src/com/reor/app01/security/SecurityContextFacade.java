package com.reor.app01.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.reor.app01.type.AllowedAuthorities;

/**
 * Proporciona una serie de métodos estáticos para acceder a la información de la capa de seguridad.
 */
public class SecurityContextFacade {

	/**
	 * Obtiene la información del usuario autenticado.
	 * 
	 * Esta clase me vale para interactuar con las clases de Spring, de esta manera si	tengo que cambiar Spring no tengo que ir rehaciendo el código por ahi.
	 *  
	 * @return Usuario autenticado, <i>null<i> si la información del usuario no puede recuperarse.
	 */
	public static SecurityUser getAuthenticatedUser() {
		
		Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (user instanceof SecurityUser) {
			return ((SecurityUser)user);
		} else {
			return null;
		}
	}	
	
	/**
	 * Comprueba si el usuario autenticado tiene asignado un rol determinado.
	 * 
	 * @param role Es el rol asignado al usuario autenticado.
	 * @return <b>true</b> Si el usuario tiene el rol asignado, <b>false</b> en caso contrario.
	 */
	public static boolean hasAuthenticatedUserRole(AllowedAuthorities role) {
		
		for (GrantedAuthority authority : getAuthenticatedUser().getAuthorities()) {
			if (authority.getAuthority().equals(role.toString())) {
				return true;
			}
		}
		return false;
	}
}
