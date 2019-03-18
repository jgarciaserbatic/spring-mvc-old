package es.serbatic.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.serbatic.dto.AlumnosDto;
import es.serbatic.dto.ProfesoresDto;
import es.serbatic.services.ProfesoresService;
import es.serbatic.validation.impl.ValidatorProfesores;

/**
 * @author lclemente
 *
 */

@RequestMapping("profesores")
@Controller
public class ProfesoresController {

	private final String PROFESORES_VIEW = "profesores/profesor";
	private final String LIST_VIEW = "profesores/list";
	private final String ERROR_VIEW = "";

	@Autowired
	ProfesoresService profesoresService;

	@ModelAttribute("profesor")
	public ProfesoresDto populateForm() {
		return new ProfesoresDto();
	}
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarProfesores(Model model) {
		List<ProfesoresDto> profesores = profesoresService.findAll();
		model.addAttribute("profesoresList", profesores);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		ModelAndView view;
		if (!model.containsAttribute("profesor")) {
			model.addAttribute("profesor", new ProfesoresDto());
		}
		view = new ModelAndView(PROFESORES_VIEW, model.asMap());
		return view;
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView showUpdateProfesor(@PathVariable Long id, Model model) {
		ModelAndView view;
		model.addAttribute("profesor", profesoresService.findById(id));
		view = new ModelAndView(PROFESORES_VIEW, model.asMap());
		return view;
	}

	@RequestMapping(value="new", method=RequestMethod.POST)
	public ModelAndView insertarAlumno( @ModelAttribute("profesor") @Valid ProfesoresDto profesor, BindingResult result,  Model model) {
		ModelAndView view;
		if(result.hasErrors()) {
			view = this.showNewPage(model);
		}else {
			if(profesor.getId() != null) {
				profesoresService.update(profesor);
			} else {
				profesoresService.insert(profesor);
			}
			view = this.listarProfesores(model);
		}
		
		return view;
	}
	@RequestMapping("delete/{id}")
	public String eliminarProfesor(@PathVariable Long id, Model model) {
		profesoresService.remove(id);
		return "redirect:/profesores";
	}
	@InitBinder
    public void initBinder(WebDataBinder binder) {
		binder.setValidator(new ValidatorProfesores());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        df.setLenient(false);
        
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
    }
	
	
	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView(ERROR_VIEW);
	}
}
