package com.huida.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.huida.domain.User;
/**
 * �����������
 * ʹ��Hibernate����
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
				//���Session�����һ������
				if(i%100==0){//ÿ�δ���100����¼
					session.flush();//���������ݿ�ͬ��
					session.clear();//���Session����һ��������������ݣ���ʱ�ͷų�ռ�õ��ڴ�
				}
			}
			transaction.commit();
			System.out.println("10000����¼�洢���");
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
