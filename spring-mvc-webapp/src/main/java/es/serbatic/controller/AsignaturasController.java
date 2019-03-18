/**
 * 
 */
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

import es.serbatic.dto.AsignaturasDto;
import es.serbatic.services.AsignaturasService;



/**
 * Maneja las peticiones relacionadas con asignatura
 * 
 * @author jgarcia
 *
 */
@RequestMapping("asignaturas")
@Controller
public class AsignaturasController {
	
	private final String LIST_VIEW = "asignaturas/list";
	private final String ASIGNATURA_VIEW = "asignaturas/asignatura";
	private final String ERROR_VIEW = "asignaturas/error";

	@Autowired
	AsignaturasService asignaturasService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listarasignaturas(Model model) {
		List<AsignaturasDto> asignaturas = asignaturasService.findAll();
		model.addAttribute("asignaturas", asignaturas);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute("asignatura", new AsignaturasDto());
		return new ModelAndView(ASIGNATURA_VIEW, model.asMap());
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public ModelAndView showUpdateasignatura(@PathVariable Long id, Model model) {
		model.addAttribute("asignatura", asignaturasService.findById(id));
		return new ModelAndView(ASIGNATURA_VIEW, model.asMap());
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String insertarasignatura(@ModelAttribute AsignaturasDto asignatura, Model model) { //Model atribute crea un objeto con el request del cliente
		if(asignatura.getId() != null) {
			asignaturasService.update(asignatura);
		} else {
			asignaturasService.insert(asignatura);
		}
		return "redirect:/asignaturas";
	}
	
	@RequestMapping("delete/{id}")
	public String eliminarasignatura(@PathVariable Long id, Model model) { //Con @PathVariable accedemos a la variabele del path!!
		asignaturasService.remove(id);
		return "redirect:/asignaturas";
	}
	
	@ExceptionHandler
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView(ERROR_VIEW);
	}
	
}
