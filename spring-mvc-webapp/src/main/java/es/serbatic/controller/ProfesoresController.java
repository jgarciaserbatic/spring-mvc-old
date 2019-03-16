/**
 * 
 */
package es.serbatic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import es.serbatic.dto.ProfesoresDto;
import es.serbatic.services.MateriasService;
import es.serbatic.services.ProfesoresService;

/**
 * Maneja las peticiones relacionadas con el profesor
 * 
 * @author jgarcia
 *
 */
@RequestMapping("profesores")
@Controller
public class ProfesoresController {

	private final String LIST_VIEW = "profesores/list";
	private final String PROFESOR_VIEW = "profesores/profesor";
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

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute("profesor", new ProfesoresDto());
		model.addAttribute("materias", materiasService.findAll());
		return new ModelAndView(PROFESOR_VIEW, model.asMap());
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView showUpdateProfesor(@PathVariable Long id, Model model) {
		model.addAttribute("profesor", profesoresService.findById(id));
		
		Map<MateriasDto, Boolean> resul = new HashMap<MateriasDto, Boolean>();
		
		for (MateriasDto materia : materiasService.findAll()) {
			resul.put(materia, true);
		}
		
		model.addAttribute("materias", resul);
		return new ModelAndView(PROFESOR_VIEW, model.asMap());
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String insertarProfesor(@ModelAttribute ProfesoresDto profesor, Model model) {
		if (profesor.getId() != null) {
			profesoresService.update(profesor);
		} else {
			profesoresService.insert(profesor);
		}
		return "redirect:/profesores";
	}

	@RequestMapping("delete/{id}")
	public String eliminarAlumno(@PathVariable Long id, Model model) {
		profesoresService.remove(id);
		return "redirect:/profesores";
	}

	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView(ERROR_VIEW);
	}

	@ModelAttribute("materiasDisponiblesStr")
	public List<String> getMateriasDisponiblesStr() {
		List<MateriasDto> materias = materiasService.findAll();
		List<String> result = new ArrayList<String>();
		for (MateriasDto materia : materias) {
			result.add(materia.getNombre());
		}
		return result;
	}

	@ModelAttribute("materiasDisponibles")
	public List<MateriasDto> getMateriasDisponibles() {
		return materiasService.findAll();
	}
}
