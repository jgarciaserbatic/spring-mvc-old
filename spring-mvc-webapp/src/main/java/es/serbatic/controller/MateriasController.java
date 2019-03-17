/**
 * 
 */
package es.serbatic.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.serbatic.dto.MateriaDto;
import es.serbatic.dto.ProfesorDto;
import es.serbatic.services.MateriasService;
import es.serbatic.services.ProfesoresService;

/**
 * Maneja las peticiones relacionadas con el materia
 * 
 * @author jgarcia
 *
 */
@RequestMapping("materias")
@Controller
public class MateriasController {

	private final String LIST_VIEW = "materias/list";
	private final String MATERIA_VIEW = "materias/materia";
	private final String ERROR_VIEW = "materias/error";

	@Autowired
	MateriasService materiasService;

	@Autowired
	ProfesoresService profesoresService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarMaterias(Model model) {
		List<MateriaDto> materias = materiasService.findAll();
		model.addAttribute("materias", materias);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute("materia", new MateriaDto());
		return new ModelAndView(MATERIA_VIEW, model.asMap());
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView showUpdateMateria(@PathVariable Long id, Model model) {
		model.addAttribute("materia", materiasService.findById(id));
		return new ModelAndView(MATERIA_VIEW, model.asMap());
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String insertarMateria(@ModelAttribute MateriaDto materia, Model model) {
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
