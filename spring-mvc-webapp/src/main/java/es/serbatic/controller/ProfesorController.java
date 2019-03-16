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

import es.serbatic.dto.ProfesoresDto;
import es.serbatic.services.ProfesoresService;

@RequestMapping("profesor")
@Controller
public class ProfesorController {
	
	private final String PROFESOR_VIEW = "profesores/list";
	private final String PROFESOR_ANADIR = "profesores/profesor";
	private final String ERROR_VIEW = "profesores/error";
	
	
	@Autowired
	ProfesoresService profesoresService;
		
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listarAlumnos(Model model) {
		List<ProfesoresDto> profesores = profesoresService.findAll();
		model.addAttribute("profesor", profesores);
		return new ModelAndView(PROFESOR_VIEW, model.asMap());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute("profesor", new ProfesoresDto());
		return new ModelAndView(PROFESOR_ANADIR, model.asMap());
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String insertarProfe(@ModelAttribute ProfesoresDto profesor, Model model) {
		if(profesor.getId() != null ) {
			profesoresService.update(profesor);
		} else {
			profesoresService.insert(profesor);
		}
		return "redirect:/profesor";
	}
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public ModelAndView showUpdateProfesor(@PathVariable Long id, Model model) {
		model.addAttribute("profesor", profesoresService.findById(id));
		return new ModelAndView(PROFESOR_ANADIR, model.asMap());
	}
	@RequestMapping("delete/{id}")
	public String eliminarProfesor(@PathVariable Long id, Model model) {
		profesoresService.remove(id);
		return "redirect:/profesor";
	}
	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView(ERROR_VIEW);
	}
}
