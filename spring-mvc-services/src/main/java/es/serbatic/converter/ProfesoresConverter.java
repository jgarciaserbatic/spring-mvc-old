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
		
		AsignaturasDto asignaturaDto;
		List<Asignaturas> asignaturas = new ArrayList<Asignaturas>(source.getAsignaturas());
		List<AsignaturasDto> asignaturasDto = new ArrayList<AsignaturasDto>();
		for (Asignaturas asignatura : asignaturas) {
			asignaturaDto = new AsignaturasDto();
			asignaturaDto.setId(source.getId());
			asignaturaDto.setNombre(source.getNombre());
			ProfesoresDto profesorDto = new ProfesoresDto();
			profesorDto.setId(asignatura.getProfesor().getId());
			profesorDto.setNombre(asignatura.getProfesor().getNombre());
			profesorDto.setApellido1(asignatura.getProfesor().getApellido1());
			profesorDto.setApellido2(asignatura.getProfesor().getApellido2());
			asignaturaDto.setProfesor(profesorDto);
			asignaturasDto.add(asignaturaDto);
		}
		result.setAsignaturas(asignaturasDto);
		return result;
	}


}
