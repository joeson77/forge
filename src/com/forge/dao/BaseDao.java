package com.forge.dao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.forge.util.DBPool;
import com.sun.org.apache.bcel.internal.generic.Select;





public class BaseDao<T> {
	static Connection conn=null;
	static PreparedStatement stat=null;
	static ResultSet rs=null;
	Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public BaseDao(){
		clazz=(Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void closeALL(Connection conn,PreparedStatement stat,ResultSet rs){
			try {
				if (rs!=null) 
					rs.close();
				if (stat!=null) 
					stat.close();
				if (conn!=null) {
					conn.close();
				}
			} catch ( SQLException e) {
				e.printStackTrace();
			}
		}
	
	public int executeUpdate(String preparedSql,Object[] param){
		int num=0;
		try {
			conn=DBPool.getInstance().getconn();
			stat=conn.prepareStatement(preparedSql);
			if (param!=null) {
				for (int i = 0; i < param.length; i++) {
					stat.setObject(i+1, param[i]);
				}
			}
			num=stat.executeUpdate();
			System.out.println(preparedSql);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeALL(conn, stat, null);
		}
		return num;
	}

	public List<T> executeQuery(String sql, Object[] param){
		Connection conn  = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		try {
			conn = DBPool.getInstance().getconn();
			stat = conn.prepareStatement(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					stat.setObject(i + 1, param[i]);
				}
			}
			rs = stat.executeQuery();
			ResultSetMetaData rsmd= rs.getMetaData();
		    int columuCount = rsmd.getColumnCount();//3
			while(rs.next()){
				//将查询到的rs中的记录存入对应的实体类中。
				T t = (T) clazz.newInstance();//调用T的构造方法，生成一个对象。 User user = new User();
				//通过rs中的列名 = entity的属性名，向熟悉中赋值。
				for (int i = 0; i < columuCount; i++) {
					Field f = clazz.getDeclaredField(rsmd.getColumnName(i+1));
					f.setAccessible(true);	
					f.set(t, rs.getObject(i+1));
				}
				list.add(t);
//				User user = new User();
//				user.setId(rs.getInt("id"));
//				user.setUserName(rs.getString("username"));
//				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeALL(conn, stat, null);
		}
		return list;
	}

	
	public List<T> executeQuery(String sql){
		Connection conn  = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		try {
			conn = DBPool.getInstance().getconn();
			System.out.println("连接成功");
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			ResultSetMetaData rsmd= rs.getMetaData();
		    int columuCount = rsmd.getColumnCount();//3
			while(rs.next()){
				//将查询到的rs中的记录存入对应的实体类中。
				T t = (T) clazz.newInstance();//调用T的构造方法，生成一个对象。 User user = new User();
				//通过rs中的列名 = entity的属性名，向熟悉中赋值。
				for (int i = 0; i < columuCount; i++) {
					Field f = clazz.getDeclaredField(rsmd.getColumnName(i+1));
					f.setAccessible(true);	
					f.set(t, rs.getObject(i+1));
				}
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeALL(conn, stat, null);
		}
		return list;
	}


	public int executeQueryCount(String sql){
		try {
			conn=DBPool.getInstance().getconn();
			stat=conn.prepareStatement(sql);
			rs=stat.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	} 

}


