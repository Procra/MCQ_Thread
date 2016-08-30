package com.example.qcm;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements Runnable {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Thread test = new Thread(this);
		test.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@SuppressLint("ShowToast")
	public void verifier(View view){
		@SuppressWarnings("unused")
		RadioButton radio1 = (RadioButton)findViewById(R.id.r1);
		RadioButton radio2 = (RadioButton)findViewById(R.id.r2);
		RadioButton radio3 = (RadioButton)findViewById(R.id.r3);
		@SuppressWarnings("unused")
		RadioButton radio4 = (RadioButton)findViewById(R.id.r4);
		@SuppressWarnings("unused")
		RadioButton radio5 = (RadioButton)findViewById(R.id.r5);
		RadioButton radio6 = (RadioButton)findViewById(R.id.r6);
		int score = 0;
		if(radio2.isChecked()){score++;}
		if(radio3.isChecked()){score++;}
		if(radio6.isChecked()){score++;}
		String message = score + " bonne(s) réponse(s)...";
		Toast.makeText(getBaseContext(), message, 5).show();
		score = 0;
	}
	
	public void recommencer(View view){
		RadioButton radio1 = (RadioButton)findViewById(R.id.r1);
		RadioButton radio2 = (RadioButton)findViewById(R.id.r2);
		RadioButton radio3 = (RadioButton)findViewById(R.id.r3);
		RadioButton radio4 = (RadioButton)findViewById(R.id.r4);
		RadioButton radio5 = (RadioButton)findViewById(R.id.r5);
		RadioButton radio6 = (RadioButton)findViewById(R.id.r6);
		radio1.setChecked(false);
		radio2.setChecked(false);
		radio3.setChecked(false);
		radio4.setChecked(false);
		radio5.setChecked(false);
		radio6.setChecked(false);
		Button btn_verif = (Button) findViewById(R.id.verifier);
		btn_verif.setEnabled(true);
		Thread test2 = new Thread(this);
		test2.start();
	}

	@Override
	public void run() {
		try {
			for(int decompte=0;decompte<=20;decompte++){
				Thread.sleep(1000);
			}
			runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(MainActivity.this,"Temps écoulé...",Toast.LENGTH_LONG).show();
                    Button btn_verif = (Button) findViewById(R.id.verifier);
                    btn_verif.setEnabled(false);
               }
           });
		} catch (InterruptedException e) {e.printStackTrace();}	
	}
}
