package com.example.aop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.aop.aop.annotation.CheckLogin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //rxjava 回调嵌套
        setContentView(R.layout.activity_main);
    }

    //pocket has money ？？？用于记录日志的代码和业务代码缠绕在一起，若要更改，这设计成百上千个地方要改
    /*
    在AOP中，我们将这些具有公共逻辑的，与其他模块的核心逻辑纠缠在一起的行为成为“横切关注点”
     */
    @CheckLogin
    public void seeMovie(View view) {
        Toast.makeText(this, "已登录，看电影", Toast.LENGTH_SHORT).show();
    }
    @CheckLogin
    public void goShopping(View view) {
        Toast.makeText(this, "已登录，购物", Toast.LENGTH_SHORT).show();
    }
    @CheckLogin
    public void eatDinner(View view) {
        Toast.makeText(this, "已登录，吃饭", Toast.LENGTH_SHORT).show();
    }
}