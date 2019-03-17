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


@RequestMapping("profesores")
@Controller
public class ProfesoresController {

	private final String LIST_VIEW = "profesores/profesor";
	private final String PROF_VIEW = "profesores/addProfesor";
	private final String ERROR_VIEW = "profesores/error";

	@Autowired
	ProfesoresService profesoresService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listarProfesores(Model model) {
		List<ProfesoresDto> prof = profesoresService.findAll();
		model.addAttribute("profesores", prof);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute("profesores", new ProfesoresDto());
		return new ModelAndView(PROF_VIEW, model.asMap());
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public ModelAndView showUpdateProfesor(@PathVariable Long id, Model model) {
		model.addAttribute("profesores", profesoresService.findById(id));
		return new ModelAndView(PROF_VIEW, model.asMap());
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String insertarProfesor(@ModelAttribute ProfesoresDto prf, Model model) {
		if(prf.getId() != null) {
			profesoresService.update(prf);
		} else {
			profesoresService.insert(prf);
		}
		return "redirect:/profesores";
	}
	
	@RequestMapping("delete/{id}")
	public String eliminarProfesor(@PathVariable Long id, Model model) {
		profesoresService.remove(id);
		return "redirect:/profesores";
	}
	
	@RequestMapping(value="assign/{id}/{id2}", method=RequestMethod.GET)
	public ModelAndView AsignaMateriaProfesor(@PathVariable Long id,@PathVariable Long id2, Model model) {
		profesoresService.asignaProfesorMateria(id, id2);
		List<ProfesoresDto> prof = profesoresService.findAll();
		model.addAttribute("profesores", prof);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}
	
	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView(ERROR_VIEW);
	}
}
