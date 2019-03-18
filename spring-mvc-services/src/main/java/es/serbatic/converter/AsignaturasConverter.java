/**
 * 
 */
package es.serbatic.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import es.serbatic.bom.Asignaturas;
import es.serbatic.dto.AsignaturasDto;
import es.serbatic.dto.ProfesoresDto;

/**
 * Convierte de Entidad alumnos a Dto
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
		ProfesoresDto profesorDto = new ProfesoresDto();
		profesorDto.setId(source.getProfesor().getId());
		profesorDto.setNombre(source.getProfesor().getNombre());
		profesorDto.setApellido1(source.getProfesor().getApellido1());
		profesorDto.setApellido2(source.getProfesor().getApellido2());
		result.setProfesor(profesorDto);
		result.setAlumnosAsignaturas(ConverterUtil.AlumnosAsignaturasConverter(source.getAlumnosAsignaturas()));
		return result;
	}


}
