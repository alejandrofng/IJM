package com.IJM.clientcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.IJM.model.Unit;
import com.IJM.service.UnitService;
@Controller
@RequestMapping("/unidades")
public class UnitClientController {

		@Autowired
		UnitService unitService;
		
		@RequestMapping(method=RequestMethod.GET)
		public ModelAndView viewAll()
		{
			List<Unit> units = unitService.findAllUnits();
			ModelAndView model = new ModelAndView("/unit/view");
			model.addObject("units",units);
			return model;
		}

}
