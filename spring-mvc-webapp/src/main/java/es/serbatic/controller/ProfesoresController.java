/**
 * 
 */
package es.serbatic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.bcel.internal.generic.NEW;

import es.serbatic.dto.AsignaturasDto;
import es.serbatic.dto.ProfesoresDto;
import es.serbatic.services.AsignaturasService;
import es.serbatic.services.ProfesoresService;
import javassist.expr.NewArray;

/**
 * @author smartinez
 *
 */

@RequestMapping("profesores")
@Controller
public class ProfesoresController {

	@Autowired
	AsignaturasService asignaturasService;
	
	
	@Autowired
	ProfesoresService profesoresService;
	
	private String LIST_VIEW = "profesores/list";
	private String PROFESOR_VIEW = "profesores/profesor";
	
	@RequestMapping(method=RequestMethod.GET) //URL
	public ModelAndView listarProfesores(Model model) {
		List<ProfesoresDto> profesores = profesoresService.findAll();
			
		model.addAttribute("profesores", profesores);
		
		return new ModelAndView(LIST_VIEW, model.asMap());
	
	}
	
	@RequestMapping(method=RequestMethod.POST) //formulario
	public ModelAndView verProfesor(Model model) {
		//Obtengo lista de asignaturas
		List asignaturas = asignaturasService.findAll();
		
		
		model.addAttribute("profesor", new ProfesoresDto());
//		añado las asignaturas al modelo
		model.addAttribute("asignaturas", asignaturas);
		
		return new ModelAndView(PROFESOR_VIEW,model.asMap());
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public ModelAndView profesorUpdate(@PathVariable Long id, Model model) {		
		List asignaturas = asignaturasService.findAll();
		
		model.addAttribute("profesor", profesoresService.findById(id));
		model.addAttribute("asignaturas",asignaturas);
		return new ModelAndView(PROFESOR_VIEW, model.asMap());
	}
	
	
	@RequestMapping(value="new", method=RequestMethod.POST) 
	public String insertarProfesor(@ModelAttribute ProfesoresDto profesor , Model model ) {
		
		if(profesor.getId() != null) {
			profesoresService.update(profesor);
		} else {
			profesoresService.insert(profesor);
		}
				
		return "redirect:/profesores";
	}	
	
	
	@RequestMapping(value="delete/{id}")
	public String borrarProfesor(@PathVariable Long id, Model model) { //@PathVariable nos permite recoger valores del patH!!!
		
		profesoresService.remove(id);
		
		return "redirect:/profesores";
	}
		
		
		
	
	
}
