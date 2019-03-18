package es.serbatic.dto;

public class MateriaDto {

	private Long id;
	private String materia;
	private ProfesoresDto profesor;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the materia
	 */
	public String getMateria() {
		return materia;
	}
	/**
	 * @param materia the materia to set
	 */
	public void setMateria(String materia) {
		this.materia = materia;
	}
	/**
	 * @return the profesor
	 */
	public ProfesoresDto getProfesor() {
		return profesor;
	}
	/**
	 * @param profesor the profesor to set
	 */
	public void setProfesor(ProfesoresDto profesor) {
		this.profesor = profesor;
	}	
}