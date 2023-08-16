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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.weddingplanner.Dessert.DessertAdapter;
import com.example.weddingplanner.Drinks.DrinkAdapter;
import com.example.weddingplanner.Lunch.FoodAdapter;
import com.example.weddingplanner.MealsData.Desserts;
import com.example.weddingplanner.MealsData.Drinks;
import com.example.weddingplanner.MealsData.Meals;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class userPage extends AppCompatActivity{



    public String LunchName,  DrinkName , dessertsname ;

    public String ExtraGuestName;

    private FoodAdapter mFoodAdapter  ;

    private DrinkAdapter mDrinkAdapter ;

    private DessertAdapter mDessertAdapter ;


    public  EditText nametxt, phonenum , guestname ;
    public  Button Navigatebtn, vidbtn ,  sbmtbtn ;

    DatabaseReference UserData ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_user_page);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.Radiobtn) ;
        RadioButton yesbtn = (RadioButton) findViewById(R.id.yesbtn);
        RadioButton nobtn =  (RadioButton) findViewById(R.id.nobtn) ;
         sbmtbtn = (Button) findViewById(R.id.submitbtn) ;
        Navigatebtn = (Button) findViewById(R.id.Navigatebtn) ;
        vidbtn = (Button) findViewById(R.id.Videobtn) ;

         nametxt = (EditText) findViewById(R.id.name) ;
         phonenum = (EditText) findViewById(R.id.phonenum) ;
         guestname = (EditText) findViewById(R.id.extraguestname) ;


        Spinner LunchSpinner = (Spinner) findViewById(R.id.LunchSpinner ) ;
        Spinner DrinksSpinner = (Spinner) findViewById(R.id.DrinksSpinner);
        Spinner DessertSpinner = (Spinner) findViewById(R.id.DessertSpinner) ;





        // Create a list of food items
        List<Meals> foodList = new ArrayList<>();
        foodList.add(new Meals(1, "Lobster", R.drawable.newlobster));
        foodList.add(new Meals(2, "Shawerma", R.drawable.newshawerma));
        foodList.add(new Meals(3, "Steak", R.drawable.newsteak));

        List<Drinks> drinksList = new ArrayList<>();
        drinksList.add(new Drinks( 1, "Margarita" , R.drawable.margarita ));
        drinksList.add(new Drinks( 2, "Cosmopolitan" , R.drawable.cosmopolitan ));


        List<Desserts> dessertsList = new ArrayList<>() ;
        dessertsList.add( new Desserts(1 , "cheesecake", R.drawable.cheesecake ))  ;
        dessertsList.add( new Desserts(2 , "fruittarts", R.drawable.fruittarts ))  ;


        mDrinkAdapter = new DrinkAdapter(this, drinksList) ;
        // Create a new food adapter
        mFoodAdapter = new FoodAdapter(this, foodList);
        mDessertAdapter = new DessertAdapter(this ,dessertsList ) ;


        // Set the adapter on the spinner
        LunchSpinner.setAdapter(mFoodAdapter);

        // Set a selection listener on the spinner
        LunchSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected food item
                Meals food = (Meals) parent.getItemAtPosition(position);
                 LunchName = food.getLunch();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        DrinksSpinner.setAdapter(mDrinkAdapter);

        DrinksSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Drinks drinks = (Drinks) parent.getItemAtPosition(position) ;
                 DrinkName = drinks.getDrink();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        DessertSpinner.setAdapter(mDessertAdapter);

        DessertSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Desserts desserts = (Desserts) parent.getItemAtPosition(position) ;
                dessertsname = desserts.getDessert();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        UserData = FirebaseDatabase.getInstance().getReference().child("Invitations") ;




        sbmtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = nametxt.getText().toString();
                String PhoneNum = phonenum.getText().toString() ;
                ExtraGuestName = guestname.getText().toString();

                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if( yesbtn.isChecked() )
                        {
                            ExtraGuestName = guestname.getText().toString() ;
                        }
                        else
                        {
                            ExtraGuestName = "--";
                        }
                    }
                });
                if( Name.isEmpty() || PhoneNum.isEmpty()  || LunchName.isEmpty() || DrinkName.isEmpty() ||
                        dessertsname.isEmpty()  )
                {
                    Toast.makeText(userPage.this , "please enter all data" , Toast.LENGTH_SHORT ).show();
                    return;
                }

                UserList newuserlist = new UserList(Name,PhoneNum,ExtraGuestName,LunchName,DrinkName,dessertsname);
                UserData.push().setValue(newuserlist) ;


                Toast.makeText(userPage.this , "Data inserted" , Toast.LENGTH_SHORT ).show();

                sbmtbtn.setEnabled(false);
            }
        });




        Navigatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW ,
                        Uri.parse("google.navigation:q=39.969840,32.823383&mode=l"));
                // l d w
                        intent.setPackage("com.google.android.apps.maps") ;
                if( intent.resolveActivity(getPackageManager()) != null  )
                {
                    startActivity(intent);
                }
            }
        });

        vidbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(userPage.this ,videointent.class );
               startActivity(intent);
            }
        });




        TextView usernametxt = (TextView) findViewById(R.id.Usernametxt) ;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String usernamevalue = extras.getString("username");
            usernametxt.setText("Welcome "+usernamevalue);
        }



    }


}




