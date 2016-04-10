package com.IJM.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.IJM.model.Image;

public class ImageDaoImpl extends AbstractDao<Long,Image> implements ImageDao{

	@Override
	public void save(Image image) {
		super.persist(image);
		
	}

	@Override
	public void delete(Image image) {
		delete(image);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Image> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<Image>) criteria.list();
	}

	@Override
	public Image findById(long id) {
		Criteria criteria = getSession().createCriteria(Image.class);
		criteria.add(Restrictions.eq("id",id));
		return (Image) criteria.uniqueResult();
	}

	@Override
	public void update(Image image) {
		super.update(image);
		
	}

}