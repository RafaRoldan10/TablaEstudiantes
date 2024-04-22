package controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.Entidad;





public class SuperControlador {
	
	private static EntityManager em = null;
	private String nombreTabla ="";
	private Class tipoEntidad;
	
	public SuperControlador(String nombreTabla, Class tipoEntidad) {
		this.nombreTabla = nombreTabla;
		this.tipoEntidad = tipoEntidad;
	}
	
	protected EntityManager getEntityManager() {
		
		if(em == null) {
			em = Persistence.createEntityManagerFactory("centroeducativo").
					createEntityManager();
		}
		return em;
		
	}
	
	public void update (Entidad m) {
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
		System.out.println("Se ha actualizado");
		
	}
	
	public void insert(Entidad m) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		System.out.println("Se ha insertado");
		
	}
	
	@SuppressWarnings("unchecked")
	public List<? extends Entidad> findAll() {
		return (List<Entidad>) getEntityManager().
				createNativeQuery("SELECT * FROM " + this.nombreTabla, this.tipoEntidad)
				.getResultList();
	}

}
