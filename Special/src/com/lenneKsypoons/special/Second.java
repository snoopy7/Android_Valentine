package com.lenneKsypoons.special;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Second extends Activity implements OnClickListener, OnCheckedChangeListener{

	Button enter;
	TextView result, name;
	RadioGroup selectionList;
	String temp;
	int num;
	String loveIs;
	String blank = "";
	Bundle my_bundle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		initialize();
		getdata();
		

	
	}
	
	
	private void initialize(){
		enter = (Button) findViewById(R.id.button1);
		enter.setOnClickListener(this);
		
		result = (TextView) findViewById(R.id.textView2);
		
		name = (TextView) findViewById(R.id.textView1);
		name.setTextColor(Color.rgb(236, 98, 156));
		
		selectionList = (RadioGroup) findViewById(R.id.radioGroup1);
		selectionList.setOnCheckedChangeListener(this);

				
		
		
	}
	
	private void getdata(){
		// this gets the intent that was passes into the class
		
		
		my_bundle = getIntent().getExtras();
		
		// this gets the item put into the bundle via it's key
			loveIs = my_bundle.getString("key");
			
			name.setText(loveIs + " is...");
	
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent a = new Intent(Second.this, Third.class);
		startActivity(a);
		
		
	}


	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		result.setTextSize(20);
		result.setTextColor(Color.rgb(236, 98, 156));

		
		switch(checkedId){
		case R.id.radio0:
			temp = "Wrong! But, you are Cute and Cuddly";
			result.setText(temp);
			
			break;
		case R.id.radio1:
			temp = "Noope! But, I want to want to take your toppings off :P";
			result.setText(temp);
			
			break;
		case R.id.radio2:
			Random crazy = new Random();
			num = crazy.nextInt(75);
			
			if(num <25){
				temp = "Correct!!!!!";
			}else if(num <50){
				temp = "Correct :) :)";
			}else{
				temp = "Correct <3";
				
			}
			
			result.setText(temp);
			result.setTextSize(num);
			result.setTextColor(Color.rgb(crazy.nextInt(254), crazy.nextInt(254), crazy.nextInt(254)));
			
			
			break;
		}
		
		
		
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	

}
