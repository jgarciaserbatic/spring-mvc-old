package es.serbatic.bom;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ASIGNATURAS")
public class Asignaturas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9054047698877645200L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NOMBRE")
//	@Range(min=1, max=20 ,message = "El campo Nombre no puede estar vacío")
	private String nombre;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PROFESOR")
//	@Range(min=1, max=20 ,message = "El campo Nombre no puede estar vacío")
	private Long idProfesor;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.asignatura", cascade = CascadeType.ALL)
	private Set<AlumnosAsignaturas> alumnosAsignaturas = new HashSet<AlumnosAsignaturas>();

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

	public Long getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Long idProfesor) {
		this.idProfesor = idProfesor;
	}

	public Set<AlumnosAsignaturas> getAlumnosAsignaturas() {
		return alumnosAsignaturas;
	}

	public void setAlumnosAsignaturas(Set<AlumnosAsignaturas> alumnosAsignaturas) {
		this.alumnosAsignaturas = alumnosAsignaturas;
	}

	@Override
	public String toString() {
		return "Asignaturas [id=" + id + ", nombre=" + nombre + ", idProfesor=" + idProfesor + ", alumnosAsignaturas="
				+ alumnosAsignaturas + "]";
	}

	

}
