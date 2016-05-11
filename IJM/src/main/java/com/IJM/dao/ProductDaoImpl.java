package com.IJM.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.IJM.model.Product;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {

	@Override
	public Product findById(int id) {
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
		criteria.add(Restrictions.eq("code",code));
		return (Product) criteria.uniqueResult();
	}
	public void update(Product product) {
		super.update(product);
	}
}
