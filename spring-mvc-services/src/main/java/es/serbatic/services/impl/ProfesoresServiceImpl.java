package es.serbatic.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.serbatic.bom.Materias;
import es.serbatic.bom.Profesores;
import es.serbatic.dao.MateriasDao;
import es.serbatic.dao.ProfesoresDao;
import es.serbatic.dto.ProfesoresDto;
import es.serbatic.services.ProfesoresService;

@Service("profesoresService")
public class ProfesoresServiceImpl implements ProfesoresService {
	
	@Autowired
	private ProfesoresDao profesoresDao;
	
	@Autowired
	private MateriasDao materiasDao;
	
	@Autowired
	private ModelMapper modelMapper;

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
			result.add(modelMapper.map(profesor, ProfesoresDto.class));
		}
		return result;
	}

	@Override
	public List<ProfesoresDto> findAllOrderBy(String[] orderBy, boolean asc) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public void update(ProfesoresDto entity) {
		Profesores entity2 = modelMapper.map(entity, Profesores.class);
		profesoresDao.update(entity2);
	}

	@Override
	public void saveOrUpdate(ProfesoresDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public ProfesoresDto insert(ProfesoresDto dto) {
		Profesores entity = modelMapper.map(dto, Profesores.class);
		dto = modelMapper.map(profesoresDao.insert(entity), ProfesoresDto.class);
		return dto;
	}

	@Override
	public void remove(ProfesoresDto entity) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	@Override
	public void remove(Long id) {
		profesoresDao.remove(id);		
	}

	@Override
	public List<ProfesoresDto> findByExample(ProfesoresDto example) {
		throw new NotYetImplementedException("Método no implementado todavía");
	}

	public List<ProfesoresDto> findprofesorAsignatura(Long id) {
		List<Profesores> prf= profesoresDao.findAll();
		List<ProfesoresDto> result = new ArrayList<>();
		for(int i =0; i< prf.size();i++) {
			for (int k =0; k< prf.size();k++) {
				if(prf.get(i).getListMaterias().get(k).getId().equals(id)) {
					ProfesoresDto elemento = new ProfesoresDto();
					elemento.setId(prf.get(i).getId());
					elemento.setName(prf.get(i).getName());
					elemento.setSurname1(prf.get(i).getSurname1());
					elemento.setSurname2(prf.get(i).getSurname2());
					result.add(elemento);
				}
		}
			}
		
		return result;
	}
	
	public void asignaProfesorMateria(Long id, Long id2) {
		Profesores pf = profesoresDao.findById(id);
		Materias m = materiasDao.findById(id2);
		List<Materias> listMaterias = new ArrayList<>();
		listMaterias.add(m);
		pf.setListMaterias(listMaterias);
	}
}
