/**
 * 
 */
package es.serbatic.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.serbatic.base.dao.impl.GenericDaoImpl;
import es.serbatic.bom.Alumno;
import es.serbatic.dao.AlumnoDao;

/**
 * Implementa el acceso a datos de la tabla alumnos
 * 
 * @author jgarcia
 *
 */
@Repository("alumnoDao")
public class AlumnoDaoImpl extends GenericDaoImpl<Alumno, Long> implements AlumnoDao {

	@Autowired
	protected AlumnoDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}


}
