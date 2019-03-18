package es.serbatic.converter;

import java.util.HashSet;
import java.util.Set;

import es.serbatic.bom.AlumnosAsignaturas;
import es.serbatic.bom.Profesores;
import es.serbatic.dto.AlumnosAsignaturasDto;
import es.serbatic.dto.AlumnosDto;
import es.serbatic.dto.AsignaturasDto;
import es.serbatic.dto.ProfesoresDto;

class ConverterUtil {
	public static Set<AlumnosAsignaturasDto> AlumnosAsignaturasConverter(Set<AlumnosAsignaturas> alas) {
		
		AlumnosDto alumno;
		AsignaturasDto asignatura;
		ProfesoresDto profesorDto;
		Profesores profesor;
		AlumnosAsignaturasDto alumnosAsignaturasDto;
		
		Set<AlumnosAsignaturasDto> alasDto = new HashSet<AlumnosAsignaturasDto>();
		
		
		for(AlumnosAsignaturas alumnosAsignaturas : alas) {
			
			alumno = new AlumnosDto();
			alumno.setId(alumnosAsignaturas.getPk().getAlumno().getId());
			alumno.setApellido1(alumnosAsignaturas.getPk().getAlumno().getApellido1());
			alumno.setApellido2(alumnosAsignaturas.getPk().getAlumno().getApellido2());
			
			asignatura = new AsignaturasDto();
			asignatura.setId(alumnosAsignaturas.getPk().getAsignatura().getId());
			asignatura.setNombre(alumnosAsignaturas.getPk().getAsignatura().getNombre());
			profesorDto = new ProfesoresDto();
			profesor = alumnosAsignaturas.getPk().getAsignatura().getProfesor();
			profesorDto.setId(profesor.getId());
			profesorDto.setNombre(profesor.getNombre());
			profesorDto.setApellido1(profesor.getApellido1());
			profesorDto.setApellido2(profesor.getApellido2());
	    	asignatura.setProfesor(profesorDto);
			
			alumnosAsignaturasDto = new AlumnosAsignaturasDto();
			alumnosAsignaturasDto.setAlumno(alumno);
			alumnosAsignaturasDto.setAsignatura(asignatura);
			alumnosAsignaturasDto.setNota(alumnosAsignaturas.getNota());
			alasDto.add(alumnosAsignaturasDto);
		}
		
		return null;
		
	}
}
