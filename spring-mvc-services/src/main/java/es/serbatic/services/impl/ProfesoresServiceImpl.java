package es.serbatic.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.serbatic.bom.Profesores;
import es.serbatic.dao.ProfesoresDao;
import es.serbatic.dto.ProfesoresDto;
import es.serbatic.services.ProfesoresService;

@Service("profesoresService")
public class ProfesoresServiceImpl implements ProfesoresService{

	@Autowired
	ProfesoresDao profesoresDao;
	
	@Autowired
	private ModelMapper modelMapper;	
	
	public ProfesoresServiceImpl() {
		super();
	}
	
	@Override
	public ProfesoresDto findById(Long id) {
		
		return modelMapper.map(profesoresDao.findById(id), ProfesoresDto.class); 
	}

	@Override
	public List<ProfesoresDto> findAll() {
		List<ProfesoresDto> result = new ArrayList<>();
		List<Profesores> found = profesoresDao.findAll();
		for(Profesores profesor: found) {
			result.add(modelMapper.map(profesor, ProfesoresDto.class));
		}
		return result;
	}

	@Override
	public List<ProfesoresDto> findAllOrderBy(String[] orderBy, boolean asc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ProfesoresDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(ProfesoresDto entity) {

		profesoresDao.saveOrUpdate( modelMapper.map(entity, Profesores.class) );
		
	}

	@Override
	public ProfesoresDto insert(ProfesoresDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(ProfesoresDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long id) {
		
		profesoresDao.remove(id);
	}

	@Override
	public List<ProfesoresDto> findByExample(ProfesoresDto example) {
		// TODO Auto-generated method stub
		return null;
	}

}
