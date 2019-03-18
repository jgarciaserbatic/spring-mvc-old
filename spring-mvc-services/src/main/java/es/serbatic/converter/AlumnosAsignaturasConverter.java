/**
 * 
 */
package es.serbatic.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import es.serbatic.bom.AlumnosAsignaturas;
import es.serbatic.dto.AlumnosAsignaturasDto;
import es.serbatic.dto.AlumnosDto;
import es.serbatic.dto.AsignaturasDto;

/**
 * Convierte de Entidad alumnos a Dto
 * 
 * @author jgarcia
 *
 */
public class AlumnosAsignaturasConverter implements Converter<AlumnosAsignaturas, AlumnosAsignaturasDto> {


	@Override
	public AlumnosAsignaturasDto convert(MappingContext<AlumnosAsignaturas, AlumnosAsignaturasDto> context) {
		AlumnosAsignaturas source = context.getSource();
		AlumnosAsignaturasDto result = new AlumnosAsignaturasDto();
		
		AlumnosDto alumno = new AlumnosDto();
		alumno.setId(source.getPk().getAlumno().getId());
		alumno.setApellido1(source.getPk().getAlumno().getApellido1());
		alumno.setApellido2(source.getPk().getAlumno().getApellido2());
		
		AsignaturasDto asignatura = new AsignaturasDto();
		asignatura.setId(source.getPk().getAsignatura().getId());
		asignatura.setNombre(source.getPk().getAsignatura().getNombre());

		result.setAlumno(alumno);
		result.setAsignatura(asignatura);
		result.setNota(source.getNota());
		
		return result;
	}


}
