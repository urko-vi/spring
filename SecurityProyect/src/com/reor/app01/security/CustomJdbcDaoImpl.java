
package com.reor.app01.security;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;


public class CustomJdbcDaoImpl extends JdbcDaoImpl implements UserDetailsService {
	
	public static final String DEF_USERS_BY_USERNAME_QUERY = "select " +
            "user_id, username, password, enabled, nombre, " +
            "apellidos, fecha_nacimiento, sexo, fecha_alta, " +
            "fecha_modificacion, huso_horario, correo_electronico_ppal, tracking " +
            "from USERS " +
            "where username  = ? ";
	
	public CustomJdbcDaoImpl() {}

    protected List<UserDetails> loadUsersByUsername(String username) {
        
    	return getJdbcTemplate().query(DEF_USERS_BY_USERNAME_QUERY, new String[] {username}, new RowMapper<UserDetails>() {
            public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                
            	Long userId = rs.getLong(1);
            	String username = rs.getString(2);
            	String password = rs.getString(3);
            	boolean enabled = rs.getBoolean(4);
            	
            	String nombre =  rs.getString(5);
            	
            	String apellidos =  rs.getString(6);
            	Date fechaNacimiento = rs.getTimestamp(7);
            	String sexo = rs.getString(8);
            	Date fechaAlta = rs.getTimestamp(9);
            	//Date fechaModif = rs.getTimestamp(10); //si descomento esta línea se lanza una exception interna que solo se ve en modo debug (para los usuarios que tienen el campo a 00:00:00
            	String husoHorario = rs.getString(11); 
            	String correoElectronico = rs.getString(12);
            	//boolean tracking = rs.getBoolean(13);
            	
            	return new SecurityUser(username, password, enabled, true, true, true, AuthorityUtils.NO_AUTHORITIES, 
            			userId, nombre, apellidos,fechaNacimiento, sexo, fechaAlta, null, correoElectronico, husoHorario, null ); 
            }
        });
    }

    /**
     * Se invoca desde JdbcDaoImpl, si no se implementa no se cargan los roles del usuario ni los datos adicionales que hemos incluido. Si no utilizo de este método tengo que cargar por mi cuenta userDetail.   
     */
    protected UserDetails createUserDetails(String username, UserDetails userFromUserQuery,
            List<GrantedAuthority> combinedAuthorities) {

    	SecurityUser securityUser = (SecurityUser)userFromUserQuery;
    	return new SecurityUser( 
    			securityUser.getUsername(), 
    			securityUser.getPassword(), 
    			securityUser.isEnabled(), true, true, true, combinedAuthorities, 
    			securityUser.getUserId(),
    			securityUser.getNombre(),
    			securityUser.getApellidos(),
    			securityUser.getFechaNacimiento(),
    			securityUser.getSexo(),
    			securityUser.getFechaAlta(),
    			securityUser.getFechaModificacion(),
    			securityUser.getCorreElectronicoPpal(),
    			securityUser.getHusoHorario(),
    			securityUser.getDefaultLang()
    			);
    }
}