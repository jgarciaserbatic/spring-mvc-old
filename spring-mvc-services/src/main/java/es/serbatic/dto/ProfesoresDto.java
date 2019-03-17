package es.serbatic.dto;

import java.util.ArrayList;
import java.util.List;

public class ProfesoresDto {

	private Long id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String telefono;
	private List<MateriasDto> materias;
	private List<String> selectedMaterias;
	
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
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<MateriasDto> getMateria() {
		return materias;
	}

	public void setMateria(List<MateriasDto> materia) {
		this.materias = materia;
	}
	
	public void addMaterias(MateriasDto materia) {
		getMaterias().add(materia);
		getSelectedMaterias().add(materia.getNombre());
	}
	
	public List<MateriasDto> getMaterias() {
		if(materias == null) {
			materias = new ArrayList<>();
		}
		return materias;
	}
	
	public List<String> getSelectedMaterias() {
		if(selectedMaterias == null) {
			selectedMaterias = new ArrayList<>();
		}
		return selectedMaterias;
	}
}
