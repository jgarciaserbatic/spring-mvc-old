package es.serbatic.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

/**
 * Objeto de transferenca profesor
 * 
 * @author jgarcia
 *
 */
public class ProfesoresDto {
	
	private Long id;
	private String nombre;
	private String apellido1;	
	private String apellido2;
	private List<AsignaturasDto> asignaturas= new ArrayList<AsignaturasDto>();
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
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}
	/**
	 * @param apellido1 the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	/**
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}
	/**
	 * @param apellido2 the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	@Override
	public String toString() {
		return "ProfesoresDto [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + "]";
	}
	public List<AsignaturasDto> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(List<AsignaturasDto> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	
}
