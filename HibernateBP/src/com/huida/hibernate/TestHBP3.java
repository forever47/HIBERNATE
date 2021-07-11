package com.huida.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.huida.domain.User;
/**
 * ��������������
 * ʹ��Hibernate����
 * @author Thinkpad T450
 *
 */
public class TestHBP3 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateBase.getSession();
			transaction = session.beginTransaction();
			// Query query=session.createQuery("update User set
			// username='SXSW'");
			// query.executeUpdate();
			// ��username�ֶ�ΪVENOM�ļ�¼�޸�ΪusernameΪDENGXIAO
			Query query = session.createQuery("from User where username='VENOM'");
			List<User> list = query.list();
			@SuppressWarnings("rawtypes")
			Iterator iterator = list.iterator();
			while (iterator.hasNext()) {
				User user = (User) iterator.next();
				user.setUsername("DENGXIAO");
			}
			transaction.commit();
			System.out.println("ָ����¼�޸����");
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
