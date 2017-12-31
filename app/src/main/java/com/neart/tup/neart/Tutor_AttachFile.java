package com.neart.tup.neart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Tutor_AttachFile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_attach_file);
    }
    public void buttonClick1 (View view) {
        Intent intent = new Intent(Tutor_AttachFile.this, SecondActivity.class);
        startActivity(intent);
    }

}
