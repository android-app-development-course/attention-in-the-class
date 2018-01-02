package com.example.ending.uisimple;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button loginButton;
    private int flag=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void onClick(View view)
    {
        Locale locale = getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        switch (view.getId())
        {
            case R.id.button:
            {
                username=(EditText) findViewById(R.id.usernameEdit);
                password=(EditText) findViewById(R.id.passwordEdit);
                //
                //
                //这里把username和password发到服务器检验对错,返回一个boolean参数用来代替下面if的判断
                //还要返回学生姓名和学号
                //
                if(username.getText().toString().equals("admin")&&password.getText().toString().equals("admin"))
                {
                    if(language.equals("zh"))
                    {
                        Toast.makeText(this,"登陆成功",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(this, "Login Successfully", Toast.LENGTH_LONG).show();
                    }
                    Intent intent = new Intent();
                    intent.putExtra("extra_data","num_name");
                    setResult(1,intent);
                    this.finish();
                    break;
                }
                else
                {
                    flag--;
                    if(flag==0)
                    {
                        if(language.equals("zh"))
                        {
                            Toast.makeText(this,"错误三次，假装你已被ban",Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(this, "three times wrong,you have been banned", Toast.LENGTH_LONG).show();
                        }
                        loginButton=(Button) findViewById(R.id.button);
                        loginButton.setEnabled(false);
                        loginButton.setBackgroundColor(Color.parseColor("#9E9E9E"));
                        loginButton.setBackgroundResource(R.drawable.false_button_selector);
                        break;
                    }
                    else
                    {
                        if(language.equals("zh"))
                        {
                            Toast.makeText(this,"账号或密码错误，可再尝试"+flag+"次。",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(this, "username or password is wrong.You can try "+(flag)+" more times", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }
                }
            }
            case R.id.LoginBack:
            {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);//设置不要刷新将要跳到的界面
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//它可以关掉所要到的界面中间的activity
                startActivity(intent);
                break;
            }
        }


    }
}
