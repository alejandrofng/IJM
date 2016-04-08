package com.IJM.service;

import java.util.List;

import com.IJM.dto.UnitDto;

public interface UnitService {

	public void saveUnit(UnitDto  unitDto);
	
	void updateUnit(UnitDto unitDto);
	
	public void deleteUnit(long code);

	public List<UnitDto> findAllUnitsDto();
	
	public UnitDto findUnitDtoByCode (long code);
	
	public boolean isUnitNameAlreadyExists (UnitDto unitDto);
	
	public boolean isUnitExists(long code);
}
