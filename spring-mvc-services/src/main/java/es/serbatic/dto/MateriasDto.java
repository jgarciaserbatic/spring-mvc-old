package es.serbatic.dto;

import java.util.Date;
import java.util.List;

public class MateriasDto {
	
	private Long id;
	private String nombre;
	private Date fechaExamen;
	
	private List<ProfesoresDto> profesor;
	
	
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
	public Date getFechaExamen() {
		return fechaExamen;
	}
	public void setFechaExamen(Date fechaExamen) {
		this.fechaExamen = fechaExamen;
	}
	public List<ProfesoresDto> getProfesor() {
		return profesor;
	}
	public void setProfesor(List<ProfesoresDto> profesor) {
		this.profesor = profesor;
	}

	
}
