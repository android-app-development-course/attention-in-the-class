package com.example.ending.uisimple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class RegisterActivity extends AppCompatActivity {

    private EditText registerpassword;
    private EditText registerpasswordconfirm;
    private EditText email;
    private EditText phonenum;
    private EditText name;
    private EditText number;
    private int flagrp=1;
    private int flagrpc=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.RegisterBack:
            {
                Intent intent = new Intent();
                intent.setClass(RegisterActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);//设置不要刷新将要跳到的界面
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//它可以关掉所要到的界面中间的activity
                startActivity(intent);
                break;
            }
            case R.id.RegisterConfirm:
            {
                registerpassword=(EditText)findViewById(R.id.RegisterPasswordEdit) ;
                email=(EditText)findViewById(R.id.RegisterUsernameEdit) ;
                phonenum=(EditText)findViewById(R.id.RegisterEMEdit);
                name=(EditText)findViewById(R.id.RegisterPNEdit) ;
                number=(EditText)findViewById(R.id.RegisterNumberEdit) ;

                //
                //
                //这里把上面这五个参数全部发到服务器
                //
                //


                Intent intent=new Intent(RegisterActivity.this,AfterRegisterActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.RegisterPasswordConfirmVisual:
            {
                Button temp1=(Button)findViewById(R.id.RegisterPasswordConfirmVisual) ;
                registerpasswordconfirm=(EditText)findViewById(R.id.RegisterPasswordConfirmEdit);
                if(flagrpc==1) {
                    registerpasswordconfirm.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    temp1.setBackgroundResource(R.mipmap.ic_eye8);
                    flagrpc--;
                }
                else{
                    registerpasswordconfirm.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT );
                    temp1.setBackgroundResource(R.mipmap.ic_eye5);
                    flagrpc++;
                }
                break;
            }
            case R.id.RegisterPasswordVisual:
            {
                Button temp2=(Button)findViewById(R.id.RegisterPasswordVisual) ;
                registerpassword=(EditText)findViewById(R.id.RegisterPasswordEdit);
                if(flagrp==1) {
                    registerpassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    temp2.setBackgroundResource(R.mipmap.ic_eye8);
                    flagrp--;
                }
                else{
                    registerpassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT );
                    temp2.setBackgroundResource(R.mipmap.ic_eye5);
                    flagrp++;
                }
                break;
            }
        }
    }
}
