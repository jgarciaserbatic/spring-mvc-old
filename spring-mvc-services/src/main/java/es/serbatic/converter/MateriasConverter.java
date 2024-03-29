/**
 * 
 */
package es.serbatic.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import es.serbatic.bom.Materias;
import es.serbatic.dto.MateriasDto;

/**
 * Convierte de Entidad Materias a Dto
 * 
 * @author jgarcia
 *
 */
public class MateriasConverter implements Converter<Materias, MateriasDto> {

	@Override
	public MateriasDto convert(MappingContext<Materias, MateriasDto> context) {
		Materias source = context.getSource();
		MateriasDto result = new MateriasDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setHoras(source.getHoras());
		return result; 
	}


}
