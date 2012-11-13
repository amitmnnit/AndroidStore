package com.hsgc.store;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        addBackButtonListener();
        addSubmitButtonLister();
    }

    private void addBackButtonListener() {
    	Button button = (Button) findViewById(R.id.back_button);
    	button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LoginActivity.this, MainActivity.class);
				startActivity(intent);				
			}
    		
    	});
	}

	private void addSubmitButtonLister() {
    	Button button = (Button) findViewById(R.id.submit_button);
    	button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				boolean status = false;
				String message = "Login successful!";
				MainActivity.isLogin = true;
				status =  MainActivity.isLogin;
				
				if (!status) message = "Login unsuccessful!";
				
				Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();	
				
				if (status){
					Intent intent = new Intent(LoginActivity.this, MainActivity.class);
					startActivity(intent);	
				}
			}
    		
    	});
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_login, menu);
        return true;
    }
}
