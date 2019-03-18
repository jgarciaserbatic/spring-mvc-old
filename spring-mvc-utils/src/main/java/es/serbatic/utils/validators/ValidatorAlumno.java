package es.serbatic.utils.validators;

import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import es.serbatic.dto.AlumnosDto;

/**
 * @author smartinez
 *  Valdidador para alumno
 *
 */
@Component
public class ValidatorAlumno extends BeanDefinitionVisitor implements Validator {
	
	//Clase que da soporte el validador
	public boolean supports(Class<?> clazz) {		
		return AlumnosDto.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {

		
		AlumnosDto alumno = (AlumnosDto) target;
		
				
		// El nombre es obligatorio
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "field.required", "El nombre del alumno es obligatorio");
		
		//la apellido es obligatorio,
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido1", "field.required", "El apellido es obligatorio");
		
		//la apellido es obligatorio,
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido2", "field.required", "El apellido es obligatorio");
		
	}
}
