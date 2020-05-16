package com.example.appli;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    
    Button b1,b2;
    EditText ed1,ed2;

    TextView tx1;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        b1 = (Button)findViewById(R.id.button);
        b1.setBackgroundColor(Color.BLUE);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);
        final Intent i=new Intent(MainActivity.this,details.class);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("admin") && ed2.getText().toString().equals("admin")) {
                    System.out.println("Password");
                    i.putExtra("username","admin");
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                    tx1.setVisibility(View.VISIBLE);
                    tx1.setBackgroundColor(Color.RED);
                    counter--;
                    tx1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        b1.setEnabled(false);
                    }
                }
            }
        });


    }
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText word=(EditText) findViewById(R.id.word);
        Button btnSubmit= (Button) findViewById(R.id.button);
        final TextView tvResults=(TextView) findViewById(R.id.textView);

        btnSubmit.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                String idNumber= word.getText().toString().trim();
                String dob=idNumber.substring(0,6);
                int gender=Integer.parseInt(Character.toString(idNumber.charAt(6)));
                String sGender;
                if(gender<5){
                    sGender="Female";
                }
                else
                    sGender="Male";
                int nationality=Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String snationality;
                if(nationality==0) {
                    snationality = "SA Citizen";
                }
                else
                    snationality="Permanent Resident";
                System.out.println("222");
                String text=dob+"\n"+getString(gender)+sGender+getString(nationality)+snationality;
                tvResults.setText(text);
                                         }
                                     }
        );
        /*etID=(TextView) findViewById(R.id.word);
        //etID=(EditText) findViewById(R.id.word);
        btnSubmit= (Button) findViewById(R.id.button);
        tvResults=(TextView) findViewById(R.id.textView);

        btnSubmit.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                String idNumber= etID.getText().toString().trim();
                String dob=idNumber.substring(0,6);
                int gender=Integer.parseInt(Character.toString(idNumber.charAt(6)));
                String sGender;
                if(gender<5){
                    sGender="Female";
                }
                else
                    sGender="Male";
                int nationality=Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String snationality;
                if(nationality==0) {
                    snationality = "SA Citizen";
                }
                else
                    snationality="Permanent Resident";
                String text=getString(R.string.dob)+dob+"\n"+getString(R.string.gender)+sGender+getString(R.string.nationality)+snationality;
                tvResults.setText(text);
            }
        }
        );*/
