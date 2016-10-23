package com.sk.aaron.android_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static  String key2_msg = "num2_key";
    public final static  int ReasonCode = 1;
    private Button firstButton;
    private EditText number1;
    private EditText number2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstButton = (Button)findViewById(R.id.button);
        number1 = (EditText)findViewById(R.id.editText);
        number2 = (EditText)findViewById(R.id.editText2);


        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("--sk", number1.getText().toString());
                Log.e("--sk", number2.getText().toString());

                Toast.makeText(MainActivity.this, "prepare show first page", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, firPageActivity.class);

                intent.putExtra("num1_key", number1.getText().toString());
                intent.putExtra(key2_msg, number2.getText().toString());

//              带回传结果的意图
                startActivityForResult(intent, ReasonCode);

//              普通传值
//                startActivity(intent);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle bundleResult = data.getExtras();
            String sumValue = bundleResult.getString("sum");
            Log.i("--sk", sumValue);
        }
    }
}
