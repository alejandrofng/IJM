package com.IJM.service;

import java.util.List;

import com.IJM.model.Unit;


public interface UnitService {

	public void saveUnit(Unit  unitDto);
	
	void updateUnit(Unit unitDto);
	
	public void deleteUnit(long code);

	public List<Unit> findAllUnits();
	
	public Unit findUnitByCode (long code);
	
	public boolean isUnitNameAlreadyExists (Unit unitDto);
	
	public boolean isUnitExists(long code);
}
