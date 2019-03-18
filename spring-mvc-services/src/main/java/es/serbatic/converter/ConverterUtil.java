package es.serbatic.converter;

import java.util.HashSet;
import java.util.Set;

import es.serbatic.bom.AlumnosAsignaturas;
import es.serbatic.dto.AlumnosAsignaturasDto;
import es.serbatic.dto.AlumnosDto;
import es.serbatic.dto.AsignaturasDto;

class ConverterUtil {
	public static Set<AlumnosAsignaturasDto> AlumnosAsignaturasConverter(Set<AlumnosAsignaturas> alas) {
		
		Set<AlumnosAsignaturasDto> alasDto = new HashSet<AlumnosAsignaturasDto>();
		
		for(AlumnosAsignaturas alumnosAsignaturas : alas) {
			
			AlumnosDto alumno = new AlumnosDto();
			alumno.setId(alumnosAsignaturas.getPk().getAlumno().getId());
			alumno.setApellido1(alumnosAsignaturas.getPk().getAlumno().getApellido1());
			alumno.setApellido2(alumnosAsignaturas.getPk().getAlumno().getApellido2());
			
			AsignaturasDto asignatura = new AsignaturasDto();
			asignatura.setId(alumnosAsignaturas.getPk().getAsignatura().getId());
			asignatura.setNombre(alumnosAsignaturas.getPk().getAsignatura().getNombre());
			
			AlumnosAsignaturasDto alumnosAsignaturasDto = new AlumnosAsignaturasDto();
			alumnosAsignaturasDto.setAlumno(alumno);
			alumnosAsignaturasDto.setAsignatura(asignatura);
			alumnosAsignaturasDto.setNota(alumnosAsignaturas.getNota());
			alasDto.add(alumnosAsignaturasDto);
		}
		
		return null;
		
	}
}
