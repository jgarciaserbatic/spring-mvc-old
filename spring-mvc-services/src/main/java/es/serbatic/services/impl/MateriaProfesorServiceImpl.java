package es.serbatic.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.serbatic.bom.MateriaProfesor;
import es.serbatic.bom.Profesores;
import es.serbatic.dao.AlumnosDao;
import es.serbatic.dao.MateriaDao;
import es.serbatic.dao.MateriaProfesorDao;
import es.serbatic.dao.ProfesoresDao;
import es.serbatic.dto.MateriaDto;
import es.serbatic.dto.MateriaProfesorDto;
import es.serbatic.dto.ProfesoresDto;
import es.serbatic.services.AlumnosService;
import es.serbatic.services.MateriaProfesoresService;

@Service("materiaProfService")
public class MateriaProfesorServiceImpl implements MateriaProfesoresService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	MateriaProfesorDao materiaProfesorDao;
	
	@Override
	public MateriaProfesorDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MateriaProfesorDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MateriaProfesorDto> findAllOrderBy(String[] orderBy, boolean asc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(MateriaProfesorDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(MateriaProfesorDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MateriaProfesorDto insert(MateriaProfesorDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(MateriaProfesorDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MateriaProfesorDto> findByExample(MateriaProfesorDto example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarIdProfesor(Long id) {
		
	}

	@Override
	public void guardarIdAsignatura(Long id) {
		// TODO Auto-generated method stub
		
	}


	

}
