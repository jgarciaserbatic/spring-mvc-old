package es.serbatic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.serbatic.dao.AlumnosDao;
import es.serbatic.dao.ProfesoresDao;
import es.serbatic.dto.AlumnosDto;
import es.serbatic.services.AlumnosService;
import es.serbatic.services.ProfesoresService;

@Service("ProfesoresService")

public class ProfesoresServiceImpl implements ProfesoresService{
	

	@Autowired
	ProfesoresDao profesoresDao;

	@Override
	public AlumnosDto findById(Long id) {
		
		//Prueba
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlumnosDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlumnosDto> findAllOrderBy(String[] orderBy, boolean asc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(AlumnosDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(AlumnosDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AlumnosDto insert(AlumnosDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(AlumnosDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AlumnosDto> findByExample(AlumnosDto example) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
