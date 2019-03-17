package es.serbatic.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.serbatic.dto.MateriasDto;
import es.serbatic.services.MateriasService;


@Controller
@RequestMapping("materias")
public class MateriasController {

	private final String LIST_VIEW = "materias/list";
	private final String ADD_VIEW = "materias/add";
	private final String UPDATE_VIEW = "materias/update";

	
	@Autowired
	MateriasService materiasService;
	
	//Metodo para la lista
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listarMaterias(Model model) {

		model.addAttribute("listMaterias", materiasService.findAll());

		return new ModelAndView(LIST_VIEW, model.asMap());
	}
	
	@RequestMapping(value="list")
	public ModelAndView listar(Model model) {
		return listarMaterias(model);
	}
	
	//Metodo para mapear la vista del Add
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView addView(Model model) {

		model.addAttribute("materia", new MateriasDto());
		
		return new ModelAndView(ADD_VIEW, model.asMap());
	}	

	//Llamada para insertar el Materia
	@RequestMapping(value="addMateria", method=RequestMethod.POST)
	public String addMateria(Model model, @ModelAttribute MateriasDto materia) {

		materiasService.saveOrUpdate(materia);
		
		//Volver a la vista de view
		return "redirect:/materias";
	}		
	
	//Metodo para mapear la vista del Update
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public ModelAndView updateView( @PathVariable Long id, Model model) {

		model.addAttribute("materia", materiasService.findById(id));
		
		return new ModelAndView(UPDATE_VIEW, model.asMap());
	}
	
	//Llamada para insertar la Materia
	@RequestMapping(value="updateMateria", method=RequestMethod.POST)
	public String updateMateria(Model model, @ModelAttribute MateriasDto materia) {

		materiasService.saveOrUpdate(materia);
		
		//Volver a la vista de view
		return "redirect:/materias";
	}	
	
	
	//Metodo para mapear la vista del Update
	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public String delete( @PathVariable Long id, Model model) {

		materiasService.remove(id);
		
		//Volver a la vista de view
		return "redirect:/materias";
	}
	
	 @InitBinder
	 public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        dateFormat.setLenient(false);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	    }
	
}
