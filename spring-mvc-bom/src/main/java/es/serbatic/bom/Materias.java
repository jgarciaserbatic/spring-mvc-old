package es.serbatic.bom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MATERIAS")
public class Materias  implements Serializable {
	
	private static final long serialVersionUID = -9054047698877645200L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="FECHAEXAMEN")
	private Date fechaExamen;
	
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(name="MATERIAS_PROFESORES",joinColumns= {@JoinColumn(name="ID_MATERIA")},inverseJoinColumns= {@JoinColumn(name="ID_PROFESOR")})
	private List<Profesores> listProfesores = new ArrayList<>();

	public Materias() {
		
	}
	
	public Materias(Long id, String nombre, Date fechaExamen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaExamen = fechaExamen;
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
