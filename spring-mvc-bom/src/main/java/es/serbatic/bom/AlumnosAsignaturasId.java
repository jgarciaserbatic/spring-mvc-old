package es.serbatic.bom;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Embeddable
public class AlumnosAsignaturasId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7489709942330642212L;
	
	@ManyToOne
	private Alumnos alumno;
	@ManyToOne
	private Asignaturas asignatura;
	
	public Alumnos getAlumno() {
		return alumno;
	}
	
	public void setAlumno(Alumnos alumno) {
		this.alumno = alumno;
	}
	
	public Asignaturas getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignaturas asignatura) {
		this.asignatura = asignatura;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
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
		AlumnosAsignaturasId other = (AlumnosAsignaturasId) obj;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AlumnosAsignaturasId [alumno=" + alumno.toString() + ", asignatura=" + asignatura.toString() + "]";
	}
	
	
	
}