package com.IJM.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.IJM.model.Unit;
import com.IJM.service.UnitService;


@Controller
@RequestMapping("/unit")
public class UnitController {

	@Autowired
	UnitService unitService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView viewAll()
	{
		List<Unit> units = unitService.findAllUnits();
		ModelAndView model = new ModelAndView("/unit/viewAll");
		model.addObject("units",units);
		return model;
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public ModelAndView insert()
	{
		ModelAndView model = new ModelAndView("/unit/insert");
		return model;
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public ModelAndView processInsertion(@Valid @ModelAttribute("unit") Unit unit, BindingResult result )
	{
		if(result.hasErrors())
		{
			ModelAndView model = new ModelAndView("/unit/insert");
			model.addObject("message","Un error ha ocurrido");
			return model;
		}
		unitService.saveUnit(unit);
		return viewAll();
	}
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") long id )
	{
		ModelAndView model = new ModelAndView("/unit/insert");
		Unit unit = unitService.findUnitByCode(id);
		model.addObject("unit",unit);
		return model;
	}
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public ModelAndView processUpdate(@Valid @ModelAttribute("unit") Unit unit, BindingResult result )
	{	
		if(result.hasErrors())
		{
			ModelAndView model = new ModelAndView("/unit/insert");
			model.addObject("message","Un error ha ocurrido");
			return model;
		}
		unitService.updateUnit(unit);
		ModelAndView model = new ModelAndView("redirect:http://localhost:8090/IJM/unit");
		return model;
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	public ModelAndView delete(@PathVariable("id") long id )
	{
		unitService.deleteUnit(id);
		ModelAndView model = new ModelAndView("redirect:http://localhost:8090/IJM/unit");
		return model;
	}
}
