package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="tipologiaSexo")
public class TipologiaSexo extends Entidad{
	
	@Id
	private int id;
	private String descripcion;
	
	@OneToMany(mappedBy="idTipologiaSexo")
	private List<Estudiante> estudiantes;

	
	
	
	public TipologiaSexo() {
		super();
	}

	public TipologiaSexo(int id, String descripcion, List<Estudiante> estudiantes) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.estudiantes = estudiantes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	@Override
	public String toString() {
		return descripcion;
	}
	
	
	
	

}
