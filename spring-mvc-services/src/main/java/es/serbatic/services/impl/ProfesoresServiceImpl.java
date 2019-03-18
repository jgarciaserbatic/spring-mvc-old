/**
 * 
 */
package es.serbatic.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.serbatic.bom.Asignaturas;
import es.serbatic.bom.Profesores;
import es.serbatic.dao.AsignaturasDao;
import es.serbatic.dao.ProfesoresDao;
import es.serbatic.dto.AsignaturasDto;
import es.serbatic.dto.ProfesoresDto;
import es.serbatic.services.ProfesoresService;

/**
 * @author smartinez
 *
 */
@Service("profesoresService")
public class ProfesoresServiceImpl implements ProfesoresService {

	@Autowired
	ProfesoresDao profesoresDao;
	@Autowired
	AsignaturasDao asignaturasDao;
	
	@Autowired
	ModelMapper modelMaper;
	
	//constructor
	public ProfesoresServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ProfesoresDto findById(Long id) {
		Profesores profesor = profesoresDao.findById(id);		
		ProfesoresDto profesorDto = modelMaper.map(profesor, ProfesoresDto.class); 
		return profesorDto;
	}


	@Override
	public List<ProfesoresDto> findAll() {
		List<ProfesoresDto> resultado = new ArrayList<>();
		List<Profesores> encontrados = profesoresDao.findAll();
	
		for (Profesores profesor : encontrados) {
			resultado.add(modelMaper.map(profesor, ProfesoresDto.class));
		}
		return resultado;

	}

	@Override
	public List<ProfesoresDto> findAllOrderBy(String[] orderBy, boolean asc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ProfesoresDto profDto) {
		Profesores profesor = modelMaper.map(profDto,Profesores.class);
		List<Asignaturas> asignaturasList = new ArrayList<>();
		for(String asignatura: profDto.getAsignaturasElegidas()) {
			Long id = Long.valueOf(asignatura);
			asignaturasList.add(asignaturasDao.findById(id));
		}
		profesor.setAsignaturas(asignaturasList);
		profesoresDao.update(profesor);		
	}

	@Override
	public void saveOrUpdate(ProfesoresDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProfesoresDto insert(ProfesoresDto profDto) {
		Profesores profesor = modelMaper.map(profDto, Profesores.class);
		profesoresDao.insert(profesor);
		return profDto;
	}

	@Override
	public void remove(ProfesoresDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long id) {

		profesoresDao.remove(id);
		
	}

	@Override
	public List<ProfesoresDto> findByExample(ProfesoresDto example) {
		// TODO Auto-generated method stub
		return null;
	}

}
