/**
 * 
 */
package es.serbatic.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.serbatic.base.dao.impl.GenericDaoImpl;
import es.serbatic.bom.Alumnos;
import es.serbatic.dao.AlumnosDao;

@Repository("alumnosDao")
public class AlumnosDaoImpl extends GenericDaoImpl<Alumnos, Long> implements AlumnosDao {

	@Autowired
	protected AlumnosDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}


}
