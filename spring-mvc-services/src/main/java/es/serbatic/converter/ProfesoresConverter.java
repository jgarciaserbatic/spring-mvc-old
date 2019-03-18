/**
 * 
 */
package es.serbatic.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import es.serbatic.bom.Asignaturas;
import es.serbatic.bom.Profesores;
import es.serbatic.dto.AsignaturasDto;
import es.serbatic.dto.ProfesoresDto;

/**
 * Convierte de Entidad profesores a Dto

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
		result.setDireccion(source.getDireccion());
		//ASIGNATURAS
		for(Asignaturas asignatura : source.getAsignaturas()) {
			AsignaturasDto asignaturasDto = new AsignaturasDto();
			asignaturasDto.setId(asignatura.getId());
			asignaturasDto.setNombre(asignatura.getNombre());
			asignaturasDto.setDescripcion(asignatura.getDescripcion());
			result.addAsignaturas(asignaturasDto);
		}
		
		return result;
	}


}
