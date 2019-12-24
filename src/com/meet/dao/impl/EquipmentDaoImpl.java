package com.meet.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.meet.dao.IEquipmentDao;
import com.meet.entity.Equipment;

/**
 * 设备持久层dao接口实现
 * @author Pluto
 *
 */
public class EquipmentDaoImpl extends HibernateDaoSupport implements IEquipmentDao {

	/**
	 * 添加
	 */
	@Override
	public void addEquipment(Equipment equipment) throws Exception {
		this.getHibernateTemplate().save(equipment);
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteEquipment(int id) throws Exception {
		Equipment equipment=this.getHibernateTemplate().load(Equipment.class, id);
		this.getHibernateTemplate().delete(equipment);
	}

	/**
	 * 更新
	 */
	@Override
	public void updateEquipment(Equipment equipment) throws Exception {
		this.getHibernateTemplate().update(equipment);
	}

	/**
	 * 查找所有
	 */
	@Override
	public List<Equipment> findAllEquipment() throws Exception {
		@SuppressWarnings("unchecked")
		List<Equipment> equipmentList=this.getHibernateTemplate().find("from Equipment");
		return equipmentList;
	}

	/**
	 * 查找单个
	 */
	@Override
	public Equipment findByIdEquipment(int id) throws Exception {
		Equipment equipment=this.getHibernateTemplate().get(Equipment.class, id);
		return equipment;
	}

}
