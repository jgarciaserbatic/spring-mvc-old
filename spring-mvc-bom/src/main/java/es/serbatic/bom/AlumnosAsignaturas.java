package es.serbatic.bom;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "ALUMNOS_ASIGNATURAS")
@AssociationOverrides({ 
		@AssociationOverride(name = "pk.alumno", joinColumns = @JoinColumn(name = "ID_ALUMNO")),
		@AssociationOverride(name = "pk.asignatura", joinColumns = @JoinColumn(name = "ID_ASIGNATURA")) 
	})
public class AlumnosAsignaturas implements Serializable {

	private static final long serialVersionUID = 8282512613035103458L;

	@EmbeddedId
	private AlumnosAsignaturasId pk = new AlumnosAsignaturasId();

	@Column(name = "NOTA")
	private Long nota;

	public AlumnosAsignaturas() {
	}

	public AlumnosAsignaturasId getPk() {
		return pk;
	}

	public void setPk(AlumnosAsignaturasId pk) {
		this.pk = pk;
	}

	public Long getNota() {
		return nota;
	}

	public void setNota(Long nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "AlumnosAsignaturas [pk=" + pk + ", nota=" + nota + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nota == null) ? 0 : nota.hashCode());
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
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
		AlumnosAsignaturas other = (AlumnosAsignaturas) obj;
		if (nota == null) {
			if (other.nota != null)
				return false;
		} else if (!nota.equals(other.nota))
			return false;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		return true;
	}

	

}