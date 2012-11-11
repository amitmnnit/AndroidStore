package com.hsgc.store;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * 
 * @author hamid
 *
 */
public class ProductDetailViewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail_view);
        addBackButtonListener();
        addEditButtonListener();
    }

    private void addBackButtonListener() {
    	Button button = (Button)findViewById(R.id.back_button);
    	button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ProductDetailViewActivity.this, MainActivity.class);
				startActivity(intent);
			}
    		
    	});
	}

    private void addEditButtonListener() {
    	Button button = (Button)findViewById(R.id.edit_button);
    	button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ProductDetailViewActivity.this, ProductDetailEditActivity.class);
				startActivity(intent);
			}
    		
    	});
	}
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_product_detail_view, menu);
        return true;
    }
}
