package com.meet.util;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meet.entity.User;

import jxl.Sheet;
import jxl.Workbook;

/**
 * Java实现Excel导入数据核心类 读取Excel表中所有的数据、操作数据（查询、更新）
 * @author Pluto
 *
 */
public class ExcelUtil {
	/**
     * 查询stu表中所有的数据
     * @return 
     *//*
    public static List<User> getAllByDb(){
        List<User> list=new ArrayList<User>();
        try {
            DBhepler db=new DBhepler();
            String sql="select * from stu";
            ResultSet rs= db.Search(sql, null);
            while (rs.next()) {
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String pwd=rs.getString("pwd");
                
                //System.out.println(id+" "+name+" "+sex+ " "+num);
                list.add(new User(id, name, pwd));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }*/
    
    /**
     * 查询指定目录中电子表格中所有的数据
     * @param file 文件完整路径
     * @return
     */
    public static List<User> getAllByExcel(String file){
        List<User> list=new ArrayList<User>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet("user");//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
            
            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String oid=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String username=rs.getCell(j++, i).getContents();
                    String age=rs.getCell(j++, i).getContents();
                    String sex=rs.getCell(j++, i).getContents();
                    String phone=rs.getCell(j++, i).getContents();
                    String email=rs.getCell(j++, i).getContents();
                    String role=rs.getCell(j++, i).getContents();
                    //list.add(new User(Integer.parseInt(oid),username, age, sex, phone,email,role));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return list;
        
    }
    
    /**
     * 通过Id判断是否存在
     * @param id
     * @return
     *//*
    public static boolean isExist(int id){
        try {
            DBhepler db=new DBhepler();
            ResultSet rs=db.Search("select * from stu where id=?", new String[]{id+""});
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void main(String[] args) {
        List<User> all=getAllByDb();
        for (User User : all) {
            System.out.println(User.toString());
        }
        System.out.println(isExist(1));
        
    }*/
}
