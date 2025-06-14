package com.hibernatestandalone.services;

import com.hibernatestandalone.entity.Usuario;
import com.hibernatestandalone.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class UsuarioService extends AbstractService {


    public Usuario create(String nombre, String apellido, String email, String password) {
        Transaction transaction = null;
        try (Session session = this.getSession()) {
            transaction = session.beginTransaction();
            Usuario user = new Usuario();
            user.setNombre(nombre);
            user.setApellido(apellido);
            user.setMail(email);
            user.setPassword(password);
            user.setFRegistro(new Date());
            session.persist(user);
            transaction.commit();
            return user;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }
    
	public Usuario findById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Usuario.class, id);
        }
    }

    public List<Usuario> getAll() {
        try (Session session = this.getSession()) {
            String hql = "FROM Usuario";
            return session.createQuery(hql, Usuario.class).getResultList();
        }
    }

    public void delete(long id) {
    	Transaction transaction = null;
        try (Session session = this.getSession()) {
        	transaction = session.beginTransaction();
    		Usuario user = (Usuario) session.getReference(Usuario.class, id);
            session.remove(user);
            transaction.commit();
        }catch(Exception e) {
        	if (transaction != null) transaction.rollback();
        	throw e;
        }
    }

    public void delete(Usuario user) {
        Transaction transaction = null;
        try (Session session = this.getSession()) {
            transaction = session.beginTransaction();
            session.remove(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    public void update(Usuario user, String nombre, String apellido, String email, String password) {
        Transaction transaction = null;
        try (Session session = this.getSession()) {
            transaction = session.beginTransaction();
            if (nombre != null) user.setNombre(nombre);
            if (apellido != null) user.setApellido(apellido);
            if (email != null) user.setMail(email);
            if (password != null) user.setPassword(password);
            session.merge(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    public void update(int id, String nombre, String apellido, String email, String password) {
        Transaction transaction = null;
        try (Session session = this.getSession()) {
            transaction = session.beginTransaction();
            Usuario user = session.getReference(Usuario.class, id);
            if (user != null) {
                if (nombre != null) user.setNombre(nombre);
                if (apellido != null) user.setApellido(apellido);
                if (email != null) user.setMail(email);
                if (password != null) user.setPassword(password);
                session.merge(user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

}