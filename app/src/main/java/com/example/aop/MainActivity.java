package com.example.aop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

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
    public void seeMovie(View view) {
        @Deprecated
        String money = "2";
        System.out.println(money);
    }
    @Deprecated
    public void goShopping(View view) {

    }

    public void eatDinner(View view) {

    }
}