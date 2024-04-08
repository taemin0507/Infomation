package com.example.infomation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView tVResult, tVResultLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextId = findViewById(R.id.editTextID);
        tVResult = findViewById(R.id.tVResult);
        tVResultLabel = findViewById(R.id.tVResultLAbel);
        Button btnRequest = findViewById(R.id.btnRequest);
        Button btnEnd = findViewById(R.id.btnEnd);
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "";
                str = editTextId.getText().toString();
                Intent it = new Intent(getApplicationContext(), InformationActivtity.class);
                it.putExtra("id",str);
                startActivityForResult(it, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK){
            String str = "아이디: " + data.getStringExtra("id");
            str = str + "\n이름: " + data.getStringExtra("name");
            str = str + "\n나이: " + data.getStringExtra("age");
            str = str + "\n성별: " + data.getStringExtra("gender");
            str = str + "\n자격증: " + data.getStringExtra("License");
            tVResult.setText(str);
            tVResultLabel.setText("전송\n결과");
        }
    }
}