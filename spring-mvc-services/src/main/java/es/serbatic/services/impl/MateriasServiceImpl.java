package es.serbatic.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.serbatic.bom.Materias;
import es.serbatic.dao.MateriasDao;
import es.serbatic.dto.MateriasDto;
import es.serbatic.services.MateriasService;

@Service("materiasService")
public class MateriasServiceImpl implements MateriasService {

	@Autowired
	private MateriasDao materiasDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(MateriasDto entity) {
		Materias entity2 = modelMapper.map(entity, Materias.class);
		materiasDao.update(entity2);
	}

	@Override
	public void saveOrUpdate(MateriasDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MateriasDto insert(MateriasDto dto) {
		Materias entity = modelMapper.map(dto, Materias.class);
		dto = modelMapper.map(materiasDao.insert(entity), MateriasDto.class);
		return dto;
	}

	@Override
	public void remove(MateriasDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long id) {
		materiasDao.remove(id);	
		
	}

	@Override
	public List<MateriasDto> findByExample(MateriasDto example) {
		// TODO Auto-generated method stub
		return null;
	}

}
