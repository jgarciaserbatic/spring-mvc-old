/**
 * 
 */
package es.serbatic.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.serbatic.base.dao.impl.GenericDaoImpl;
import es.serbatic.bom.Materia;
import es.serbatic.dao.MateriaDao;

/**
 * Implementa el acceso a datos de la tabla alumnos
 * 
 * @author jgarcia
 *
 */
@Repository("materiaDao")
public class MateriaDaoImpl extends GenericDaoImpl<Materia, Long> implements MateriaDao {

	@Autowired
	protected MateriaDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}


}
