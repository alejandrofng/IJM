package com.IJM.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.IJM.model.Directory;

@Repository("directoryDao")
public class DirectoryDaoImpl extends AbstractDao<Long,Directory> implements DirectoryDao{

	@Override
	public void save(Directory directory) {
		super.persist(directory);
		
	}

	@Override
	public void delete(Directory directory) {
		super.delete(directory);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Directory> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<Directory>) criteria.list();
	}

	@Override
	public Directory findById(long id) {
		Criteria criteria = getSession().createCriteria(Directory.class);
		criteria.add(Restrictions.eq("id",id));
		return (Directory) criteria.uniqueResult();
	}

	@Override
	public void update(Directory directory) {
		super.update(directory);
		
	}

	@Override
	public Directory findByName(String name) {
		Criteria criteria = getSession().createCriteria(Directory.class);
		criteria.add(Restrictions.eq("name",name));
		return (Directory) criteria.uniqueResult();
	}

}
