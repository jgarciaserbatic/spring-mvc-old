package es.serbatic.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.serbatic.dto.ProfesoresDto;
import es.serbatic.services.ProfesoresService;

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

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarProfesores(Model model) {
		List<ProfesoresDto> profesores = profesoresService.findAll();
		model.addAttribute("profesoresList", profesores);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		ModelAndView view;
		model.addAttribute("profesor", new ProfesoresDto());
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
	public String eliminarProfesor(@PathVariable Long id, Model model) {
		profesoresService.remove(id);
		return "redirect:/profesores";
	}
	@InitBinder("profesor")
    public void initBinder(WebDataBinder binder) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        // Con este metodo de DateFormat, se puede evitar la excepcion que lanza el Formulario si no introduces
        // ninguna fecha y esta se queda a null
        df.setLenient(false);
        
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
    }
	
	
	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView(ERROR_VIEW);
	}
}
