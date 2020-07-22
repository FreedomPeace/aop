package com.example.aop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArraySet;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aop.aop.UserInfo;

import java.util.HashSet;

public class LoginActivity extends AppCompatActivity {

    private EditText uname;
    private EditText pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        uname = findViewById(R.id.username);
        pwd = findViewById(R.id.password);
    }

    public void login(View view) {
        String uname = this.uname.getText().toString();
        String pwd = this.pwd.getText().toString();
        if (TextUtils.isEmpty(uname)||TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "用户名，密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
//        getSharedPreferences("basicInfo", MODE_PRIVATE).edit().putString("username", uname)
//                .putString("pwd",pwd)
//                .apply();
        UserInfo.username = uname;
        UserInfo.password = pwd;
        finish();
    }

    public void jumpLogin(View view) {
        finish();
    }
}