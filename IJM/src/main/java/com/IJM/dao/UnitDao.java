package com.IJM.dao;

import java.util.List;

import com.IJM.model.Unit;

public interface UnitDao {

	public void save(Unit unit);

	public void delete(Unit unit);

	public List<Unit> findAll();

	public Unit findById(long id);

	public Unit findByName(String name);
	
	public void update(Unit unit);
}
