/**
 * 
 */
package es.serbatic.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;

import es.serbatic.bom.Materia;
import es.serbatic.bom.Profesor;
import es.serbatic.dto.MateriaDto;
import es.serbatic.dto.ProfesorDto;
import es.serbatic.services.MateriasService;

/**
 * Convierte de Entidad alumnos a Dto
 * 
 * @author jgarcia
 *
 */
public class ProfesoresConverter implements Converter<Profesor, ProfesorDto> {

	@Autowired
	private MateriasService materiasService;

	@Override
	public ProfesorDto convert(MappingContext<Profesor, ProfesorDto> context) {
		Profesor source = context.getSource();
		ProfesorDto result = new ProfesorDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setApellido1(source.getApellido1());
		result.setApellido2(source.getApellido2());
		result.setFechaAlta(source.getFechaAlta());

		List<MateriaDto> resultList = new ArrayList<MateriaDto>();

		for (Materia materia : source.getMaterias()) {
			resultList.add(materiasService.findById(materia.getId()));
		}

		result.setMaterias(resultList);

		return result;
	}

}
