/**
 * 
 */
package es.serbatic.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import es.serbatic.bom.Alumno;
import es.serbatic.dto.AlumnoDto;

/**
 * Convierte de Entidad alumnos a Dto
 * 
 * @author jgarcia
 *
 */
public class AlumnosConverter implements Converter<Alumno, AlumnoDto> {

	@Override
	public AlumnoDto convert(MappingContext<Alumno, AlumnoDto> context) {
		Alumno source = context.getSource();
		AlumnoDto result = new AlumnoDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setApellido1(source.getApellido1());
		result.setApellido2(source.getApellido2());
		return result;
	}


}
