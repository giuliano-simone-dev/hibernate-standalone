package com.hibernatestandalone.HibernateStandalone;

import com.hibernatestandalone.entity.Nota;
import com.hibernatestandalone.entity.Usuario;
import com.hibernatestandalone.services.NotaService;
import com.hibernatestandalone.services.UsuarioService;
import java.util.List;

public class App {
    public static void main(String[] args) {
    	UsuarioService usuarioService = new UsuarioService();
    	NotaService notaService = new NotaService();
    	try{
            Usuario usuario = usuarioService.findById(20002);
            List<Nota> notas = usuario.getNotas();
            System.out.println(notas);
    	}catch(Exception e) {
            System.out.println("ERROR"); 
            throw e;
    	}
        
    }
} 