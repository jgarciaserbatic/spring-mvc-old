package es.serbatic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.serbatic.dto.MateriasDto;
import es.serbatic.dto.ProfesoresDto;
import es.serbatic.services.MateriasService;


@RequestMapping("materias")
@Controller
public class MateriasController {
	
	private final String LIST_VIEW = "materias/list";
	private final String MATERIAS_VIEW = "materias/materia";
	//private final String ERROR_VIEW = "materias/error";
	
	@Autowired
	MateriasService materiasService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarMaterias(Model model) {		
		List<MateriasDto> materias = materiasService.findAll();
		model.addAttribute("materias", materias);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String insertarMateria(@ModelAttribute MateriasDto materia, Model model) {
		if(materia.getId() != null) {
			materiasService.update(materia);
		} else {
			materiasService.insert(materia);
		}
		return "redirect:/materias";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute("materia", new ProfesoresDto());
		return new ModelAndView(MATERIAS_VIEW, model.asMap());
	}

}
