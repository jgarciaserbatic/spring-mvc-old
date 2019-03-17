/**
 * 
 */
package es.serbatic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.serbatic.dto.MateriaDto;
import es.serbatic.dto.ProfesorDto;
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
		List<ProfesorDto> profesores = profesoresService.findAll();
		model.addAttribute("profesoresEntrada", profesores);
		return new ModelAndView(LIST_VIEW, model.asMap());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView showNewPage(Model model) {
		model.addAttribute("profesorEntrada", new ProfesorDto());
		return new ModelAndView(PROFESOR_VIEW, model.asMap());
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public ModelAndView showUpdateProfesor(@PathVariable Long id, Model model) {
		model.addAttribute("profesorEntrada", profesoresService.findById(id));
		return new ModelAndView(PROFESOR_VIEW, model.asMap());
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String insertarProfesor(@ModelAttribute ProfesorDto profesor, BindingResult result, Model model) {

		if (result.hasErrors()) {
			System.out.println("Hay errores...");
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Error procesado: " + error.getDefaultMessage());
			}
		}

		// Obtenemos materias aleatorias para crear relaccion de ejemplo
		profesor.setMaterias(obtenerMateriasEjemploRamdom());

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

	@ModelAttribute("materias")
	public List<MateriaDto> getMateriasDisponibles() {
		return materiasService.findAll();
	}

	private List<MateriaDto> obtenerMateriasEjemploRamdom() {

		// Codigo de prueba para enlazar materias con profesores
		List<MateriaDto> materiasDisponibles = materiasService.findAll();
		List<MateriaDto> result = new ArrayList<MateriaDto>();

		if (materiasDisponibles.size() > 0) {

			int numMateriasResultado = ThreadLocalRandom.current().nextInt(1, materiasDisponibles.size() + 1);

			for (int i = 0; i < numMateriasResultado; i++) {
				result.add(materiasDisponibles.get(i));
			}
		}

		return result;

	}
}
