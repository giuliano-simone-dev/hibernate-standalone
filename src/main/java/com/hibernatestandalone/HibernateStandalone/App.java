package com.hibernatestandalone.HibernateStandalone;

import com.hibernatestandalone.services.UsuarioService;

public class App {
    public static void main(String[] args) {
    	UsuarioService usuarioService = new UsuarioService();
    	
    	try{
            usuarioService.create("Giuliano", "Simone", "giulianosimone@mail.com", "12345678");
            System.out.println("SUCCESS");
    	}catch(Exception e) {
            System.out.println(e.getMessage()); 
            System.out.println("ERROR"); 
    	}
        
    }
} 