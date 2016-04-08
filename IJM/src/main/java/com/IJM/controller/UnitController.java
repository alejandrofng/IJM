package com.IJM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.IJM.dto.UnitDto;
import com.IJM.service.UnitService;

@RestController
@RequestMapping("/unit")
public class UnitController {
	@Autowired
	private UnitService unitService;

	// create a Product
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createUnit(@RequestBody UnitDto unitDto) {
		if (unitService.isUnitNameAlreadyExists(unitDto)) {
			System.out.println("A Unit with name " + unitDto.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		unitService.saveUnit(unitDto);
		System.out.println("A Unit with name " + unitDto.getName() + " has been added");
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateUnit(@PathVariable("code") String code, @RequestBody UnitDto unitDto) {
		System.out.println("Updating Unit " + code);
		HttpStatus status;
		try {
			unitService.updateUnit(unitDto);
			status = HttpStatus.OK;
		} catch (Exception e) {
			status = HttpStatus.CONFLICT;
		}
		return new ResponseEntity<Void>(status);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UnitDto>> listAllUnits() {
		List<UnitDto> unitsDto = unitService.findAllUnitsDto();
		if (unitsDto==null) {
			return new ResponseEntity<List<UnitDto>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UnitDto>>(unitsDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public ResponseEntity<UnitDto> getUnit(@PathVariable("code") long code) {
		System.out.println("Fetching Unit with code " + code);

		UnitDto unitDto = unitService.findUnitDtoByCode(code);
		if (unitDto == null) {
			System.out.println("Unit with code " + code + " not found");
			return new ResponseEntity<UnitDto>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UnitDto>(unitDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.DELETE)
	public ResponseEntity<UnitDto> deleteUnit(@PathVariable("code") long code) {
		System.out.println("Fetching & Deleting Unit with id " + code);

		
		if (!unitService.isUnitExists(code)) {
			System.out.println("Unable to delete. Unit with code " + code + " not found");
			return new ResponseEntity<UnitDto>(HttpStatus.NOT_FOUND);
		}
		
		unitService.deleteUnit(code);
		return new ResponseEntity<UnitDto>(HttpStatus.NO_CONTENT);
	}
}

