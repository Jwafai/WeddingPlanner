package com.example.weddingplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class adminPage extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {


    private GestureDetectorCompat mDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_admin_page);

        Button sendemailbtn = findViewById(R.id.SendEmail) ;
        Button viewcomingbtn = findViewById(R.id.Viewinv) ;

        sendemailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(adminPage.this ,EmailActivity.class );
                startActivity(emailIntent);
            }
        });

        viewcomingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

    String DatabaseURL = "https://console.firebase.google.com/u/0/project/weddingdatabase-e89c3/database/weddingdatabase-e89c3-default-rtdb/data" ;

    Intent ComingsIntent = new Intent(Intent.ACTION_VIEW);
                ComingsIntent.setData(Uri.parse(DatabaseURL)) ;
                        startActivity(ComingsIntent);


                /* Intent intent = new Intent( adminPage.this , UserRececyler.class ) ;
                startActivity(intent); */
            }
        });

        mDetector = new GestureDetectorCompat(this,this);
        mDetector.setOnDoubleTapListener(this);



    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        mDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }



    public boolean onDown(MotionEvent event) {
        Toast.makeText(getBaseContext(), "onDown",
                Toast.LENGTH_SHORT).show();
        return true;
    }



    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        Toast.makeText(getBaseContext(), "onFling",
                Toast.LENGTH_SHORT).show();
        return true;
    }


    public void onLongPress(MotionEvent event) {
        Toast.makeText(getBaseContext(), "onLongPress",
                Toast.LENGTH_SHORT).show();
    }


    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        Toast.makeText(getBaseContext(), "onScroll",
                Toast.LENGTH_SHORT).show();
        return true;
    }

    public void onShowPress(MotionEvent event) {
        Toast.makeText(getBaseContext(), "onShowpress",
                Toast.LENGTH_SHORT).show();
    }


    public boolean onSingleTapUp(MotionEvent event) {
        Toast.makeText(getBaseContext(), "onSingleTapUp",
                Toast.LENGTH_SHORT).show();
        return true;
    }


    public boolean onDoubleTap(MotionEvent event) {
        Toast.makeText(getBaseContext(), "onDoubleTap",
                Toast.LENGTH_SHORT).show();
        return true;
    }


    public boolean onDoubleTapEvent(MotionEvent event) {
        Toast.makeText(getBaseContext(), "onDoubleTapEvent",
                Toast.LENGTH_SHORT).show();
        return true;
    }


    public boolean onSingleTapConfirmed(MotionEvent event) {
        Toast.makeText(getBaseContext(), "onSingleTapConfirmed",
                Toast.LENGTH_SHORT).show();
        return true;
    }

}


