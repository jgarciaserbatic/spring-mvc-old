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
//	@Range(min=1, max=20 ,message = "El campo Nombre no puede estar vac�o")
	private String nombre;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PROFESOR", referencedColumnName="ID")
//	@Range(min=1, max=20 ,message = "El campo Nombre no puede estar vac�o")
	private Profesores profesor;

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

	public Profesores getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesores profesor) {
		this.profesor = profesor;
	}

	public Set<AlumnosAsignaturas> getAlumnosAsignaturas() {
		return alumnosAsignaturas;
	}

	public void setAlumnosAsignaturas(Set<AlumnosAsignaturas> alumnosAsignaturas) {
		this.alumnosAsignaturas = alumnosAsignaturas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumnosAsignaturas == null) ? 0 : alumnosAsignaturas.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignaturas other = (Asignaturas) obj;
		if (alumnosAsignaturas == null) {
			if (other.alumnosAsignaturas != null)
				return false;
		} else if (!alumnosAsignaturas.equals(other.alumnosAsignaturas))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asignaturas [id=" + id + ", nombre=" + nombre + ", profesor=" + profesor + ", alumnosAsignaturas="
				+ alumnosAsignaturas + "]";
	}

	
	

}
