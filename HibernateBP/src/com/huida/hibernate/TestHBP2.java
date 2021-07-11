package com.huida.hibernate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
/**
 * 案例：批量添加
 * 绕过Hibernate缓存，使用JDBC API
 * @author Thinkpad T450
 *
 */

public class TestHBP2 {
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
						PreparedStatement preparedStatement=connection.prepareStatement(
								"insert into user(username,password) values (?,?)");
						for(int i=0;i<10000;i++){
							preparedStatement.setString(1, "VENOM");
							preparedStatement.setString(2, "2020");
							preparedStatement.addBatch();
						}
						preparedStatement.executeBatch();
					}	
				}
			);
			transaction.commit();
			System.out.println("10000条记录存储完成");
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
