package com.meet.service.impl;

import java.util.List;

import com.meet.dao.IEquipmentDao;
import com.meet.entity.Equipment;
import com.meet.service.IEquipmentService;

/**
 * 设备服务层service接口实现
 * @author Pluto
 *
 */
public class EquipmentServiceImpl implements IEquipmentService {

	private IEquipmentDao equipmentDao;
	/**
	 * 添加
	 */
	@Override
	public void addEquipment(Equipment equipment) throws Exception {
		equipmentDao.addEquipment(equipment);
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteEquipment(int id) throws Exception {
		equipmentDao.deleteEquipment(id);
	}

	/**
	 * 更新
	 */
	@Override
	public void updateEquipment(Equipment equipment) throws Exception {
		equipmentDao.updateEquipment(equipment);
	}

	/**
	 * 查找所有
	 */
	@Override
	public List<Equipment> findAllEquipment() throws Exception {
		return equipmentDao.findAllEquipment();
	}

	/**
	 * 查找单个
	 */
	@Override
	public Equipment findByIdEquipment(int id) throws Exception {
		return equipmentDao.findByIdEquipment(id);
	}

	public void setEquipmentDao(IEquipmentDao equipmentDao) {
		this.equipmentDao = equipmentDao;
	}

}
