package es.serbatic.services;



import es.serbatic.base.services.GenericService;
import es.serbatic.bom.MateriaProfesor;
import es.serbatic.dto.MateriaProfesorDto;

public interface MateriaProfesoresService extends GenericService<MateriaProfesorDto, MateriaProfesor, Long> {
	
	public void guardarIdProfesor(Long id);

	public void guardarIdAsignatura(Long id);

}
