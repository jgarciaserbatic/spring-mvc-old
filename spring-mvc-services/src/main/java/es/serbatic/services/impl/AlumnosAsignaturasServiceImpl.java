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

import es.serbatic.bom.AlumnosAsignaturas;
import es.serbatic.dao.AlumnosAsignaturasDao;
import es.serbatic.dto.AlumnosAsignaturasDto;
import es.serbatic.services.AlumnosAsignaturasService;

/**
 * Implementa la logica del servicio de alumnosasignaturas
 * 
 * @author jgarcia
 *
 */
@Service("alumnosAsignaturasService")
public class AlumnosAsignaturasServiceImpl implements AlumnosAsignaturasService {

	@Autowired
	AlumnosAsignaturasDao alumnosAsignaturasDao;
	
	@Autowired
	private ModelMapper modelMapper;
		
	public AlumnosAsignaturasServiceImpl() {
		super();
	}

	@Override
	public AlumnosAsignaturasDto findById(Long id) {
		AlumnosAsignaturas entity = alumnosAsignaturasDao.findById(id);
		return modelMapper.map(entity, AlumnosAsignaturasDto.class);
	}

	@Override
	public List<AlumnosAsignaturasDto> findAll() {
		List<AlumnosAsignaturasDto> result = new ArrayList<>();
		List<AlumnosAsignaturas> found = alumnosAsignaturasDao.findAll();
		for(AlumnosAsignaturas alumno: found) {
			result.add(modelMapper.map(alumno, AlumnosAsignaturasDto.class));
		}
		return result;
	}

	@Override
	public List<AlumnosAsignaturasDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public void update(AlumnosAsignaturasDto dto) {
		AlumnosAsignaturas entity = modelMapper.map(dto, AlumnosAsignaturas.class);
		alumnosAsignaturasDao.update(entity);
	}

	@Override
	public void saveOrUpdate(AlumnosAsignaturasDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public AlumnosAsignaturasDto insert(AlumnosAsignaturasDto dto) {
		AlumnosAsignaturas entity = modelMapper.map(dto, AlumnosAsignaturas.class);
		dto = modelMapper.map(alumnosAsignaturasDao.insert(entity), AlumnosAsignaturasDto.class);
		return dto;
	}
	
	@Override
	public void remove(Long id) {
		alumnosAsignaturasDao.remove(id);
	}

	@Override
	public void remove(AlumnosAsignaturasDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public List<AlumnosAsignaturasDto> findByExample(AlumnosAsignaturasDto example) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}
}
