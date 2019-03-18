/**
 * 
 */
package es.serbatic.dto;

/**
 * @author smartinez
 *
 */
public class AsignaturasDto {

	private Long id;
	
	private String nombre;
	
	private String descripcion;		
	

	//////////GET AND SET
	

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
