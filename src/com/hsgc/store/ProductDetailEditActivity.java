package com.hsgc.store;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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
        addBackButtonListener();
        addDeleteButtonListener();
        addSaveButtonListener();
    }

    private void addSaveButtonListener() {
    	Button button = (Button)findViewById(R.id.save_button);
    	button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Toast.makeText(ProductDetailEditActivity.this, "Save: Yet to be implemented!", Toast.LENGTH_SHORT).show();	
			}
    		
    	});	
	}

	private void addDeleteButtonListener() {
    	Button button = (Button)findViewById(R.id.delete_button);
    	button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Toast.makeText(ProductDetailEditActivity.this, "Delete: Yet to be implemented!", Toast.LENGTH_SHORT).show();	
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
