package com.meet.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.meet.entity.Equipment;
import com.meet.service.IEquipmentService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 设备控制层
 * @author Pluto
 *
 */
public class EquipmentAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> sessionMap;
	private Equipment equipment;
	private IEquipmentService equipmentService;
	
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String addEquipment() throws Exception{
		if(equipment.getEquipmentid()==null){			
			equipmentService.addEquipment(equipment);
		}else{
			updateEquipment();
		}
		return "addEquipment";
	}
	
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	public String updateEquipment() throws Exception{
		equipmentService.updateEquipment(equipment);
		return "updateEquipment";
	} 
	
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String deleteEquipment() throws Exception{
		equipmentService.deleteEquipment(equipment.getEquipmentid());
		return "deleteEquipment";
	}
	
	/**
	 * 查找所有
	 * @return
	 * @throws Exception
	 */
	public String findAllEquipment() throws Exception{
		List<Equipment> equipmentList=equipmentService.findAllEquipment();
		sessionMap.put("equipmentList", equipmentList);
		return "findAllEquipment";
	}
	
	/**
	 * 通过id查找
	 * @return
	 * @throws Exception
	 */
	public String findByIdEquipment() throws Exception{
		this.equipment=equipmentService.findByIdEquipment(equipment.getEquipmentid());
		return "findByIdEquipment";
	}
	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public void setEquipmentService(IEquipmentService equipmentService) {
		this.equipmentService = equipmentService;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;
	}

}
