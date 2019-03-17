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

import es.serbatic.bom.Materia;
import es.serbatic.dao.MateriaDao;
import es.serbatic.dto.MateriaDto;
import es.serbatic.dto.ProfesorDto;
import es.serbatic.services.MateriasService;

/**
 * Implementa la logica del servicio de Materias
 * 
 * @author jgarcia
 *
 */
@Service("materiasService")
public class MateriasServiceImpl implements MateriasService {

	@Autowired
	MateriaDao materiasDao;
	
	@Autowired
	private ModelMapper modelMapper;
		
	public MateriasServiceImpl() {
		super();
	}

	@Override
	public MateriaDto findById(Long id) {
		Materia entity = materiasDao.findById(id);
		return modelMapper.map(entity, MateriaDto.class);
	}

	@Override
	public List<MateriaDto> findAll() {
		List<MateriaDto> result = new ArrayList<>();
		List<Materia> found = materiasDao.findAll();
		for(Materia profesor: found) {
			result.add(modelMapper.map(profesor, MateriaDto.class));
		}
		return result;
	}

	@Override
	public List<MateriaDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public void update(MateriaDto dto) {
		Materia entity = modelMapper.map(dto, Materia.class);
		materiasDao.update(entity);
	}

	@Override
	public void saveOrUpdate(MateriaDto entity) {
		if (entity.getId() != null) 
			if (this.findById(entity.getId()) != null) {
				this.update(entity);	
				return;				
			}
		this.insert(entity);
	}

	@Override
	public MateriaDto insert(MateriaDto dto) {
		Materia entity = modelMapper.map(dto, Materia.class);
		dto = modelMapper.map(materiasDao.insert(entity), MateriaDto.class);
		return dto;
	}
	
	@Override
	public void remove(Long id) {
		materiasDao.remove(id);
	}

	@Override
	public void remove(MateriaDto entity) {
		if (entity.getId() != 0) {
			this.remove(entity.getId());
		}
	}

	@Override
	public List<MateriaDto> findByExample(MateriaDto example) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public void agregarProfesor(MateriaDto materia, ProfesorDto profesor) {
		List<ProfesorDto> profesores = materia.getProfesores();
		if (!profesores.contains(profesor)) {
			profesores.add(profesor);
		}this.update(materia);
	}
}
