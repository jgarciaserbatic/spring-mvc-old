/**
 * 
 */
package es.serbatic.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import es.serbatic.bom.AlumnosAsignaturas;
import es.serbatic.dto.AlumnosAsignaturasDto;
import es.serbatic.dto.AsignaturasDto;
import es.serbatic.bom.Asignaturas;

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
		result.setIdProfesor(source.getIdProfesor());
		result.setAlumnosAsignaturas(ConverterUtil.AlumnosAsignaturasConverter(source.getAlumnosAsignaturas()));
		return result;
	}


}
