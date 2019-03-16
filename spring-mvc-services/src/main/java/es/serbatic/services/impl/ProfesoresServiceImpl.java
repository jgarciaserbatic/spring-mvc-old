package es.serbatic.services.impl;

import java.util.ArrayList;

/**
 * @author mcalonge
 */

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.serbatic.bom.Alumnos;
import es.serbatic.bom.Profesor;
import es.serbatic.dao.ProfesoresDao;
import es.serbatic.dto.AlumnosDto;
import es.serbatic.dto.ProfesorDto;
import es.serbatic.services.ProfesoresService;

@Service("ProfesoresService")

public class ProfesoresServiceImpl implements ProfesoresService{
	//Accede a BBDD con DAO y se trae BOM y convertimos a DTO para devolver Modelo a Vista

	@Autowired
	ProfesoresDao profesoresDao; //Se trae de BOM
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProfesorDto findById(Long id) {
		
		//Prueba
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProfesorDto> findAll() {
		List<Profesor> listadoProfesoresDao=profesoresDao.findAll();
		List<ProfesorDto> listadoProfesoresDTO= new ArrayList<>();
		
		if(listadoProfesoresDao.isEmpty()) {
			return listadoProfesoresDTO;
		}
		
		for(Profesor profesor : listadoProfesoresDao) {
			
			listadoProfesoresDTO.add(convertBomToEntity(profesor));
		}
		return listadoProfesoresDTO;
	}
	
	private ProfesorDto convertBomToEntity(Profesor profesorBom) {
		
		ProfesorDto profesorDtoEntity = new ProfesorDto();
		
		profesorDtoEntity.setApellido1(profesorBom.getApellido1());
		profesorDtoEntity.setApellido2(profesorBom.getApellido2());
		profesorDtoEntity.setNombre(profesorBom.getNombre());
		profesorDtoEntity.setApariencia(profesorBom.getApariencia());
		return profesorDtoEntity;
		
	}
	@Override
	public ProfesorDto insert(ProfesorDto dto) {
		Profesor entity = modelMapper.map(dto, Profesor.class);
		dto = modelMapper.map(profesoresDao.insert(entity), ProfesorDto.class);
		return dto;
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
	public void remove(ProfesorDto entity) {
		// TODO ESTE
		
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
