package cn.webank.weidea.dao.exception;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cn.webank.weidea.dao.KeyManagementRepository;
import cn.webank.weidea.entity.KeyManagement;


public class KeyManagementException implements KeyManagementRepository{
	Configuration config = new Configuration().configure();  
    SessionFactory sf = config.buildSessionFactory();  
    Session sess = sf.openSession();  
    Transaction tx = (Transaction) sess.beginTransaction(); 
	
	@Override
	public <S extends KeyManagement> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends KeyManagement> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KeyManagement findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<KeyManagement> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<KeyManagement> findAll(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(KeyManagement entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends KeyManagement> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public KeyManagement searchRecord(String idCard) {
		String sql = "select * from key_management";
		List<Object[]> result = (List<Object[]>) sess.createSQLQuery(sql).list();  
	    for (Object[] temp : result) {  
	        for (int i = 0; i < temp.length; i++) {  
	            System.out.println(temp[i]);  
	        }  
	    }  
	    tx.commit();  
	    sess.close();  
		return null;
	}

	@Override
	public int exist(String idCard) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
