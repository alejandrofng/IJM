package com.IJM.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.IJM.model.FileType;
import com.IJM.model.Image;
import com.IJM.model.Product;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Long, Product> implements ProductDao {

	@Override
	public Product findById(Long id) {
		return getByKey(id);
	}

	@Override
	public void save(Product product) {
		persist(product);
		
	}

	@Override
	public void delete(Product product) {
		super.delete(product);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() {
		Criteria criteria = createEntityCriteria();
		//System.out.print(criteria.list());
		return (List<Product>) criteria.list();
	}

	@Override
	public Product findByCode(String code) {
		Criteria criteria = getSession().createCriteria(Product.class);
		criteria.add(Restrictions.ilike("code", code, MatchMode.ANYWHERE));
		return (Product) criteria.uniqueResult();
	}
	public void update(Product product) {
		super.update(product);
	}
}
