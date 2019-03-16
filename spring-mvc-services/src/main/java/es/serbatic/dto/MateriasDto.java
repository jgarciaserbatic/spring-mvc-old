package es.serbatic.dto;

/**
 * Objeto de transferenca materias
 * 
 * @author jgarcia
 *
 */
public class MateriasDto {

	private Long id;
	private String nombre;
	private Long horas;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the horas
	 */
	public Long getHoras() {
		return horas;
	}
	/**
	 * @param horas the horas to set
	 */
	public void setHoras(Long horas) {
		this.horas = horas;
	}
	
}
