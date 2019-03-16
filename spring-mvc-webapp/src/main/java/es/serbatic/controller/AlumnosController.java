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

import es.serbatic.dto.AlumnosDto;
import es.serbatic.services.AlumnosService;

/**
 * Maneja las peticiones relacionadas con alumno
 * 
 * @author jgarcia
 *
 */
@RequestMapping("alumnos")
@Controller
public class AlumnosController {
	
	private final String LIST_VIEW = "alumnos/list";
	private final String ALUMNO_VIEW = "alumnos/alumno";
	private final String ERROR_VIEW = "alumnos/error";

	@Autowired
	AlumnosService alumnosService;
	
	@ModelAttribute("alumno")
	public AlumnosDto populateForm() {
		return new AlumnosDto();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listarAlumnos(Model model) {
		List<AlumnosDto> alumnos = alumnosService.findAll();
		model.addAttribute("alumnos", alumnos);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		if (!model.containsAttribute("alumno")) {
			model.addAttribute("alumno", new AlumnosDto());
		}
		return new ModelAndView(ALUMNO_VIEW, model.asMap());
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public ModelAndView showUpdateAlumno(@PathVariable Long id, Model model) {
		model.addAttribute("alumno", alumnosService.findById(id));
		return new ModelAndView(ALUMNO_VIEW, model.asMap());
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public ModelAndView insertarAlumno( @ModelAttribute @Valid AlumnosDto alumno, BindingResult result,  Model model) {
		ModelAndView view;
		if(result.hasErrors()) {
			view = this.showNewPage(model);
		}else {
			if(alumno.getId() != null) {
				alumnosService.update(alumno);
			} else {
				alumnosService.insert(alumno);
			}
			view = this.listarAlumnos(model);
		}
		
		return view;
	}
	
	@RequestMapping("delete/{id}")
	public String eliminarAlumno(@PathVariable Long id, Model model) {
		alumnosService.remove(id);
		return "redirect:/alumnos";
	}
	
	
	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView(ERROR_VIEW);
	}
	
}
