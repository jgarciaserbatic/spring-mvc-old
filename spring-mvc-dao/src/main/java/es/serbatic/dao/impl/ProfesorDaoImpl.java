/**
 * 
 */
package es.serbatic.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.serbatic.base.dao.impl.GenericDaoImpl;
import es.serbatic.bom.Profesor;
import es.serbatic.dao.ProfesorDao;

/**
 * Implementa el acceso a datos de la tabla alumnos
 * 
 * @author jgarcia
 *
 */
@Repository("profesorDao")
public class ProfesorDaoImpl extends GenericDaoImpl<Profesor, Long> implements ProfesorDao {

	@Autowired
	protected ProfesorDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}


}