package es.serbatic.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de transferenca alumno
 * 
 * @author jgarcia
 *
 */
public class MateriaDto {

	private Long id;
	private String nombre;
	private List<ProfesorDto> profesores = new ArrayList<ProfesorDto>();
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellido2
	 */
	public List<ProfesorDto> getProfesores() {
		return profesores;
	}
	/**
	 * @param apellido2 the apellido2 to set
	 */
	public void setProfesores(List<ProfesorDto> profesores) {
		this.profesores = profesores;
	}
}