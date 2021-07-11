package com.huida.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * 案例：
 * 针对复杂操作
 * HibernateBase没有必要写成HibernateUtils
 * @author Thinkpad T450
 *
 */
@SuppressWarnings("deprecation")//不赞成
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
	//添加
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
//			//修改
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
//			//删除
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
//			//查询:不涉及记录的改变，跟事务木有关系
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
