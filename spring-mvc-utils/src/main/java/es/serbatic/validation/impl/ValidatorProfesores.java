package es.serbatic.validation.impl;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import es.serbatic.dto.AlumnosDto;
import es.serbatic.dto.ProfesoresDto;
import es.serbatic.validation.Validator;

public class ValidatorProfesores implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ProfesoresDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProfesoresDto profesorDto = (ProfesoresDto) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "field.profesor.nombre.required", "Nombre requerido");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido1", "field.profesor.primerApellido.required", "Primer apellido requerido");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fechaAlta", "field.profesor.fecha.required","fecha de alta requerida");

		if (profesorDto.getFechaAlta() == null && !errors.hasFieldErrors("fechaAlta")) {
			errors.rejectValue("fechaAlta", "field.fecha.required");

		}
	}

}
