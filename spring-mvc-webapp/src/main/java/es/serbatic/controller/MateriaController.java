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
import es.serbatic.dto.MateriaDto;
import es.serbatic.dto.ProfesoresDto;
import es.serbatic.services.ProfesoresService;
import es.serbatic.services.MateriaProfesoresService;
import es.serbatic.services.MateriaService;

@RequestMapping("materia")
@Controller
public class MateriaController {

	private final String LIST_VIEW = "materias/list";
	private final String MATERIA_VIEW = "materias/materia";
	private final String ERROR_VIEW = "materias/error";
	private final String ASIGNA_VIEW = "materias/setprofesor";
	@Autowired
	ProfesoresService profesorService;
	
	@Autowired
	MateriaService materiaService;
	
	@Autowired
	MateriaProfesoresService materiaProfesorService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listarMaterias(Model model) {
		List<MateriaDto> materia = materiaService.findAll();
		model.addAttribute("materia", materia );
		return new ModelAndView(LIST_VIEW, model.asMap());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute("materia", new MateriaDto());
		return new ModelAndView(MATERIA_VIEW, model.asMap());
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public ModelAndView showUpdateMateria(@PathVariable Long id, Model model) {
		model.addAttribute("materia", materiaService.findById(id));
		return new ModelAndView(MATERIA_VIEW, model.asMap());
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String insertarAlumno(@ModelAttribute MateriaDto materia, Model model) {
		if(materia.getId() != null) {
			materiaService.update(materia);
		} else {
			materiaService.insert(materia);
		}
		return "redirect:/materia";
	}
	
	@RequestMapping("delete/{id}")
	public String eliminarAlumno(@PathVariable Long id, Model model) {
		materiaService.remove(id);
		return "redirect:/materia";
	}
	
	@RequestMapping("setprofesor/{id}")
	public ModelAndView setProfesorMateria(@PathVariable Long id, Model model) {
		List<ProfesoresDto> profesores = profesorService.findAll();
		model.addAttribute("profesor", profesores);
		model.addAttribute("materiaid", id);
		return new ModelAndView(ASIGNA_VIEW, model.asMap());
	}
	
	@RequestMapping(value="asignar/{id}",method=RequestMethod.POST)
	public String setMateriaProfesor(@PathVariable Long id, Model model, @ModelAttribute ProfesoresDto profesor ) {
		
		
		//materiaProfesorService.guardarIdProfesor(profesor.getId());
		//materiaProfesorService.guardarIdAsignatura(id);
		return "redirect:/materia";
	}
	
	
	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView(ERROR_VIEW);
	}
	
	
	
}
