package com.hsgc.store.test;

import java.util.List;

import android.test.AndroidTestCase;
import android.util.Log;

import com.hsgc.store.Database;
import com.hsgc.store.Product;
/**
 * 
 * @author hamid
 *
 */
public class DatabaseTest extends AndroidTestCase {
	private static final String LOG_JUNIT = "JUNIT";
	private static final Integer DB_EXEC_ERROR = new Integer(-1);
	private static int size = 0;
	Database db;
	Product product;
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		db = new Database(getContext(), "store.db", null, 1);
		product = new Product(null, "iPhone", "Apple", "APP100", 1000.00F, 1);		
		size = db.size();
		Log.d(LOG_JUNIT, "Current record size: " + size);
		Log.d(LOG_JUNIT, "setUp() called!");
	}


	public void testSize(){
		assertEquals(size, db.size());
		Log.d(LOG_JUNIT, "testSize() called!");
	}
	
	public void testCreate(){
		Integer id = db.create(product);
		assertNotSame(DB_EXEC_ERROR, id);
		assertTrue(  db.size() > size);	
		Log.d(LOG_JUNIT, "testCreate() called!");
		assertTrue(db.get(id) != null);
		Log.d(LOG_JUNIT, "testGet() called!");		
	}	

	public void testUpdate(){
		product.setId(1);
		product.setName("Galaxy");
		boolean status = db.update(product);
		assertTrue(status);
		product = db.get(product.getId());
		assertEquals(product.getName(), "Galaxy");
		Log.d(LOG_JUNIT, "testUpdate() called!");
	}	
	
	public void testFind(){
		List<Product> list = db.find("id IN (?, ?, ?)", new String[]{"1","2","3"});
		assertTrue(list.size() > 0);
		Log.d(LOG_JUNIT, "testFind() called!");
	}
	
	public void testFindAll(){
		List<Product> list = db.findAll();
		assertTrue(list.size() > 0);
		Log.d(LOG_JUNIT, "testFindAll() called!");		
	}
	
	public void testDelete(){
		Integer id = db.create(product);
		assertNotSame(DB_EXEC_ERROR, id);
		assertTrue(db.delete(id));
		Log.d(LOG_JUNIT, "testDelete() called!");
	}
}
