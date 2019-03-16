package es.serbatic.bom;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MATERIA_PROFESOR")
public class MateriaProfesor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID_MATERIA")
	private Long id_materia;
	@Id
	@Column(name = "ID_PROFESOR")
	private Long id_profesor;
	public Long getId_materia() {
		return id_materia;
	}
	public void setId_materia(Long id_materia) {
		this.id_materia = id_materia;
	}
	public Long getId_profesor() {
		return id_profesor;
	}
	public void setId_profesor(Long id_profesor) {
		this.id_profesor = id_profesor;
	}
}
