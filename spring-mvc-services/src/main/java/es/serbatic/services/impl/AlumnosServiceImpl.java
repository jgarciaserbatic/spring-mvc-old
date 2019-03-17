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

import es.serbatic.bom.Alumno;
import es.serbatic.dao.AlumnoDao;
import es.serbatic.dto.AlumnoDto;
import es.serbatic.services.AlumnosService;

/**
 * Implementa la logica del servicio de alumnos
 * 
 * @author jgarcia
 *
 */
@Service("alumnosService")
public class AlumnosServiceImpl implements AlumnosService {

	@Autowired
	AlumnoDao alumnosDao;
	
	@Autowired
	private ModelMapper modelMapper;
		
	public AlumnosServiceImpl() {
		super();
	}

	@Override
	public AlumnoDto findById(Long id) {
		Alumno entity = alumnosDao.findById(id);
		return modelMapper.map(entity, AlumnoDto.class);
	}

	@Override
	public List<AlumnoDto> findAll() {
		List<AlumnoDto> result = new ArrayList<>();
		List<Alumno> found = alumnosDao.findAll();
		for(Alumno alumno: found) {
			result.add(modelMapper.map(alumno, AlumnoDto.class));
		}
		return result;
	}

	@Override
	public List<AlumnoDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public void update(AlumnoDto dto) {
		Alumno entity = modelMapper.map(dto, Alumno.class);
		alumnosDao.update(entity);
	}

	@Override
	public void saveOrUpdate(AlumnoDto entity) {
		if (entity.getId() != null) 
			if (this.findById(entity.getId()) != null) {
				this.update(entity);	
				return;				
			}
		this.insert(entity);
	}

	@Override
	public AlumnoDto insert(AlumnoDto dto) {
		Alumno entity = modelMapper.map(dto, Alumno.class);
		dto = modelMapper.map(alumnosDao.insert(entity), AlumnoDto.class);
		return dto;
	}
	
	@Override
	public void remove(Long id) {
		alumnosDao.remove(id);
	}

	@Override
	public void remove(AlumnoDto entity) {
		if (entity.getId() != 0) {
			this.remove(entity.getId());
		}
	}

	@Override
	public List<AlumnoDto> findByExample(AlumnoDto example) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}
}
