package com.meet.action;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.meet.entity.User;
import com.meet.service.IUserService;
import com.meet.util.UserPageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.meet.util.JsonUtil;
import com.meet.util.SessionUtil;
import com.sun.net.httpserver.Authenticator.Success;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * 用户控制层
 * @author Pluto
 *
 */
public class UserAction extends ActionSupport implements SessionAware,RequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private User _curUser;
	private IUserService userService;
	private Map<String, Object> sessionMap;
	private Map<String, Object> request;
	private int page = 1; //表示从网页中返回的当前页的值  默认为1 表示默认显示第一页内容
	private UserPageBean pageBean; //封装了分页信息和数据内容的pageBean 
	private List<User> listUser;//用于储存pageBean当中被封装的User信息
	
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String addUser() throws Exception{
		//User u=new User(user.getUsername(), DigestUtils.md5Hex(user.getPassword()), DigestUtils.md5Hex(user.getRepwd()), user.getAge(), user.getSex(), user.getPhone(), user.getEmail(), user.getRole());
		userService.addUser(user);
		return "addUser";
	}
	
	/**
	 * 查找所有
	 * @return
	 * @throws Exception
	 */
	public String findAllUser() throws Exception{
		if(userService.findRoleByuserName( _curUser.getUsername())==true){			
			//List<User> userList=userService.findAllUser();
			this.pageBean = userService.queryForPage(5, page);//获取封装了分页信息和数据的pageBean    
			List<User> userList= this.pageBean.getList(); //获取数据 
			sessionMap.put("userList", userList);
			sessionMap.put("pageBean", pageBean);
		}else{
			List<User> userList=userService.findByUserName(_curUser.getUsername());
			sessionMap.put("userList", userList);
		}
		return "findAllUser";
	}
	
	/**
	 * 条件查询
	 * @return
	 * @throws Exception
	 */
	public String findByTJ() throws Exception{
		this.pageBean=userService.findByTJ(5, page, null == user ? null : user.getUsername());
		this.listUser=this.pageBean.getList();
		sessionMap.put("pageBean", pageBean);
		sessionMap.put("userList", listUser);
		return "findByTJ";
	}
	
	/**
	 * 数据的数据导入到Excel表
	 * @return
	 * @throws Exception
	 */
	public String dbToExcel(){
		try {
            WritableWorkbook wwb = null;
            // 创建可写入的Excel工作簿
            String fileName = "D://users.xls";
            File file=new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            //以fileName为文件名来创建一个Workbook
            wwb = Workbook.createWorkbook(file);

            // 创建工作表
            WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
            
            //查询数据库中所有的数据
            List<User> list= userService.findAllUser();
            //要插入到的Excel表格的行号，默认从0开始
            Label labelOid= new Label(0, 0, "编号");//表示第
            Label labelUsername= new Label(1, 0, "用户名");
            Label labelAge= new Label(2, 0, "年龄");
            Label labelSex= new Label(3, 0, "性别");
            Label labelPhone= new Label(4, 0, "手机号码");
            Label labelEmail= new Label(5, 0, "邮箱");
            Label labelRole= new Label(6, 0, "角色");
            Label labelGroupname= new Label(7, 0, "组名");
            
            ws.addCell(labelOid);
            ws.addCell(labelUsername);
            ws.addCell(labelAge);
            ws.addCell(labelSex);
            ws.addCell(labelPhone);
            ws.addCell(labelEmail);
            ws.addCell(labelRole);
            ws.addCell(labelGroupname);
            
            for (int i = 0; i < list.size(); i++) {
                Label labelOid_i= new Label(0, i+1, list.get(i).getOid()+"");
                Label labelUsername_i= new Label(1, i+1, list.get(i).getUsername());
                Label labelAge_i= new Label(2, i+1, list.get(i).getAge());
                Label labelSex_i= new Label(3, i+1, list.get(i).getSex());
                Label labelPhone_i= new Label(4, i+1, list.get(i).getPhone());
                Label labelEmail_i= new Label(5, i+1, list.get(i).getEmail());
                Label labelRole_i= new Label(6, i+1, list.get(i).getRole());
                Label labelGroupname_i= new Label(7, i+1, list.get(i).getGroup().getGroupname());
                
                ws.addCell(labelOid_i);
                ws.addCell(labelUsername_i);
                ws.addCell(labelAge_i);
                ws.addCell(labelSex_i);
                ws.addCell(labelPhone_i);
                ws.addCell(labelEmail_i);
                ws.addCell(labelRole_i);
                ws.addCell(labelGroupname_i);
            }
           //写进文档
            wwb.write();
           // 关闭Excel工作簿对象
            wwb.close();
     } catch (Exception e) {
         e.printStackTrace();
     } 
		return SUCCESS;
	}
	
	/**
	 * 更新
	 * @return
	 * @throws Exception
	 */
	public String updateUser() throws Exception{
		userService.updateUser(user);
		return "updateUser";
	}
	
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String deleteUser() throws Exception{
		userService.deleteUser(user.getOid());
		return "deleteUser";
	}
	
	/**
	 * 通过id查找
	 * @return
	 * @throws Exception
	 */
	public String findByIdUser() throws Exception{
		this.user=userService.findByIdUser(user.getOid());
		return "findByIdUser";
	}
	
	/**
	 * 登录验证
	 * @return
	 * @throws Exception
	 */
	public String loginUser() throws Exception{
		ActionContext ac=ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		//_curUser = userService.login(_curUser.getUsername(), DigestUtils.md5Hex(_curUser.getPassword()));
		_curUser = userService.login(_curUser.getUsername(), _curUser.getPassword());
		if(_curUser == null){
			String errMsg = "用户名密码不存在!";
			sessionMap.put("errMsg", errMsg);
			return "login";
		}else{	
			session.put("username", _curUser.getUsername());
			session.put("userid", _curUser.getOid());
			session.put("isAdmin", _curUser.isAdmin());
			System.out.println("_curUser:============="+_curUser);
			return "main";
		}
	}
	
	/**
	 * 退出登录
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception{
		Map<String,Object> map=ActionContext.getContext().getSession();
		map.clear();
		return "login";
	}
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User get_curUser() {
		return _curUser;
	}

	public void set_curUser(User _curUser) {
		this._curUser = _curUser;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public UserPageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(UserPageBean pageBean) {
		this.pageBean = pageBean;
	}

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

}
