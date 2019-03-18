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
import es.serbatic.dto.MateriasDto;
import es.serbatic.dto.ProfesoresDto;
import es.serbatic.services.MateriasService;
import es.serbatic.services.ProfesoresService;

/**
 * Maneja las peticiones relacionadas con profesor
 * 
 * @author jgarcia
 *
 */
@RequestMapping("profesores")
@Controller
public class ProfesoresController {

	private final String LIST_VIEW = "profesores/list";
	private final String PROFESORES_VIEW = "profesores/profesor";
	private final String ERROR_VIEW = "profesores/error";

	@Autowired
	ProfesoresService profesoresService;
	
	@Autowired
	MateriasService materiasService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarProfesores(Model model) {	
		List<ProfesoresDto> profesores = profesoresService.findAll();
		model.addAttribute("profesores", profesores);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}

	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView(ERROR_VIEW);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		List<MateriasDto> materias = materiasService.findAll();
		model.addAttribute("materias", materias);
		model.addAttribute("profesor", new ProfesoresDto());
		return new ModelAndView(PROFESORES_VIEW, model.asMap());
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String insertarProfesor(@ModelAttribute ProfesoresDto profesor, Model model) {
		
		if(profesor.getId() != null) {
			profesoresService.update(profesor);
		} else {
			profesoresService.insert(profesor);
		}
		return "redirect:/profesores";
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public ModelAndView showUpdateProfesor(@PathVariable Long id, Model model) {
		model.addAttribute("profesor", profesoresService.findById(id));
		return new ModelAndView(PROFESORES_VIEW, model.asMap());
	}
	
	@RequestMapping("delete/{id}")
	public String eliminarProfesor(@PathVariable Long id, Model model) {
		profesoresService.remove(id);
		return "redirect:/profesores";
	}
	

}
