/**
 * 
 */
package es.serbatic.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import es.serbatic.bom.Materia;
import es.serbatic.dto.MateriaDto;

/**
 * Convierte de Entidad alumnos a Dto
 * 
 * @author jgarcia
 *
 */
public class MateriasConverter implements Converter<Materia, MateriaDto> {
	
	@Override
	public MateriaDto convert(MappingContext<Materia, MateriaDto> context) {
		Materia source = context.getSource();
		MateriaDto result = new MateriaDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		return result;
	}


}
