package es.serbatic.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.serbatic.bom.Alumnos;
import es.serbatic.bom.Materia;
import es.serbatic.dao.AlumnosDao;
import es.serbatic.dao.MateriaDao;
import es.serbatic.dto.AlumnosDto;
import es.serbatic.dto.MateriaDto;
import es.serbatic.services.MateriaService;

@Service("materiaService")
public class MateriaServiceImpl implements MateriaService {

	
	@Autowired
	MateriaDao materiaDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public MateriaDto findById(Long id) {
		Materia entity = materiaDao.findById(id);
		return modelMapper.map(entity, MateriaDto.class);
	}

	@Override
	public List<MateriaDto> findAll() {
		List<MateriaDto> result = new ArrayList<>();
		List<Materia> found = materiaDao.findAll();
		for(Materia materia: found) {
			result.add(modelMapper.map(materia, MateriaDto.class));
		}
		return result;
	}

	@Override
	public List<MateriaDto> findAllOrderBy(String[] orderBy, boolean asc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(MateriaDto dto) {
		Materia entity = modelMapper.map(dto, Materia.class);
		materiaDao.update(entity);
	}

	@Override
	public void saveOrUpdate(MateriaDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MateriaDto insert(MateriaDto dto) {
		Materia entity = modelMapper.map(dto, Materia.class);
		dto = modelMapper.map(materiaDao.insert(entity), MateriaDto.class);
		return dto;
	}

	@Override
	public void remove(MateriaDto entity) {

		
	}

	@Override
	public void remove(Long id) {
		materiaDao.remove(id);
		
	}

	@Override
	public List<MateriaDto> findByExample(MateriaDto example) {
		// TODO Auto-generated method stub
		return null;
	}

}
