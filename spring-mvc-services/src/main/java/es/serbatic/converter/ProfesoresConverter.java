package es.serbatic.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import es.serbatic.bom.Materias;
import es.serbatic.bom.Profesores;
import es.serbatic.dto.MateriasDto;
import es.serbatic.dto.ProfesoresDto;

public class ProfesoresConverter implements Converter<Profesores, ProfesoresDto> {

	@Override
	public ProfesoresDto convert(MappingContext<Profesores, ProfesoresDto> context) {
		Profesores source = context.getSource();
		ProfesoresDto result = new ProfesoresDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		result.setApellido1(source.getApellido1());
		result.setApellido2(source.getApellido2());
		result.setFechaAlta(source.getFechaAlta());
        for(Materias materia : source.getMaterias()) {
            MateriasDto materiasDto = new MateriasDto();
            materiasDto.setId(materia.getId());
            materiasDto.setNombre(materia.getNombre());
           
            result.addMaterias(materiasDto);
        }

		return result;
	}

}
