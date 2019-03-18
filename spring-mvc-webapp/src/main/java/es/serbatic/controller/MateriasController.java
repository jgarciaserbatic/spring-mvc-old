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
 * @author lclemente
 *
 */
@RequestMapping("materias")
@Controller
public class MateriasController {

	private final String MATERIAS_VIEW = "materias/materia";
	private final String LIST_VIEW = "materias/list";
	private final String ERROR_VIEW = "";

	@Autowired
	MateriasService materiasService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarMaterias(Model model) {
		ModelAndView view;
        List<MateriasDto> profesores = materiasService.findAll();
        model.addAttribute("materias", profesores);
		view = new ModelAndView(LIST_VIEW, model.asMap());
		return view;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		ModelAndView view;
		model.addAttribute("materia", new MateriasDto());
		view = new ModelAndView(MATERIAS_VIEW, model.asMap());
		return view;
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView showUpdateMateria(@PathVariable Long id, Model model) {
		ModelAndView view;
		model.addAttribute("materia", materiasService.findById(id));
		view = new ModelAndView(MATERIAS_VIEW, model.asMap());
		return view;
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String insertarMateria(@ModelAttribute MateriasDto materia, Model model) {
		if (materia.getId() != null) {
			materiasService.update(materia);
		} else {
			materiasService.insert(materia);
		}
		return "redirect:/materias";
	}

	@RequestMapping("delete/{id}")
	public String eliminarMateria(@PathVariable Long id, Model model) {
		materiasService.remove(id);
		return "redirect:/materias";
	}
	
	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView(ERROR_VIEW);
	}
}