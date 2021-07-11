package com.huida.hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 案例：批量删除
 * 使用Hibernate缓存
 * @author Thinkpad T450
 *
 */
public class TestHBP5 {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateBase.getSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete  User where id>100");
			query.executeUpdate();
			transaction.commit();
			System.out.println("指定记录删除完成");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
