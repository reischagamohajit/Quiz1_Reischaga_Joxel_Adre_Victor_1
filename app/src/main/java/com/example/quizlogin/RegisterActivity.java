package com.example.quizlogin;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizlogin.MainActivity;
import com.example.quizlogin.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        Button registerButton = findViewById(R.id.register_btn);
        final EditText usernameRegisterEdit = findViewById(R.id.input_name);
        final EditText passwordRegisterEdit = findViewById(R.id.input_password);
        final EditText retypePasswordRegisterEdit = findViewById(R.id.retype_password);
        final EditText emailRegisterEdit = findViewById(R.id.input_email);
        final EditText ageRegisterEdit = findViewById(R.id.input_age);


        final TextView alertMessage = findViewById(R.id.alert_Text);

        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);

                Bundle extras = new Bundle();

                String userNames = usernameRegisterEdit.getText().toString();
                String password = passwordRegisterEdit.getText().toString();
                String retypePass = retypePasswordRegisterEdit.getText().toString();
                String emailString = emailRegisterEdit.getText().toString();
                String ages = ageRegisterEdit.getText().toString();

                if(!userNames.matches("") && !password.matches("") && !retypePass.matches("") && !emailString.matches("") && !ages.matches("")) {
                    if(password.equals(retypePass)) {
                        Toast.makeText(RegisterActivity.this, "Register Success", Toast.LENGTH_SHORT).show();
                        extras.putString("username", userNames);
                        extras.putString("password", password);
                        extras.putString("confirmPassword", retypePass);
                        extras.putString("email", emailString);
                        extras.putString("ages", ages);
                        intent.putExtras(extras);
                        startActivity(intent);
                        finish();
                    } else {
                        alertMessage.setText("Password and confirm password are not match!!!");
                    }
                } else {
                    alertMessage.setText("Register Form Input Required!!!");
                }



            }
        });
    }
}


// RegisterActivity