package es.serbatic.services;

import java.util.List;

import es.serbatic.base.services.GenericService;
import es.serbatic.bom.Profesores;
import es.serbatic.dto.ProfesoresDto;

public interface ProfesoresService extends GenericService<ProfesoresDto, Profesores, Long>  {

	List<ProfesoresDto> findprofesorAsignatura(Long id);
	
	public void asignaProfesorMateria(Long id, Long id2);

}
