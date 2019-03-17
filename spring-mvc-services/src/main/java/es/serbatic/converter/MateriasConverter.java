package es.serbatic.converter;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import es.serbatic.bom.Materias;
import es.serbatic.dto.MateriasDto;

public class MateriasConverter implements Converter<Materias, MateriasDto> {

	@Override
	public MateriasDto convert(MappingContext<Materias, MateriasDto> context) {
		Materias source = context.getSource();
		MateriasDto result = new MateriasDto();
		result.setId(source.getId());
		result.setNombre(source.getNombre());
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
		Date fecha = new Date();
		try {
			fecha =  format1.parse(format1.format(source.getFechaExamen()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result.setFechaExamen(fecha);
		return result;
	}
	
	

}
