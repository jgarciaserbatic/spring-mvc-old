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

import es.serbatic.bom.Materias;
import es.serbatic.dao.MateriasDao;
import es.serbatic.dto.MateriasDto;
import es.serbatic.services.MateriasService;

/**
 * Implementa la logica del servicio de materias
 * 
 * @author cromero
 *
 */
@Service("materiasService")
public class MateriasServiceImpl implements MateriasService {

	@Autowired
	MateriasDao materiasDao;
	
	@Autowired
	private ModelMapper modelMapper;
		
	public MateriasServiceImpl() {
		super();
	}

	@Override
	public MateriasDto findById(Long id) {
		Materias entity = materiasDao.findById(id);
		return modelMapper.map(entity, MateriasDto.class);
	}

	@Override
	public List<MateriasDto> findAll() {
		List<MateriasDto> result = new ArrayList<>();
		List<Materias> found = materiasDao.findAll();
		for(Materias profesor: found) {
			result.add(modelMapper.map(profesor, MateriasDto.class));
		}
		return result;
	}

	@Override
	public List<MateriasDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public void update(MateriasDto dto) {
		Materias entity = modelMapper.map(dto, Materias.class);
		materiasDao.update(entity);
	}

	@Override
	public void saveOrUpdate(MateriasDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public MateriasDto insert(MateriasDto dto) {
		Materias entity = modelMapper.map(dto, Materias.class);
		dto = modelMapper.map(materiasDao.insert(entity), MateriasDto.class);
		return dto;
	}
	
	@Override
	public void remove(Long id) {
		materiasDao.remove(id);
	}

	@Override
	public void remove(MateriasDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public List<MateriasDto> findByExample(MateriasDto example) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}
}
