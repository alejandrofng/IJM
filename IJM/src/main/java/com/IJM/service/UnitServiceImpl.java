package com.IJM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.IJM.dao.UnitDao;
import com.IJM.dto.UnitDto;
import com.IJM.mapper.UnitMapper;
import com.IJM.model.Unit;

@Transactional
@Service("unitService")
public class UnitServiceImpl implements UnitService{

	@Autowired
	UnitDao unitDao;
	
	@Override
	public void saveUnit(UnitDto unitDto) {
		Unit unit = UnitMapper.DtoToEntity(unitDto);
		unitDao.save(unit);
	}

	@Override
	public void updateUnit(UnitDto unitDto) {
		Unit unit = unitDao.findById(unitDto.getCode());
		unit.setName(unitDto.getName());
		unitDao.update(unit);
	}

	@Override
	public void deleteUnit(long code) {
		Unit unit = unitDao.findById(code);
		unitDao.delete(unit);
		
	}

	@Override
	public List<UnitDto> findAllUnitsDto() {
		List<Unit> units = unitDao.findAll();
		if(!units.isEmpty())
		{
			return UnitMapper.EntityListToDtoList(units);
		}
		else return null;
	}

	@Override
	public UnitDto findUnitDtoByCode(long code) {
		Unit unit = unitDao.findById(code);
		return UnitMapper.EntityToDto(unit);
	}

	@Override
	public boolean isUnitNameAlreadyExists(UnitDto unitDto) {
		if(unitDao.findByName(unitDto.getName())!=null)
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
