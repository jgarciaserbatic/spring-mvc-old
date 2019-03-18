/**
 * 
 */
package es.serbatic.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import es.serbatic.bom.Alumnos;
import es.serbatic.dto.AlumnosDto;

/**
 * Convierte de Entidad alumnos a Dto
 * 
 * @author jgarcia
 *
 */
public class AlumnosConverter implements Converter<Alumnos, AlumnosDto> {

	@Override
	public AlumnosDto convert(MappingContext<Alumnos, AlumnosDto> context) {
		Alumnos source = context.getSource();
		AlumnosDto result = new AlumnosDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setApellido1(source.getApellido1());
		result.setApellido2(source.getApellido2());
		result.setMail(source.getMail());
		return result;
	}


}
