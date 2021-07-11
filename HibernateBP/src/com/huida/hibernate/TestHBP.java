package com.huida.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.huida.domain.User;
/**
 * 案例：批添加
 * 使用Hibernate缓存
 * @author Thinkpad T450
 *
 */
public class TestHBP {
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		try{
			session=HibernateBase.getSession();
			transaction=session.beginTransaction();
			for(int i=0;i<10000;i++){
				User user=new User();
				user.setUsername("DENGXIAO");
				user.setPassword("2019");
				session.save(user);
				//HibernateUtils.addUser(user);
				//清空Session级别的一级缓存
				if(i%100==0){//每次处理100条记录
					session.flush();//保持与数据库同步
					session.clear();//清除Session级别一级缓存的所有数据，及时释放出占用的内存
				}
			}
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
