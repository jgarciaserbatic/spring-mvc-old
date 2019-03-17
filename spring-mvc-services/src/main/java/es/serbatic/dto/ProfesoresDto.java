package es.serbatic.dto;

import java.util.HashSet;
import java.util.Set;

import es.serbatic.bom.Materia;

public class ProfesoresDto {
	private Long id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Set<Materia> materiaslista = new HashSet<>();
	public Set<Materia> getMateriaslista() {
		return materiaslista;
	}
	public void setMateriaslista(Set<Materia> materiaslista) {
		this.materiaslista = materiaslista;
	}
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
	
}
