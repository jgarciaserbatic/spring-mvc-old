package es.serbatic.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.serbatic.base.dao.impl.GenericDaoImpl;
import es.serbatic.bom.Profesor;
import es.serbatic.dao.ProfesoresDao;

/**
 * 
 * @author mcalonge
 *
 */
@Repository("profesoresDao")
public class ProfesorDaoImpl extends GenericDaoImpl<Profesor, Long> implements ProfesoresDao{

	@Autowired
	protected ProfesorDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}
