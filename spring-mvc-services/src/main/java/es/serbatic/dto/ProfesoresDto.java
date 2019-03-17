package es.serbatic.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Objeto de transferenca alumno
 * 
 * @author jgarcia
 *
 */
public class ProfesoresDto {

	private Long id;
	@NotEmpty
	private String nombre;
	private String apellido1;
	private String apellido2;
	private List<MateriasDto> materias;
	private List<String> selectedMaterias;
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
	/**
	 * @return the materias
	 */
	public void addMaterias(MateriasDto materia) {
		getMaterias().add(materia);
		getSelectedMaterias().add(materia.getNombre());
	}
	/**
	 * @return the materias
	 */
	public List<MateriasDto> getMaterias() {
		if(materias == null) {
			materias = new ArrayList<>();
		}
		return materias;
	}
	/**
	 * @param materias the materias to set
	 */
	public void setMaterias(List<MateriasDto> materias) {
		this.materias = materias;
	}
	/**
	 * @return the selectedMaterias
	 */
	public List<String> getSelectedMaterias() {
		if(selectedMaterias == null) {
			selectedMaterias = new ArrayList<>();
		}
		return selectedMaterias;
	}
	/**
	 * @param selectedMaterias the selectedMaterias to set
	 */
	public void setSelectedMaterias(List<String> selectedMaterias) {
		this.selectedMaterias = selectedMaterias;
	}
	
	
}
