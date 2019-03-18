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

import es.serbatic.bom.Asignaturas;
import es.serbatic.dao.AsignaturasDao;
import es.serbatic.dto.AsignaturasDto;
import es.serbatic.services.AsignaturasService;

/**
 * Implementa la logica del servicio de asignaturas
 * 
 * @author jgarcia
 *
 */
@Service("asignaturasService")
public class AsignaturasServiceImpl implements AsignaturasService {

	@Autowired
	AsignaturasDao asignaturasDao;
	
	@Autowired
	private ModelMapper modelMapper;
		
	public AsignaturasServiceImpl() {
		super();
	}

	@Override
	public AsignaturasDto findById(Long id) {
		Asignaturas entity = asignaturasDao.findById(id);
		return modelMapper.map(entity, AsignaturasDto.class);
	}

	@Override
	public List<AsignaturasDto> findAll() {
		List<AsignaturasDto> result = new ArrayList<>();
		List<Asignaturas> found = asignaturasDao.findAll();
		for(Asignaturas asignatura: found) {
			result.add(modelMapper.map(asignatura, AsignaturasDto.class));
		}
		return result;
	}

	@Override
	public List<AsignaturasDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public void update(AsignaturasDto dto) {
		Asignaturas entity = modelMapper.map(dto, Asignaturas.class);
		asignaturasDao.update(entity);
	}

	@Override
	public void saveOrUpdate(AsignaturasDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public AsignaturasDto insert(AsignaturasDto dto) {
		Asignaturas entity = modelMapper.map(dto, Asignaturas.class);
		dto = modelMapper.map(asignaturasDao.insert(entity), AsignaturasDto.class);
		return dto;
	}
	
	@Override
	public void remove(Long id) {
		asignaturasDao.remove(id);
	}

	@Override
	public void remove(AsignaturasDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public List<AsignaturasDto> findByExample(AsignaturasDto example) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}
}
