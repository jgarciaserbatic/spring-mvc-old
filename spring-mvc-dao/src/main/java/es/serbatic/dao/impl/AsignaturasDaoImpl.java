/**
 * 
 */
package es.serbatic.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.serbatic.base.dao.impl.GenericDaoImpl;
import es.serbatic.bom.Asignaturas;
import es.serbatic.dao.AsignaturasDao;

/**
 * Implementa el acceso a datos de la tabla asignaturas
 * 
 */
@Repository("asignaturasDao")
public class AsignaturasDaoImpl extends GenericDaoImpl<Asignaturas, Long> implements AsignaturasDao {

	@Autowired
	protected AsignaturasDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}


}
