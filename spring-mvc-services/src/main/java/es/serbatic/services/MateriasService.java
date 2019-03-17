package es.serbatic.services;

import es.serbatic.base.services.GenericService;
import es.serbatic.bom.Materia;
import es.serbatic.dto.MateriaDto;
import es.serbatic.dto.ProfesorDto;

/**
 * Define las operaciones de negocio de alumnos
 * 
 * @author jgarcia
 */
public interface MateriasService extends GenericService<MateriaDto, Materia, Long> {

	void agregarProfesor(MateriaDto materia, ProfesorDto profesor);
	
}
