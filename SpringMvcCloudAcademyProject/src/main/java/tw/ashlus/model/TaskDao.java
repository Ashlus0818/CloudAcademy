package tw.ashlus.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TaskDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<BeforeCompleteTask> selectAllFromBTask(){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from BeforeCompleteTask");
		List<BeforeCompleteTask> list = query.list();
		session.close();
		return list;
	}
	public List<AfterCompleteTask> selectAllFromATask(){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from AfterCompleteTask");
		List<AfterCompleteTask> list = query.list();
		session.close();
		return list;
	}
	public void insert(BeforeCompleteTask taskBean){
		Session session = sessionFactory.openSession();
		if(taskBean != null) {
			session.save(taskBean);
		}		
		session.close();
	}
	public void deleteById(Integer num) {
		Session session = sessionFactory.openSession();
		if(num != null) {
			System.out.println("===========");
			String hql = "delete from BeforeCompleteTask where id=:num";
			Query query = session.createQuery(hql);
		}		
		session.close();
	}
}
