/**
 * @author mcalonge
 */
package es.serbatic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.serbatic.dto.AlumnosDto;
import es.serbatic.dto.ProfesorDto;
import es.serbatic.services.ProfesoresService;

/**
 * Maneja las peticiones relacionadas con profesores
 * 
 * @author mcalonge
 *
 */
@RequestMapping("profesores")
@Controller
public class ProfesorController {
	
	private final String LIST_VIEW = "profesores/list";
	private final String PROFESOR_VIEW = "profesores/alumno";
	
	ProfesoresService profesoresService;

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView mostrar() {

		return new ModelAndView(LIST_VIEW);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute("profesor", new ProfesorDto());
		return new ModelAndView(PROFESOR_VIEW, model.asMap());
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String insertarProfesor(@ModelAttribute ProfesorDto profesor, Model model) {
		if(profesor.getId() != null) {
			profesoresService.update(profesor);
		} else {
			profesoresService.insert(profesor);
		}
		return "redirect:/profesores";
	}
}
