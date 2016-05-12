package com.IJM.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.IJM.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<Long, Category> implements CategoryDao{

	@Override
	public void save(Category category) {
		persist(category);
	}

	@Override
	public void delete(Category category) {
		super.delete(category);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAll() {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("id"));
		return (List<Category>) criteria.list();
	}

	@Override
	public Category findById(long id) {
		return getByKey(id);
	}

	public Category findByName(String name){
		Criteria criteria = getSession().createCriteria(Category.class);
		criteria.add(Restrictions.eq("name",name));
		return (Category) criteria.uniqueResult();
	}
	@Override
	public void update(Category category) {
		super.update(category);
	}

}
