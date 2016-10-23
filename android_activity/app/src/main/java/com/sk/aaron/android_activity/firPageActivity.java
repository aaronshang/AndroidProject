package com.sk.aaron.android_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class firPageActivity extends AppCompatActivity {

    private Button backBtn;
    private EditText sumValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fir_page);

        Intent intent = getIntent();
        String key1 = intent.getStringExtra("num1_key");
        String key2 = intent.getStringExtra(MainActivity.key2_msg);

        TextView desTextView = (TextView) findViewById(R.id.textView5);
        String msg = key1+"+"+key2+"=";
        desTextView.setText(msg);

        sumValue = (EditText) findViewById(R.id.editText3);

        backBtn = (Button) findViewById(R.id.button2);

        backBtn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {

                                           Intent intent = new Intent();
                                           Bundle bundleBack = new Bundle();
                                           bundleBack.putString("sum", sumValue.getText().toString());
                                           intent.putExtras(bundleBack);

                                           setResult(RESULT_OK, intent);

                                           finish();
                                       }
                                   }
        );
    }
}
