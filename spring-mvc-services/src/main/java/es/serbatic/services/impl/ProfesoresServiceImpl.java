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
import es.serbatic.bom.Profesores;
import es.serbatic.dao.ProfesoresDao;
import es.serbatic.dto.MateriasDto;
import es.serbatic.dto.ProfesoresDto;
import es.serbatic.services.ProfesoresService;

/**
 * Implementa la logica del servicio de profesores
 * 
 * @author cromero
 *
 */
@Service("profesoresService")
public class ProfesoresServiceImpl implements ProfesoresService {

	@Autowired
	ProfesoresDao profesoresDao;
	
	@Autowired
	private ModelMapper modelMapper;
		
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
			result.add(convert(profesor));
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
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public ProfesoresDto insert(ProfesoresDto dto) {
		Profesores entity = modelMapper.map(dto, Profesores.class);
		dto = convert(profesoresDao.insert(entity));
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
	
	
	private ProfesoresDto convert(Profesores source) {
		
		ProfesoresDto result = new ProfesoresDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setApellido1(source.getApellido1());
		result.setApellido2(source.getApellido2());
		List<MateriasDto> materias =new ArrayList();
		for (Materias materia : source.getMaterias()) {
			MateriasDto materiaDto=new MateriasDto();
			materiaDto.setId(materia.getId());
			materiaDto.setNombre(materia.getNombre());
			materias.add(materiaDto);
		}
		result.setMaterias(materias);
		return result;
	}
}
