package com.hibernatestandalone.HibernateStandalone;

import com.hibernatestandalone.entity.Usuario;
import com.hibernatestandalone.services.UsuarioService;
import java.util.List;

public class App {
    public static void main(String[] args) {
    	UsuarioService usuarioService = new UsuarioService();
    	
    	try{
            Usuario usuario = usuarioService.findById(20002);
            System.out.println(usuario);
    	}catch(Exception e) {
            System.out.println("ERROR"); 
            throw e;
    	}
        
    }
} 