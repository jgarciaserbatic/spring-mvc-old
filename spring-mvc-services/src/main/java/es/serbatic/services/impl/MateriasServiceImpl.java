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
public class MateriasServiceImpl implements MateriasService{

	@Autowired
	MateriasDao materiasDao;
	
	@Autowired
	private ModelMapper modelMapper;
		
	public MateriasServiceImpl() {
		super();
	}

	@Override
	public MateriasDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MateriasDto> findAll() {
		List<MateriasDto> result = new ArrayList<>();
		List<Materias> found = materiasDao.findAll();
		for(Materias materia: found) {
			result.add(modelMapper.map(materia, MateriasDto.class));
		}
		return result;
	}

	@Override
	public List<MateriasDto> findAllOrderBy(String[] orderBy, boolean asc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(MateriasDto dto) {
		Materias entity = modelMapper.map(dto, Materias.class);
		materiasDao.update(entity);
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MateriasDto> findByExample(MateriasDto example) {
		// TODO Auto-generated method stub
		return null;
	}

}
