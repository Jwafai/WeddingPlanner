package com.example.weddingplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> passwordList = new ArrayList<>();
    private ArrayList<String> usernamelist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);



        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);
        View layoutView = getLayoutInflater().inflate(R.layout.activity_user_page , null) ;
        TextView usernameTxt =(TextView) layoutView.findViewById(R.id.Usernametxt) ;

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);





        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    JSONObject jsonObject = new JSONObject( JsonDataFromAsset() );
                    JSONArray jsonArray = jsonObject.getJSONArray("users");

                    for( int i = 0 ; i < jsonArray.length() ; i++ )
                    {
                       JSONObject userData = jsonArray.getJSONObject(i) ;
                        if( username.getText().toString().equals(userData.getString("username"))
                                &&  password.getText().toString().equals(userData.getString("password") ) )
                        {
                            String name = username.getText().toString() ;
                            Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, userPage.class) ;
                            intent.putExtra("username", name) ;
                            startActivity(intent);
                        }
                        else if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                            Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, adminPage.class) ;
                            startActivity(intent);
                        }

                        else
                        {
                            Toast.makeText(MainActivity.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();

                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        });



    }

    private String JsonDataFromAsset() {

        String json = null ;
        try {
            InputStream inputStream = getAssets().open("users.json");
            int sizeOfFile = inputStream.available();
            byte[] bufferData = new byte[sizeOfFile] ;
            inputStream.read(bufferData) ;
            inputStream.close();
            json = new String(bufferData , "UTF-8") ;

        } catch (IOException e) {
            e.printStackTrace();
            return null ;
        }
        return json ;
    }
}