package es.serbatic.bom;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="MATERIAS_PROFESORES")
public class Materias_Profesores implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MATERIA")
	private int id_materia;
	
	@Id
	@Column(name="ID_PROFESOR")
	private int id_profesor;
	
	

	public int getId_materia() {
		return id_materia;
	}

	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}

	public int getId_profesor() {
		return id_profesor;
	}

	public void setId_profesor(int id_profesor) {
		this.id_profesor = id_profesor;
	}
	
	
	
}
