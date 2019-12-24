package com.meet.dao;

import java.util.List;

import com.meet.entity.Equipment;
/**
 * 设备持久层dao接口
 * @author Pluto
 *
 */
public interface IEquipmentDao {

	/**
	 * 添加
	 * @throws Exception
	 */
	public void addEquipment(Equipment equipment) throws Exception;
	/**
	 * 删除
	 * @throws Exception
	 */
	public void deleteEquipment(int id) throws Exception;
	/**
	 * 更新
	 * @throws Exception
	 */
	public void updateEquipment(Equipment equipment) throws Exception;
	/**
	 * 查找所有
	 * @throws Exception
	 */
	public List<Equipment> findAllEquipment() throws Exception;
	/**
	 * 通过id查找
	 * @throws Exception
	 */
	public Equipment findByIdEquipment(int id) throws Exception;
}
