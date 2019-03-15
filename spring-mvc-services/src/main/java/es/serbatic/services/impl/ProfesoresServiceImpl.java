package es.serbatic.services.impl;

/**
 * @author mcalonge
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.serbatic.dao.ProfesoresDao;
import es.serbatic.dto.ProfesorDto;
import es.serbatic.services.ProfesoresService;

@Service("ProfesoresService")

public class ProfesoresServiceImpl implements ProfesoresService{
	

	@Autowired
	ProfesoresDao profesoresDao;

	@Override
	public ProfesorDto findById(Long id) {
		
		//Prueba
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProfesorDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProfesorDto> findAllOrderBy(String[] orderBy, boolean asc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ProfesorDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(ProfesorDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProfesorDto insert(ProfesorDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(ProfesorDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProfesorDto> findByExample(ProfesorDto example) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
