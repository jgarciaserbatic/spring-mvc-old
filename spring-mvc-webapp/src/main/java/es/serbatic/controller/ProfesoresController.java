/**
 * 
 */
package es.serbatic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.serbatic.dto.ProfesoresDto;
import es.serbatic.services.MateriasService;
import es.serbatic.services.ProfesoresService;

@RequestMapping("profesores")
@Controller
public class ProfesoresController {
	
	private final String LIST_VIEW = "profesores/list";
	private final String PROFESOR_VIEW = "profesores/profesor";
	private final String ERROR_VIEW = "profesores/error";
	private final String REDIRECT_TO_LIST = "redirect:/profesores";
	private final String MODEL_NAME = "profesor";

	@Autowired
	ProfesoresService profesoresService;
	
	@Autowired
	MateriasService materiasService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listarProfesores(Model model) {
		List<ProfesoresDto> profesores = profesoresService.findAll();
		model.addAttribute("profesores", profesores);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute(MODEL_NAME, new ProfesoresDto());
		model.addAttribute("materias", materiasService.findAll());
		return new ModelAndView(PROFESOR_VIEW, model.asMap());
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public ModelAndView showUpdateProfesor(@PathVariable Long id, Model model) {
		model.addAttribute(MODEL_NAME, profesoresService.findById(id));
		model.addAttribute("materias", materiasService.findAll());
		return new ModelAndView(PROFESOR_VIEW, model.asMap());
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String insertarProfesor(@Valid @ModelAttribute ProfesoresDto profesor, BindingResult result, Model model) {
		if(profesor.getId() != null) {
			profesoresService.update(profesor);
		} else {
			profesoresService.insert(profesor);
		}
		return REDIRECT_TO_LIST;
	}
	
	@RequestMapping("delete/{id}")
	public String eliminarProfesor(@PathVariable Long id, Model model) {
		profesoresService.remove(id);
		return REDIRECT_TO_LIST;
	}
	
	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView(ERROR_VIEW);
	}
	
}
