package com.huida.hibernate;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;

/**
 * 案例：批量删除
 * 绕过Hibernate缓存，使用JDBC API
 * @author Thinkpad T450
 *
 */
public class TestHBP6 {
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		try{
			session=HibernateBase.getSession();
			transaction=session.beginTransaction();
			session.doWork(
				new Work(){
					@Override
					public void execute(Connection connection) throws SQLException {
						Statement statement=connection.createStatement();
						statement.executeUpdate("delete from User where  id>70");
					}	
				}
			);
			transaction.commit();
			System.out.println("指定记录删除完成");
		}catch(Exception e){
			if(transaction!=null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
