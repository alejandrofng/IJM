package com.IJM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.IJM.dao.UnitDao;
import com.IJM.model.Unit;

@Transactional
@Service("unitService")
public class UnitServiceImpl implements UnitService{

	@Autowired
	UnitDao unitDao;
	
	@Override
	public void saveUnit(Unit unit) {
		unitDao.save(unit);
	}

	@Override
	public void updateUnit(Unit unit) {
		unitDao.update(unit);
	}

	@Override
	public void deleteUnit(long code) {
		Unit unit = unitDao.findById(code);
		unitDao.delete(unit);
		
	}

	@Override
	public List<Unit> findAllUnits() {
		List<Unit> units = unitDao.findAll();
		return units;
	}

	@Override
	public Unit findUnitByCode(long code) {
		Unit unit = unitDao.findById(code);
		return unit;
	}

	@Override
	public boolean isUnitNameAlreadyExists(Unit unit) {
		if(unitDao.findByName(unit.getName())!=null)
			return true;
		return false;
	}

	@Override
	public boolean isUnitExists(long code) {
		if(unitDao.findById(code)!=null)
			return true;
		return false;
	}

}
