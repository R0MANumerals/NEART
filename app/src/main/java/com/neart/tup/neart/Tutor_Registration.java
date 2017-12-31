package com.neart.tup.neart;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.RadioButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


    public class Tutor_Registration extends AppCompatActivity implements View.OnClickListener {

        //defining view objects
        private Button btnSignup;
        private EditText input_email, input_pass;

        private ProgressDialog progressDialog;

        //defining firebaseauth object
        private FirebaseAuth auth;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tutor_registration);

            //initializing firebase auth object
            auth = FirebaseAuth.getInstance();

            //if getCurrentUser does not returns null
            if (auth.getCurrentUser() != null) {
                //that means user is already logged in
                //so close this activity
                finish();

                //and open profile activity
                startActivity(new Intent(getApplicationContext(), Tutor_AttachFile.class));
            }

            //initializing View
            btnSignup = (Button) findViewById(R.id.signup_btn_register);
            input_email = (EditText) findViewById(R.id.signup_email);
            input_pass = (EditText) findViewById(R.id.signup_password);

            progressDialog = new ProgressDialog(this);

            //attaching listener to button
            btnSignup.setOnClickListener(this);
        }

        private void registerUser() {

            //getting email and password from edit texts
            String email = input_email.getText().toString().trim();
            String password = input_pass.getText().toString().trim();

            //checking if email and passwords are empty
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
                return;
            }

            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
                return;
            }

            //if the email and password are not empty
            //displaying a progress dialog

            progressDialog.setMessage("Registering Please Wait...");
            progressDialog.show();

            //creating a new user
            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //checking if success
                            if (task.isSuccessful()) {
                                finish();
                                startActivity(new Intent(getApplicationContext(), Tutor_AttachFile.class));
                            } else {
                                //display some message here
                                Toast.makeText(Tutor_Registration.this, "Registration Error", Toast.LENGTH_LONG).show();
                            }
                            progressDialog.dismiss();
                        }
                    });

        }

        @Override
        public void onClick(View view) {

            if (view == btnSignup) {
                registerUser();
            }

        }

        public void onRadioButtonClicked(View view) {
            boolean Checked = ((RadioButton) view).isChecked();

            switch (view.getId()) {
                case R.id.radioButton:
                    if (Checked)
                        break;

                case R.id.radioButton2:
                    if (Checked)
                        break;
                {
                }
            }
        }
    }