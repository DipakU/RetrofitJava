package com.example.retrofitjava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofitjava.Activity.DataBindingActivity;
import com.example.retrofitjava.Activity.RetrofitActivity;
import com.example.retrofitjava.Activity.ViewBindingActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Activity CurrentActivity = MainActivity.this;
    private Button btn_data_binding, btn_view_binding, btn_retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UIComponent();
    }

    private void UIComponent() {
        btn_data_binding = findViewById(R.id.btn_data_binding);
        btn_view_binding = findViewById(R.id.btn_view_binding);
        btn_retrofit = findViewById(R.id.btn_retrofit);

        btn_data_binding.setOnClickListener(this);
        btn_view_binding.setOnClickListener(this);
        btn_retrofit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_data_binding:
                Intent intent_data = new Intent(CurrentActivity, DataBindingActivity.class);
                startActivity(intent_data);
                break;
            case R.id.btn_view_binding:
                Intent intent_view = new Intent(CurrentActivity, ViewBindingActivity.class);
                startActivity(intent_view);
                break;
            case R.id.btn_retrofit:
                Intent intent_retrofit = new Intent(CurrentActivity, RetrofitActivity.class);
                startActivity(intent_retrofit);
                break;
        }
    }
}