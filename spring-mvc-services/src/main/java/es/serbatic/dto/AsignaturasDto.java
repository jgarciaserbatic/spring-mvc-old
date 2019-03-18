package es.serbatic.dto;

import java.util.HashSet;
import java.util.Set;

import es.serbatic.bom.AlumnosAsignaturas;

/**
 * Objeto de transferenca asignatura
 * 
 * @author dballesteros
 *
 */
public class AsignaturasDto {

	private Long id;
	private Long idProfesor;
	private String nombre;
	private Set<AlumnosAsignaturas> alumnosAsignaturas = new HashSet<AlumnosAsignaturas>();
	
	public AsignaturasDto() {
		super();
	}

	public AsignaturasDto(Long id, Long idProfesor, String nombre) {
		super();
		this.id = id;
		this.idProfesor = idProfesor;
		this.nombre = nombre;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Long idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<AlumnosAsignaturas> getAlumnosAsignaturas() {
		return alumnosAsignaturas;
	}

	public void setAlumnosAsignaturas(Set<AlumnosAsignaturas> alumnosAsignaturas) {
		this.alumnosAsignaturas = alumnosAsignaturas;
	}

	@Override
	public String toString() {
		return "AsignaturasDto [id=" + id + ", idProfesor=" + idProfesor + ", nombre=" + nombre
				+ ", alumnosAsignaturas=" + alumnosAsignaturas + "]";
	}


}
