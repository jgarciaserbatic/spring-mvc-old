package es.serbatic.dao.impl;

import org.hibernate.SessionFactory;

import es.serbatic.base.dao.impl.GenericDaoImpl;
import es.serbatic.bom.MateriaProfesor;
import es.serbatic.dao.MateriaProfesorDao;

public class MateriaProfesorDaoImpl extends GenericDaoImpl<MateriaProfesor, Long> implements MateriaProfesorDao{

	protected MateriaProfesorDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

}
