     package es.serbatic.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProfesoresDto {
	private Long id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Date fechaAlta;
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
	 * @return the fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}
	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void addMaterias(MateriasDto materia) {
		getMaterias().add(materia);
		getSelectedMaterias().add(materia.getNombre());
	}

	public List<MateriasDto> getMaterias() {
		if (materias == null) {
			materias = new ArrayList<>();
		}
		return materias;
	}

	public void setMaterias(List<MateriasDto> materias) {

		this.materias = materias;
	}

	public List<String> getSelectedMaterias() {
		if (selectedMaterias == null) {
			selectedMaterias = new ArrayList<>();
		}
		return selectedMaterias;
	}

}   

