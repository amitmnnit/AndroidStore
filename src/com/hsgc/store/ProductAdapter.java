package com.hsgc.store;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

public class ProductAdapter extends BaseAdapter implements ListAdapter {
	private List<Product> products ;
	private Context context;

	public ProductAdapter(Context context, List<Product> products){
		this.products = products;
		this.context  = context;
	}
	
	@Override
	public int getCount() {
		return products.size();
	}

	@Override
	public Object getItem(int location) {
		return products.get(location);
	}

	@Override
	public long getItemId(int location) {
		return products.get(location).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		try {
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	
			view = inflater.inflate(R.layout.product_list_main, null);
			TextView pidTV = (TextView)view.findViewById(R.id.product_id);
			TextView pNameTV = (TextView)view.findViewById(R.id.product_name);
			
			pidTV.setText(products.get(position).getId().toString());
			pNameTV.setText(products.get(position).getName());
		} catch (Exception e){
			Log.d("Store", "ProductAdapter", e);
		} 
			
		return view;
	}

}
