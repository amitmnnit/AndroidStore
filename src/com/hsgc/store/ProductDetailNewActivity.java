package com.hsgc.store;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
public class ProductDetailNewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail_new);
        addBackButtonListener();
        addCancelButtonListener();
        addSaveButtonListener();
    }

    private void addBackButtonListener() {
    	Button button = (Button)findViewById(R.id.back_button);
    	button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ProductDetailNewActivity.this, MainActivity.class);
				startActivity(intent);
			}
    		
    	});	
	}

	private void addCancelButtonListener() {
    	Button button = (Button)findViewById(R.id.cancel_button);
    	button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ProductDetailNewActivity.this, MainActivity.class);
				startActivity(intent);
			}
    		
    	});	
	}

	private void addSaveButtonListener() {
    	Button button = (Button)findViewById(R.id.save_button);
    	button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				boolean status = false;
				String message = getString(R.string.product_saved_text);
				try {
			        //String pid = ((TextView)findViewById(R.id.nproduct_id)).getText().toString();
			        String name = ((TextView)findViewById(R.id.nproduct_name)).getText().toString();
			        String brand = ((TextView)findViewById(R.id.nproduct_brand)).getText().toString();
			        String sku = ((TextView)findViewById(R.id.nproduct_sku)).getText().toString();
			        String price = ((TextView)findViewById(R.id.nproduct_price)).getText().toString();
			        String qty = ((TextView)findViewById(R.id.nproduct_qty)).getText().toString();
					
			        Product product = new Product(null, name, brand, sku, Float.valueOf(price), Integer.valueOf(qty));
			        int count = MainActivity.db.create(product);
			        status = (count > 0);
			        
				} catch (Exception e){
					Log.d("Store", "Saving error", e);
					message = getString(R.string.product_not_saved_text);
				}
		        Toast.makeText(ProductDetailNewActivity.this, message, Toast.LENGTH_SHORT).show();	
		        if (status) {
					Intent intent = new Intent(ProductDetailNewActivity.this, MainActivity.class);
					startActivity(intent);		        	
		        }
			}
    		
    	});	
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_product_detail_new, menu);
        return true;
    }
}
