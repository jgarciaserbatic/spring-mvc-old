package es.serbatic.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.serbatic.base.dao.impl.GenericDaoImpl;
import es.serbatic.bom.Alumnos;
import es.serbatic.dao.ProfesoresDao;

@Repository("ProfesoresDao")
public class ProfesorDaoImpl extends GenericDaoImpl<Alumnos, Long> implements ProfesoresDao{

	protected ProfesorDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}
