package es.serbatic.dto;

import java.util.ArrayList;
import java.util.List;

import es.serbatic.bom.Asignaturas;

/**
 * Objeto de transferenca alumno
 * 
 * @author jgarcia
 *
 */
public class ProfesoresDto {

	private Long id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String direccion;
	
	private List<AsignaturasDto> asignaturas;
	private List<String> asignaturasElegidas;
	
	

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
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	//MEtodos GET y SET para asignaturas
	public void addAsignaturas(AsignaturasDto asignatura) {
		getAsignaturas().add(asignatura);
		getAsignaturasElegidas().add(asignatura.getNombre());
	}
	public List<AsignaturasDto> getAsignaturas() {
		if (asignaturas == null) {
			asignaturas = new ArrayList<>();
		}
		return asignaturas;
	}
	public void setAsignaturas(List<AsignaturasDto> asignaturas) {
		this.asignaturas = asignaturas;
	}
	public List<String> getAsignaturasElegidas() {
		if (asignaturasElegidas == null) {
			asignaturasElegidas = new ArrayList<>();
		}
		return asignaturasElegidas;
	}
	public void setAsignaturasElegidas(List<String> asignaturasElegidas) {
		this.asignaturasElegidas = asignaturasElegidas;
	}
	
}
