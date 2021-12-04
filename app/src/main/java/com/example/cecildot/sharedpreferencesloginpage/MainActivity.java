package com.example.cecildot.sharedpreferencesloginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    EditText id,pwd;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id=(EditText) findViewById(R.id.edtname);
        pwd = (EditText) findViewById(R.id.edtpass);
        btn= (Button) findViewById(R.id.btnlogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userid = id.getText().toString();
                String pwdtxt = pwd.getText().toString();

                if(userid.equals("")||pwdtxt.equals("")){
                    Toast.makeText(MainActivity.this,"Fill All the fields",Toast.LENGTH_SHORT).show();
                }else if (userid.equals("adam")&&pwdtxt.equals("123")){

                    SharedPreferences sp = getSharedPreferences("userdetails",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("id",userid);
                    editor.putString("password",pwdtxt);
                    editor.commit();
                    Intent callhome = new Intent(MainActivity.this,NavActivity.class);
                    startActivity(callhome);

                }else{
                    Toast.makeText(MainActivity.this,"Id or password galat hai",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
