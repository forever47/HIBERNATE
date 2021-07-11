package com.huida.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * ������
 * ��Ը��Ӳ���
 * HibernateBaseû�б�Ҫд��HibernateUtils
 * @author Thinkpad T450
 *
 */
@SuppressWarnings("deprecation")//���޳�
public final class HibernateBase {
	private static SessionFactory sessionFactory;

	private HibernateBase() {
	}
	static{
		Configuration configuration=new Configuration();
		configuration.configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	  
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	//���
//			public static void addUser(Object object){
//				Session session=null;
//				Transaction transaction=null;
//				try{
//					session=HibernateUtils.getSession();
//					transaction=session.beginTransaction();
//					session.save(object);
//					transaction.commit();
//				}catch(Exception e){
//					if(transaction!=null){
//						transaction.rollback();
//					}
//					throw e;
//				}finally{
//					session.close();
//				}
//			}
//			//�޸�
//			public static void updateUser(Object object){
//				Session session=null;
//				Transaction transaction=null;
//				try{
//					session=HibernateUtils.getSession();
//					transaction=session.beginTransaction();
//					session.update(object);
//					transaction.commit();
//				}catch(Exception e){
//					if(transaction!=null){
//						transaction.rollback();
//					}
//					throw e;
//				}finally{
//					session.close();
//				}
//			}
//			//ɾ��
//			public static void deleteUser(Object object){
//				Session session=null;
//				Transaction transaction=null;
//				try{
//					session=HibernateUtils.getSession();
//					transaction=session.beginTransaction();
//					session.delete(object);
//					transaction.commit();
//				}catch(Exception e){
//					if(transaction!=null){
//						transaction.rollback();
//					}
//					throw e;
//				}finally{
//					session.close();
//				}
//			}
//			//��ѯ:���漰��¼�ĸı䣬������ľ�й�ϵ
//			public static Object getUserById(int id){
//				Object object=null;
//				Session session=null;
//				try{
//					session=HibernateUtils.getSession();
//					object=session.get(User.class,id);
//				}catch(Exception e){
//					throw e;
//				}finally{
//					session.close();
//				}
//				return object;
//			}
}
