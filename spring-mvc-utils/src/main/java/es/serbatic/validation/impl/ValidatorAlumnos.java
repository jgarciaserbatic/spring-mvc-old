package es.serbatic.validation.impl;

import org.springframework.validation.Errors;

import es.serbatic.dto.AlumnosDto;
import es.serbatic.validation.Validator;

public class ValidatorAlumnos implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return AlumnosDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
