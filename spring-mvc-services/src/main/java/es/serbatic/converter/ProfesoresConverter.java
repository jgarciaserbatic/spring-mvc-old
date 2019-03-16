/**
 * 
 */
package es.serbatic.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.serbatic.bom.Materias;
import es.serbatic.bom.Profesores;
import es.serbatic.dto.MateriasDto;
import es.serbatic.dto.ProfesoresDto;

/**
 * Convierte de Entidad Profesores a Dto
 * 
 * @author jgarcia
 *
 */
public class ProfesoresConverter implements Converter<Profesores, ProfesoresDto> {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public ProfesoresDto convert(MappingContext<Profesores, ProfesoresDto> context) {
		logger.debug("Convirtiendo entidad Profesores a dto");
		Profesores source = context.getSource();
		ProfesoresDto result = new ProfesoresDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setApellido1(source.getApellido1());
		result.setApellido2(source.getApellido2());
		for(Materias materia : source.getMaterias()) {
			MateriasDto materiasDto = new MateriasDto();
			materiasDto.setId(materia.getId());
			materiasDto.setNombre(materia.getNombre());
			materiasDto.setHoras(materia.getHoras());
			result.addMaterias(materiasDto);
		}
		return result;
	}


}
