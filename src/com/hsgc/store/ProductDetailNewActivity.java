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
				Toast.makeText(ProductDetailNewActivity.this, "Save: Yet to be implemented!", Toast.LENGTH_SHORT).show();	
			}
    		
    	});	
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_product_detail_new, menu);
        return true;
    }
}
