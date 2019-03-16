package es.serbatic.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.serbatic.base.dao.impl.GenericDaoImpl;
import es.serbatic.bom.Materias;
import es.serbatic.dao.MateriasDao;

@Repository("MateriasDao")
public class MateriasDaoImpl extends GenericDaoImpl<Materias, Long> implements MateriasDao {
	
	@Autowired
	protected MateriasDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

}
