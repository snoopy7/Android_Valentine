package com.lenneKsypoons.special;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


public class Third extends Activity implements OnClickListener{
	
	MyGraphics graphics;
	MediaPlayer blastoff;
	LinearLayout buttons;
	FrameLayout universe;
	Drawable my_drawable, my_button;
	Button fin;
	int pixels;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		universe = new FrameLayout (this);
		graphics = new MyGraphics(this);
		buttons = new LinearLayout(this);
		
		initializeButton();
		initializeLayout();
		
		//adding the surfaceView to the frame
		universe.addView(graphics);
		//adding the LinearLayout to the frame
		universe.addView(buttons);
		//setting the content to the frame
		setContentView(universe);
		
		fin.setOnClickListener(this);
		blastoff = MediaPlayer.create(this, R.raw.misslesound);
		blastoff.start();
			
	}
	
	@TargetApi(16)
	@SuppressWarnings("deprecation")
	private void initializeButton(){
		
		//fin is the actual button it's self
		fin = new Button(this);
		Context button_context = fin.getContext();
		
		my_button = button_context.getResources().getDrawable(R.drawable.custom2);
		
		if(android.os.Build.VERSION.SDK_INT >= 16){
			fin.setBackground(my_button);
		}else{
			fin.setBackgroundDrawable(my_button);
	
		}
		
		
	}
	
	@SuppressLint("NewApi")
	private void initializeLayout(){
		
		// buttons is the layout for the button
		buttons.setGravity(Gravity.CENTER);
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);

		// important section in dp to pixels conversion:
		// pixels = dp * (density/ 160)
		// we want the equivalent to 200dp in pixels.
		
		pixels = 200 * (metrics.densityDpi/ 160);
		if(android.os.Build.VERSION.SDK_INT >= 17){
			buttons.setPadding(0, pixels, 0, 0);
		}
	
		buttons.addView(fin);
		
	
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		blastoff.release();
		finish();
	}
	






	@TargetApi(16)
	@SuppressWarnings("deprecation")
public class MyGraphics extends View{
	
	Bitmap spaceship, background;
	float startXPos, startYPos;
	SurfaceHolder ourHolder;
	Thread ourThread = null;
	boolean initial = true;
	int messagePixels;
	int pixels2;

	public MyGraphics(Context context) {
		// TODO Auto-generated constructor stub
		this(context, null);
	}
		
	
	public MyGraphics(Context context, AttributeSet attrs){
		super(context, attrs);

		
		background = BitmapFactory.decodeResource(getResources(), R.drawable.outterspacefinal);
		if(android.os.Build.VERSION.SDK_INT >= 16){
			setBackground(new BitmapDrawable(getResources(), background));
		}else{
			setBackgroundDrawable(new BitmapDrawable(getResources(),background));
	
		}
		
		spaceship = BitmapFactory.decodeResource(getResources(), R.drawable.spaceship);
		
		DisplayMetrics dems = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dems);
	
		pixels2 = 25 * (dems.densityDpi/ 160);

		
	}


	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		Paint message = new Paint();
		Paint message2 = new Paint();
		message.setTextAlign(Align.CENTER);
		message.setTextSize(pixels2);
		message.setARGB(255, 255, 230, 230);
		
		message2 = message;
		
		
		if(initial){
			initial = false;
			 startXPos = 0;
			 startYPos = canvas.getHeight() - (2* spaceship.getHeight());
			
		}
		
		
		if(startXPos < canvas.getWidth()){
			
			canvas.drawBitmap(spaceship, startXPos, startYPos, null);
			
			startYPos -= 2;
			startXPos += 2;
		
		}
		else{
			
			canvas.drawText("Happy Valentines Day <3", canvas.getWidth()/2, canvas.getHeight() / 8, message );
			canvas.drawText("to My Love In Every Universe", canvas.getWidth() / 2, canvas.getHeight() / 4 , message2);
			
		}
		
		invalidate();
		
	}
	
	
	
	
	
	
	
	
	
	
}




}