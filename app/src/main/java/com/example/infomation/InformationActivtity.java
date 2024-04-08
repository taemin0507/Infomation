package com.example.infomation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InformationActivtity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Intent it = getIntent();
        String id = it.getStringExtra("id");

        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextAge = findViewById(R.id.editTextAge);

        RadioButton radioMale = findViewById(R.id.radioMale);
        RadioButton radioFemale = findViewById(R.id.radioFemale);

        CheckBox cBInfo = findViewById(R.id.cBInfo);
        CheckBox cBAI = findViewById(R.id.cBAI);
        CheckBox cBSecurity = findViewById(R.id.cBSecurity);

        Button btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent it = new Intent();
               it.putExtra("id", id);
               it.putExtra("name", editTextName.getText().toString());
               it.putExtra("age", editTextAge.getText().toString());
               if (radioMale.isChecked())
                   it.putExtra("gender", "남자");
               else
                   it.putExtra("gender", "여자");
               String strLicense = "";
               if (cBInfo.isChecked())
                   strLicense = strLicense + "\n 정보처리기사";
               if (cBAI.isChecked())
                   strLicense = strLicense + "\n 인공지능전문가";
               if (cBSecurity.isChecked())
                   strLicense = strLicense + "\n 정보보안기사";
               it.putExtra("License",strLicense);
               setResult(RESULT_OK, it);
               finish();
            }
        });
    }
}
