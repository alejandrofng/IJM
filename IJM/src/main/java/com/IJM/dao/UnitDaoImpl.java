package com.IJM.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.IJM.model.Unit;

@Repository("unitDao")
public class UnitDaoImpl extends AbstractDao<Long,Unit> implements UnitDao{

	@Override
	public void save(Unit unit) {
		super.persist(unit);
		
	}

	@Override
	public void delete(Unit unit) {
		super.delete(unit);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Unit> findAll() {
		Criteria criteria = createEntityCriteria();
		System.out.print(criteria.list());
		return (List<Unit>) criteria.list();
	}

	@Override
	public Unit findById(long id) {
		return getByKey(id);
	}

	@Override
	public Unit findByName(String name) {
		Criteria criteria = getSession().createCriteria(Unit.class);
		criteria.add(Restrictions.eq("name",name));
		return (Unit) criteria.uniqueResult();
	}

	@Override
	public void update(Unit unit) {
		super.update(unit);
		
	}

}
