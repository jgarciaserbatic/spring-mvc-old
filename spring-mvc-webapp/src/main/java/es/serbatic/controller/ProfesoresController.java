package es.serbatic.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.serbatic.dto.ProfesoresDto;
import es.serbatic.services.ProfesoresService;


@Controller
@RequestMapping("profesores")
public class ProfesoresController {
	
	private final String LIST_VIEW = "profesores/list";
	private final String ADD_VIEW = "profesores/add";
	private final String UPDATE_VIEW = "profesores/update";

	
	
	@Autowired
	ProfesoresService profesoresService;
	
	//Metodo para la lista
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listarProfesores(Model model) {

		model.addAttribute("listProfesores", profesoresService.findAll());

		return new ModelAndView(LIST_VIEW, model.asMap());
	}
	
	@RequestMapping(value="list")
	public ModelAndView listar(Model model) {
		return listarProfesores(model);
	}
	
	//Metodo para mapear la vista del Add
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView addView(Model model) {

		model.addAttribute("profesor", new ProfesoresDto());
		
		return new ModelAndView(ADD_VIEW, model.asMap());
	}	

	//Llamada para insertar el Profesor
	@RequestMapping(value="addProfesor", method=RequestMethod.POST)
	public String addProfesor(Model model, @ModelAttribute ProfesoresDto profesor) {

		profesoresService.saveOrUpdate(profesor);
		
		//Volver a la vista de view
		return "redirect:/profesores";
	}		
	
	//Metodo para mapear la vista del Update
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public ModelAndView updateView( @PathVariable Long id, Model model) {

		model.addAttribute("profesor", profesoresService.findById(id));
		
		return new ModelAndView(UPDATE_VIEW, model.asMap());
	}
	
	//Llamada para insertar el Profesor
	@RequestMapping(value="updateProfesor", method=RequestMethod.POST)
	public String updateProfesor(Model model, @ModelAttribute ProfesoresDto profesor) {

		profesoresService.saveOrUpdate(profesor);
		
		//Volver a la vista de view
		return "redirect:/profesores";
	}	
	
	
	//Metodo para mapear la vista del Update
	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public String delete( @PathVariable Long id, Model model) {

		profesoresService.remove(id);
		
		//Volver a la vista de view
		return "redirect:/profesores";
	}
	
	
}
