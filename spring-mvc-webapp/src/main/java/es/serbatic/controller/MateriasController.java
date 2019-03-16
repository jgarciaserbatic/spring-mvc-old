/**
 * 
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

import es.serbatic.dto.MateriasDto;
import es.serbatic.services.MateriasService;

/**
 * Maneja las peticiones relacionadas con materias
 * 
 * @author jgarcia
 *
 */
@RequestMapping("materias")
@Controller
public class MateriasController {
	
	private final String LIST_VIEW = "materias/list";
	private final String PROFESOR_VIEW = "materias/materia";
	private final String ERROR_VIEW = "materias/error";
	private final String REDIRECT_TO_LIST = "redirect:/materias";
	private final String MODEL_NAME = "materia";

	@Autowired
	MateriasService materiasService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listarMaterias(Model model) {
		List<MateriasDto> profesores = materiasService.findAll();
		model.addAttribute("materias", profesores);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute(MODEL_NAME, new MateriasDto());
		return new ModelAndView(PROFESOR_VIEW, model.asMap());
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public ModelAndView showUpdateMateria(@PathVariable Long id, Model model) {
		model.addAttribute(MODEL_NAME, materiasService.findById(id));
		return new ModelAndView(PROFESOR_VIEW, model.asMap());
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String insertarMateria(@ModelAttribute MateriasDto materia, Model model) {
		if(materia.getId() != null) {
			materiasService.update(materia);
		} else {
			materiasService.insert(materia);
		}
		return REDIRECT_TO_LIST;
	}
	
	@RequestMapping("delete/{id}")
	public String eliminarMateria(@PathVariable Long id, Model model) {
		materiasService.remove(id);
		return REDIRECT_TO_LIST;
	}
	
	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView(ERROR_VIEW);
	}
	
}
