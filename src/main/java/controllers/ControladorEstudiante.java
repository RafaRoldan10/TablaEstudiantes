package controllers;


import model.Estudiante;

public class ControladorEstudiante extends SuperControlador{
	
	private static ControladorEstudiante instance = null;
	
	public static ControladorEstudiante getInstance() {
		if(instance == null) {
			instance = new ControladorEstudiante();
		}
		return instance;
	}
	
	public ControladorEstudiante() {
		super("estudiante",Estudiante.class);
	}
	
	public Estudiante findEstudiante(int id) {
		return (Estudiante) getEntityManager().
				createNativeQuery("SELECT * FROM estudiante where id="+ id, Estudiante.class) 
				.getSingleResult();
	}
	
	
	
	
	
	
	

}
