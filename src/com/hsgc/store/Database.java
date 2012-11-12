package com.hsgc.store;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * 
 * @author hamid
 *
 */
public class Database extends SQLiteOpenHelper {
	private static final String LOG_TAG = "UnitTest";
	private static final String TABLE = "Products";
	private static final String ID_COL = "id";
	private static final String NAME_COL = "name";
	private static final String BRAND_COL = "brand";
	private static final String SKU_COL = "sku";
	private static final String PRICE_COL = "price";
	private static final String QTY_COL = "quantity";

	/**
	 * 
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	public Database(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}
	
	public Database(Context context){
		this(context, "store.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = String.format("create table %s (%s integer not null, %s varchar(128) not null, " +
						"%s varchar(128), %s varchar(128), %s decimal(10, 2), %s integer, primary key(%s))", 
						TABLE, ID_COL, NAME_COL, BRAND_COL, SKU_COL, PRICE_COL, QTY_COL, ID_COL);
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {

	}
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public Integer create(Object entity){
		Integer id = -1;
		SQLiteDatabase db = getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		
		if (entity != null){
			for (Field field : entity.getClass().getDeclaredFields()) {
				String getterName = "get" + capitalize(field.getName());
				
				for (Method method : entity.getClass().getDeclaredMethods()) {
					if (method.getName().equals(getterName)) {
						try {
							Object value = method.invoke(entity, null);
							cv.put(field.getName(), ""+ value);
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    }
			    }
		    }	
		}
		
		cv.remove("id");
		Log.d(LOG_TAG, cv.toString());
	
		id =  new Integer((int)db.insert(TABLE, null, cv));
		Log.d(LOG_TAG, String.format("New record with id=%s created!!", id));
		return id;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public int delete(Integer id){
		return  getWritableDatabase().delete(TABLE, ID_COL +"=?", new String[]{id.toString()});
	}
	
	/**
	 * Yet to be implemented
	 * @param entity
	 * @param entityClass
	 * @return
	 */
	public Integer saveOrUpdate(Object entity, Class entityClass){
		
		return null;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Product get(Integer id){
		Product product = null;
		SQLiteDatabase db = getReadableDatabase();
		Cursor c = db.query(TABLE, new String[]{ID_COL, NAME_COL, BRAND_COL, SKU_COL, PRICE_COL, QTY_COL}, ID_COL + "=?", new String[]{id.toString()}, null, null, null);
		Log.d(LOG_TAG, "Cursor count: " + c.getCount());
		if (c.moveToFirst()){
			product = new Product(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getFloat(4), c.getInt(5));
		} 
		c.close();
		return product;
	}
	
	/**
	 * 
	 * @return
	 */
	public int size(){
		int size = 0;
		SQLiteDatabase db = getReadableDatabase();
		String sql = String.format("SELECT count(*) FROM %s", TABLE);
		Cursor c = db.rawQuery(sql, null);
		if (c.moveToFirst()){
			size = c.getInt(0);
		}
		c.close();
		return size;
	}
	
	/**
	 * 
	 * @param selections
	 * @param selectionArgs
	 * @return
	 */
	public List<Product> find(String selections, String selectionArgs[]){
		List<Product> result = new ArrayList<Product>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor c = db.query(TABLE, new String[]{ID_COL, NAME_COL, BRAND_COL, SKU_COL, PRICE_COL, QTY_COL}, selections, selectionArgs, null, null, null);
		while (c.moveToNext()){
			Product product = new Product(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getFloat(4), c.getInt(5));
			result.add(product);
		}		
		c.close();
		return result;
	}
	
	public List<Product> findAll(){
		return find(null, null);
	}
	/**
	 * Utility method to capitalize string
	 * @param s
	 * @return
	 */
	public static String capitalize(String s) {
        if (s.length() == 0) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
