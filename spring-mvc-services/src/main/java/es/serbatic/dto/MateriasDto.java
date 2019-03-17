package es.serbatic.dto;

import java.util.Date;



public class MateriasDto {

	private Long id;

	private String nombre;
	
	private Date fechaExamen;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaExamen == null) ? 0 : fechaExamen.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		MateriasDto other = (MateriasDto) obj;
		if (fechaExamen == null) {
			if (other.fechaExamen != null)
				return false;
		} else if (!fechaExamen.equals(other.fechaExamen))
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
		return true;
	}

	public MateriasDto(Long id, String nombre, Date fechaExamen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaExamen = fechaExamen;
	}

	public MateriasDto() {
		// TODO Auto-generated constructor stub
	}

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

	public Date getFechaExamen() {
		return fechaExamen;
	}

	public void setFechaExamen(Date fechaExamen) {
		this.fechaExamen = fechaExamen;
	}
	
	
}
