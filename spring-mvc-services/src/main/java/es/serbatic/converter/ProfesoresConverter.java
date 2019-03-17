package es.serbatic.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import es.serbatic.bom.Profesores;
import es.serbatic.dto.ProfesoresDto;



public class ProfesoresConverter implements Converter<Profesores, ProfesoresDto> {

	@Override
	public ProfesoresDto convert(MappingContext<Profesores, ProfesoresDto> context) {
		Profesores source = context.getSource();
		ProfesoresDto result = new ProfesoresDto();
		result.setId(source.getId());
		result.setName(source.getName());
		result.setSurname1(source.getSurname1());
		result.setSurname2(source.getSurname2());
		//result.setSubject(source.getSubject());
		return result;
	}
	
	

}
