/**
 * 
 */
package es.serbatic.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.serbatic.base.dao.impl.GenericDaoImpl;
import es.serbatic.bom.AlumnosAsignaturas;
import es.serbatic.dao.AlumnosAsignaturasDao;

/**
 * Implementa el acceso a datos de la tabla alumnos
 * 
 * @author jgarcia
 *
 */
@Repository("alumnosAsignaturasDao")
public class AlumnosAsignaturasDaoImpl extends GenericDaoImpl<AlumnosAsignaturas, Long> implements AlumnosAsignaturasDao {

	@Autowired
	protected AlumnosAsignaturasDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}


}
