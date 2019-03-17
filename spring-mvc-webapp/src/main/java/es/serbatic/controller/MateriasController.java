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

import es.serbatic.bom.Profesores;
import es.serbatic.dto.MateriasDto;
import es.serbatic.dto.ProfesoresDto;
import es.serbatic.services.MateriasService;
import es.serbatic.services.ProfesoresService;


@RequestMapping("materias")
@Controller
public class MateriasController {
	
	private final String LIST_VIEW = "materias/list";
	private final String MAT_VIEW = "materias/materia";
	private final String ERROR_VIEW = "materias/error";
	
	private final String PROF_VIEW = "profesores/list";
	private final String PROF_VIEW2 = "profesores/assign";

	@Autowired
	MateriasService materiasService;
	
	@Autowired
	ProfesoresService profesoresService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listarProfesores(Model model) {
		List<MateriasDto> mat = materiasService.findAll();
		model.addAttribute("materias", mat);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute("materias", new MateriasDto());
		return new ModelAndView(MAT_VIEW, model.asMap());
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public ModelAndView showUpdateProfesor(@PathVariable Long id, Model model) {
		model.addAttribute("materias", materiasService.findById(id));
		return new ModelAndView(MAT_VIEW, model.asMap());
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String insertarProfesor(@ModelAttribute MateriasDto mat, Model model) {
		if(mat.getId() != null) {
			materiasService.update(mat);
		} else {
			materiasService.insert(mat);
		}
		return "redirect:/materias";
	}
	
	@RequestMapping("delete/{id}")
	public String eliminarProfesor(@PathVariable Long id, Model model) {
		materiasService.remove(id);
		return "redirect:/materias";
	}
	
	@RequestMapping("assignTeacher/{id}")
	public ModelAndView asignaProfesor(@PathVariable Long id, Model model) {
		List<ProfesoresDto> prf = profesoresService.findAll();
		model.addAttribute("materia",id);
		model.addAttribute("profesores", prf);
		return new ModelAndView(PROF_VIEW2, model.asMap());
	}
	
	@RequestMapping("findProfesors/{id}")
	public ModelAndView encuentraProfesores(@PathVariable Long id, Model model) {
		List<ProfesoresDto> prf = profesoresService.findprofesorAsignatura(id);
		model.addAttribute("profesores", prf);
		return new ModelAndView(PROF_VIEW, model.asMap());
	}
	
	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView(ERROR_VIEW);
	}
}
