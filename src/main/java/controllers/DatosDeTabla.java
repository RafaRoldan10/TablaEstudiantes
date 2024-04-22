package controllers;

import java.util.List;

import model.Estudiante;



public class DatosDeTabla {
	
	public static String[] getTitulosColumnas() {
		return new String[] {"id", "nombre", "apellido1", "apellido2", "dni", "direccion", "email", "telefono","sexo","color"};
	}
	
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		@SuppressWarnings("unchecked")
		List<Estudiante> estudiantes =(List<Estudiante>) ControladorEstudiante.getInstance().findAll();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[estudiantes.size()][10];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < estudiantes.size(); i++) {
			Estudiante persona = estudiantes.get(i);
			datos[i][0] = persona.getId();
			datos[i][1] = persona.getNombre();
			datos[i][2] = persona.getApellido1();
			datos[i][3] = persona.getApellido2();
			datos[i][4] = persona.getDni();
			datos[i][5] = persona.getEmail();
			datos[i][6] = persona.getDireccion();
			datos[i][7] = persona.getTelefono();
			datos[i][9] = persona.getColorPreferido();
			datos[i][8] = persona.getIdTipologiaSexo();
		}
		
		return datos;
	}
	

}
