package com.hsgc.store;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
/**
 * 
 * @author hamid
 *
 */
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateProductList();
        addListItemListener();
        addNewButtonListener();
        addSyncButtonListener();
        addLoginButtonListener();
    }

    private void addLoginButtonListener() {
    	Button button = (Button)findViewById(R.id.login_button);
    	button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "Login: Yet to be implemented!", Toast.LENGTH_SHORT).show();	
			}
    	});
	}

	private void addSyncButtonListener() {
    	Button button = (Button)findViewById(R.id.sync_button);
    	button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "Sync: Yet to be implemented!", Toast.LENGTH_SHORT).show();	
			}
    	});
	}

	private void addNewButtonListener() {
    	Button button = (Button)findViewById(R.id.new_button);
    	button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, ProductDetailNewActivity.class);
				startActivity(intent);			
			}
    	});
	}

	private void addListItemListener() {
    	ListView lv = (ListView)findViewById(R.id.product_list);
    	lv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int arg2,
					long arg3) {
				Intent intent = new Intent(MainActivity.this, ProductDetailViewActivity.class);
				startActivity(intent);
			}
    		
    	});
	}

	private void populateProductList() {
    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"iPhone", "Galaxy", "Blackberry", "Nexus"});
    	ListView lv = (ListView)findViewById(R.id.product_list);
    	lv.setAdapter(adapter);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
