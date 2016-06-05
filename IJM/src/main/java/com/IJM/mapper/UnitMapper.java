package com.IJM.mapper;


import java.util.ArrayList;
import java.util.List;

import com.IJM.dto.UnitDto;
import com.IJM.model.Unit;

public class UnitMapper {
	
	public static UnitDto EntityToDto(Unit unit) {
		UnitDto unitDto = new UnitDto();
		unitDto.setId(unit.getId());
		unitDto.setName(unit.getName());
		return unitDto;
	}

	public static Unit DtoToEntity(UnitDto unitDto) {
		Unit unit = new Unit();
		if(unitDto.getId()!=null)
		unit.setId(unitDto.getId());
		unit.setName(unitDto.getName());
		return unit;
	}
	public static List<UnitDto> EntityListToDtoList(List<Unit> units){
		
		List<UnitDto> unitsDto = new ArrayList<UnitDto>();
		for (Unit unit : units) {
			UnitDto unitDto = UnitMapper.EntityToDto(unit);
			unitsDto.add(unitDto);
		}
		return unitsDto;
	}
}
