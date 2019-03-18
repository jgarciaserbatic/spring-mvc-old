/**
 * 
 */
package es.serbatic.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import es.serbatic.bom.Profesores;
import es.serbatic.bom.Asignaturas;
import es.serbatic.dto.AsignaturasDto;
import es.serbatic.dto.ProfesoresDto;

/**
 * Convierte de Entidad profesores a Dto
 * 
 * @author jgarcia
 *
 */
public class ProfesoresConverter implements Converter<Profesores, ProfesoresDto> {

	@Override
	public ProfesoresDto convert(MappingContext<Profesores, ProfesoresDto> context) {
		Profesores source = context.getSource();
		ProfesoresDto result = new ProfesoresDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setApellido1(source.getApellido1());
		result.setApellido2(source.getApellido2());
		
		
		List<Asignaturas> asignaturas = new ArrayList<Asignaturas>(source.getAsignaturas());
		List<AsignaturasDto> asignaturasDto = new ArrayList<AsignaturasDto>();
		for (Asignaturas asignatura : asignaturas) {
			asignaturasDto.add(new AsignaturasDto(asignatura.getId(), asignatura.getIdProfesor(), asignatura.getNombre()));
		}
		result.setAsignaturas(asignaturasDto);
		return result;
	}


}
