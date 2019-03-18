package es.serbatic.dto;

import es.serbatic.bom.AlumnosAsignaturasId;

/**
 * Objeto de transferenca alumnosasignaturas
 * 
 * @author dballesteros
 *
 */
public class AlumnosAsignaturasDto {

	private AlumnosDto alumno = new AlumnosDto();
	private AsignaturasDto asignatura = new AsignaturasDto();
	private Long nota;

	public AlumnosDto getAlumno() {
		return alumno;
	}

	public void setAlumno(AlumnosDto alumno) {
		this.alumno = alumno;
	}

	public AsignaturasDto getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(AsignaturasDto asignatura) {
		this.asignatura = asignatura;
	}

	public Long getNota() {
		return nota;
	}

	public void setNota(Long nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "AlumnosAsignaturasDto [alumno=" + alumno + ", asignatura=" + asignatura + ", nota=" + nota + "]";
	}

}
