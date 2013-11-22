package com.lenneKsypoons.special;



import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class First extends Activity implements OnClickListener{
	
	Button start;
	MediaPlayer ourSong;
	EditText name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		initialize();
		
	}
	
		
	private void initialize()
	{
		ourSong = MediaPlayer.create(this, R.raw.beachboys);
		ourSong.start();
		
		start = (Button) findViewById(R.id.bStart);
		start.setOnClickListener(this);
		
		name = (EditText) findViewById(R.id.etStart);
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_first, menu);
		return true;
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		String lovesName = name.getText().toString();
		Bundle carry = new Bundle();
		carry.putString("key", lovesName);
		Intent i = new Intent(First.this, Second.class);
		i.putExtras(carry);
		startActivity(i);
		
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}
	
	

}
