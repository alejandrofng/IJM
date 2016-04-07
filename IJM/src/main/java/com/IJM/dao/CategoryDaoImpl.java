package com.IJM.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.IJM.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao{

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
		System.out.print(criteria.list());
		return (List<Category>) criteria.list();
	}

	@Override
	public Category findById(int id) {
		return getByKey(id);
	}

	public Category findByParentAndName(int id_Parent,String name){
		Criteria criteria = getSession().createCriteria(Category.class);
		criteria.add(Restrictions.eq("Id_Parent",id_Parent));
		criteria.add(Restrictions.eq("Name",name));
		return (Category) criteria.uniqueResult();
	}
	@Override
	public void update(Category category) {
		super.update(category);
	}

}
