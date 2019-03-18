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
	private ProfesoresDto profesor;
	private String nombre;
	private Set<AlumnosAsignaturasDto> alumnosAsignaturas = new HashSet<AlumnosAsignaturasDto>();
	
	public AsignaturasDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProfesoresDto getProfesor() {
		return profesor;
	}

	public void setProfesor(ProfesoresDto profesor) {
		this.profesor = profesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<AlumnosAsignaturasDto> getAlumnosAsignaturas() {
		return alumnosAsignaturas;
	}

	public void setAlumnosAsignaturas(Set<AlumnosAsignaturasDto> alumnosAsignaturas) {
		this.alumnosAsignaturas = alumnosAsignaturas;
	}

	@Override
	public String toString() {
		return "AsignaturasDto [id=" + id + ", profesor=" + profesor + ", nombre=" + nombre + ", alumnosAsignaturas="
				+ alumnosAsignaturas + "]";
	}

}
