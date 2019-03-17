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

import es.serbatic.bom.Alumnos;
import es.serbatic.dao.AlumnosDao;
import es.serbatic.dto.AlumnosDto;
import es.serbatic.services.AlumnosService;

@Service("alumnosService")
public class AlumnosServiceImpl implements AlumnosService {

	@Autowired
	AlumnosDao alumnosDao;
	
	@Autowired
	private ModelMapper modelMapper;
		
	public AlumnosServiceImpl() {
		super();
	}

	@Override
	public AlumnosDto findById(Long id) {
		Alumnos entity = alumnosDao.findById(id);
		return modelMapper.map(entity, AlumnosDto.class);
	}

	@Override
	public List<AlumnosDto> findAll() {
		List<AlumnosDto> result = new ArrayList<>();
		List<Alumnos> found = alumnosDao.findAll();
		for(Alumnos alumno: found) {
			result.add(modelMapper.map(alumno, AlumnosDto.class));
		}
		return result;
	}

	@Override
	public List<AlumnosDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public void update(AlumnosDto dto) {
		Alumnos entity = modelMapper.map(dto, Alumnos.class);
		alumnosDao.update(entity);
	}

	@Override
	public void saveOrUpdate(AlumnosDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public AlumnosDto insert(AlumnosDto dto) {
		Alumnos entity = modelMapper.map(dto, Alumnos.class);
		dto = modelMapper.map(alumnosDao.insert(entity), AlumnosDto.class);
		return dto;
	}
	
	@Override
	public void remove(Long id) {
		alumnosDao.remove(id);
	}

	@Override
	public void remove(AlumnosDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public List<AlumnosDto> findByExample(AlumnosDto example) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}
}
