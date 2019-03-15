package es.serbatic.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.serbatic.bom.Profesores;
import es.serbatic.dao.ProfesoresDao;
import es.serbatic.dto.ProfesoresDto;
import es.serbatic.services.ProfesoresService;

/**
 * Implementa la logica del servicio de Profesores
 * 
 * @author jgarcia
 *
 */
@Service("profesoresService")
public class ProfesoresServiceImpl implements ProfesoresService {

	@Autowired
	ProfesoresDao profesoresDao;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	public ProfesoresServiceImpl() {
		super();
	}

	@Override
	public ProfesoresDto findById(Long id) {
		Profesores entity = profesoresDao.findById(id);
		return modelMapper.map(entity, ProfesoresDto.class);
	}

	@Override
	public List<ProfesoresDto> findAll() {
		List<ProfesoresDto> result = new ArrayList<>();
		List<Profesores> found = profesoresDao.findAll();
		for(Profesores profesor: found) {
			result.add(modelMapper.map(profesor, ProfesoresDto.class));
		}
		return result;
	}

	@Override
	public List<ProfesoresDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public void update(ProfesoresDto dto) {
		Profesores entity = modelMapper.map(dto, Profesores.class);
		profesoresDao.update(entity);
	}

	@Override
	public void saveOrUpdate(ProfesoresDto entity) {
		throw new NotYetImplementedException("Metodo no implementado todavía");
	}

	@Override
	public ProfesoresDto insert(ProfesoresDto dto) {
		Profesores entity = modelMapper.map(dto, Profesores.class);
		dto = modelMapper.map(profesoresDao.insert(entity), ProfesoresDto.class);
		return dto;
	}
	
	@Override
	public void remove(Long id) {
		profesoresDao.remove(id);
	}

	@Override
	public void remove(ProfesoresDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public List<ProfesoresDto> findByExample(ProfesoresDto example) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}
}
