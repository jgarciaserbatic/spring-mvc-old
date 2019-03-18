/**
 * 
 */
package es.serbatic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.Field;

import es.serbatic.dto.ProfesoresDto;
import es.serbatic.services.ProfesoresService;

/**
 * Maneja las peticiones relacionadas con los profesores
 * 
 * @author dballesteros
 *
 */
@RequestMapping("profesores")
@Controller
public class ProfesoresController {

	Logger log = LoggerFactory.getLogger(ProfesoresController.class);

	private final String LIST_VIEW = "profesores/list";
	private final String PROFESOR_VIEW = "profesores/profesor";
	private final String ERROR_VIEW = "profesor/error";

	@Autowired
	ProfesoresService profesoresService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarProfesores(Model model) {
		List<ProfesoresDto> profesores = profesoresService.findAll();
		model.addAttribute("profesores", profesores);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute("profesor", new ProfesoresDto());
		return new ModelAndView(PROFESOR_VIEW, model.asMap());
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView showUpdateProfesor(@PathVariable Long id, Model model) {
		model.addAttribute("profesor", profesoresService.findById(id));
		return new ModelAndView(PROFESOR_VIEW, model.asMap());
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public ModelAndView insertarProfesor(@ModelAttribute ProfesoresDto profesor, BindingResult result, Model model) {
				
//		if(result.hasErrors()) {
//			List<String> errors = new ArrayList<String>();
//            for (ObjectError err : result.getAllErrors())
//                errors.add(err.getDefaultMessage());
//
//            model.addAttribute("errors", errors);
//			model.addAttribute("profesor", profesor);
//			return new ModelAndView(PROFESOR_VIEW, model.asMap());
//		}
//		
//		else if(profesor.getId() != null) {
//			profesoresService.update(profesor);
//		} else {
//				profesoresService.insert(profesor);
//		}
		return new ModelAndView("redirect:/profesores");
	}

	@RequestMapping("delete/{id}")
	public String eliminarProfesor(@PathVariable Long id, Model model) {
		profesoresService.remove(id);
		return "redirect:/profesores";
	}

	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView(ERROR_VIEW);
	}

}
