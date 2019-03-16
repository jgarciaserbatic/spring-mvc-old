package es.serbatic.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.serbatic.base.dao.impl.GenericDaoImpl;
import es.serbatic.bom.Profesores;
import es.serbatic.dao.ProfesoresDao;

@Repository("profesoresDao")
public class ProfesoresDaoImpl extends GenericDaoImpl<Profesores, Long> implements ProfesoresDao {
	
	@Autowired
	protected ProfesoresDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}