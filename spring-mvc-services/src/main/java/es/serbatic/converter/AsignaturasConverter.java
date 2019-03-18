/**
 * 
 */
package es.serbatic.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import es.serbatic.bom.Asignaturas;
import es.serbatic.dto.AsignaturasDto;

/**
 * Convierte de Entidad asignaturas a Dto
 * 
 * @author jgarcia
 *
 */
public class AsignaturasConverter implements Converter<Asignaturas, AsignaturasDto> {

	@Override
	public AsignaturasDto convert(MappingContext<Asignaturas, AsignaturasDto> context) {
		Asignaturas source = context.getSource();
		AsignaturasDto result = new AsignaturasDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setDescripcion(source.getDescripcion());		
		return result;
	}


}
