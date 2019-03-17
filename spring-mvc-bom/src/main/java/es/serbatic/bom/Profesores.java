package es.serbatic.bom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="PROFESORES")
public class Profesores implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "APELLIDO_1")
	private String apellido1;
	@Column(name = "APELLIDO_2")
	private String apellido2;
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(
			name="materia_profesor",
			joinColumns = {
					@JoinColumn(name = "id_materia")},
			inverseJoinColumns = {
					@JoinColumn(name = "id_profesor")
			})
	private Set<Materia> materiaslista = new HashSet<>();
	public Long getId() {
		return id;
	}
	public Set<Materia> getMateriaslista() {
		return materiaslista;
	}
	public void setMateriaslista(Set<Materia> materiaslista) {
		this.materiaslista = materiaslista;
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

