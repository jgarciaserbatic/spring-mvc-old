/**
 * 
 */
package es.serbatic.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.serbatic.bom.Profesor;
import es.serbatic.dao.ProfesorDao;
import es.serbatic.dto.ProfesorDto;
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
	ProfesorDao ProfesoresDao;
	
	@Autowired
	private ModelMapper modelMapper;
		
	public ProfesoresServiceImpl() {
		super();
	}

	@Override
	public ProfesorDto findById(Long id) {
		Profesor entity = ProfesoresDao.findById(id);
		return modelMapper.map(entity, ProfesorDto.class);
	}

	@Override
	public List<ProfesorDto> findAll() {
		List<ProfesorDto> result = new ArrayList<>();
		List<Profesor> found = ProfesoresDao.findAll();
		for(Profesor profesor: found) {
			result.add(modelMapper.map(profesor, ProfesorDto.class));
		}
		return result;
	}

	@Override
	public List<ProfesorDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public void update(ProfesorDto dto) {
		Profesor entity = modelMapper.map(dto, Profesor.class);
		ProfesoresDao.update(entity);
	}

	@Override
	public void saveOrUpdate(ProfesorDto entity) {
		if (entity.getId() != null) 
			if (this.findById(entity.getId()) != null) {
				this.update(entity);	
				return;				
			}
		this.insert(entity);
	}

	@Override
	public ProfesorDto insert(ProfesorDto dto) {
		Profesor entity = modelMapper.map(dto, Profesor.class);
		dto = modelMapper.map(ProfesoresDao.insert(entity), ProfesorDto.class);
		return dto;
	}
	
	@Override
	public void remove(Long id) {
		ProfesoresDao.remove(id);
	}

	@Override
	public void remove(ProfesorDto entity) {
		if (entity.getId() != 0) {
			this.remove(entity.getId());
		}
	}

	@Override
	public List<ProfesorDto> findByExample(ProfesorDto example) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}
}
