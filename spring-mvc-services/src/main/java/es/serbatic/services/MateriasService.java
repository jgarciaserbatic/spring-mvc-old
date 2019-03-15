package es.serbatic.services;

import es.serbatic.base.services.GenericService;
import es.serbatic.bom.Materias;
import es.serbatic.dto.MateriasDto;
import es.serbatic.dto.ProfesoresDto;

/**
 * Define las operaciones de negocio de alumnos
 * 
 * @author jgarcia
 */
public interface MateriasService extends GenericService<MateriasDto, Materias, Long> {

	void agregarProfesor(MateriasDto materia, ProfesoresDto profesor);
	
}
