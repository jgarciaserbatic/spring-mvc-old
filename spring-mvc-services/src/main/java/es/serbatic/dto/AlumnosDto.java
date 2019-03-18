package es.serbatic.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Objeto de transferenca alumno
 * 
 * @author jgarcia
 *
 */
public class AlumnosDto {

	private Long id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Set<AlumnosAsignaturasDto> asignaturas = new HashSet<AlumnosAsignaturasDto>();
 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Set<AlumnosAsignaturasDto> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<AlumnosAsignaturasDto> asignaturas) {
		this.asignaturas = asignaturas;
	}

	@Override
	public String toString() {
		return "AlumnosDto [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", asignaturas=" + asignaturas + "]";
	}

}
