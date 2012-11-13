package com.hsgc.store;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 
 * @author hamid
 *
 */
public class ProductDetailEditActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail_edit);
        
        populateProductForm();
        addBackButtonListener();
        addDeleteButtonListener();
        addSaveButtonListener();
    }

    private void populateProductForm() {
        if (MainActivity.product != null){
	        ((TextView)findViewById(R.id.eproduct_id)).setText("" + MainActivity.product.getId());
	        ((TextView)findViewById(R.id.eproduct_name)).setText(MainActivity.product.getName());
	        ((TextView)findViewById(R.id.eproduct_brand)).setText(MainActivity.product.getBrand());
	        ((TextView)findViewById(R.id.eproduct_sku)).setText(MainActivity.product.getSku());
	        ((TextView)findViewById(R.id.eproduct_price)).setText("" + MainActivity.product.getPrice());
	        ((TextView)findViewById(R.id.eproduct_qty)).setText("" + MainActivity.product.getQuantity());
        }   
	}
    
    private void addSaveButtonListener() {
    	Button button = (Button)findViewById(R.id.save_button);
    	button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				boolean status = false;
				String message = "Product updated!";
				try {
			        //String pid = ((TextView)findViewById(R.id.eproduct_id)).getText().toString();
			        String name = ((TextView)findViewById(R.id.eproduct_name)).getText().toString();
			        String brand = ((TextView)findViewById(R.id.eproduct_brand)).getText().toString();
			        String sku = ((TextView)findViewById(R.id.eproduct_sku)).getText().toString();
			        String price = ((TextView)findViewById(R.id.eproduct_price)).getText().toString();
			        String qty = ((TextView)findViewById(R.id.eproduct_qty)).getText().toString();
					
			        Product product = new Product(MainActivity.product.getId(), name, brand, sku, Float.valueOf(price), Integer.valueOf(qty));
			        status = MainActivity.db.update(product);	        
				} catch (Exception e){
					Log.d("Store", "Saving error", e);
					message = "Product not updated!";
				}
		        Toast.makeText(ProductDetailEditActivity.this, message, Toast.LENGTH_SHORT).show();	
		        if (status) {
					Intent intent = new Intent(ProductDetailEditActivity.this, ProductDetailViewActivity.class);
					startActivity(intent);		        	
		        }			
		    }
    		
    	});	
	}

	private void addDeleteButtonListener() {
    	Button button = (Button)findViewById(R.id.delete_button);
    	button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				String message = "Product deleted!";
				boolean status = MainActivity.db.delete(MainActivity.product.getId());
				if (status) message = "Product not deleted!";
				Toast.makeText(ProductDetailEditActivity.this, message, Toast.LENGTH_SHORT).show();	
				if (status){
					Intent intent = new Intent(ProductDetailEditActivity.this, MainActivity.class);
					startActivity(intent);					
				}
			}
    		
    	});
	}

	private void addBackButtonListener() {
    	Button button = (Button)findViewById(R.id.back_button);
    	button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ProductDetailEditActivity.this, ProductDetailViewActivity.class);
				startActivity(intent);
			}
    		
    	});
	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_product_detail_edit, menu);
        return true;
    }
}
