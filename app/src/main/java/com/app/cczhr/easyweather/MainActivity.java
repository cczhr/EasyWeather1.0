package com.app.cczhr.easyweather;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.network.Parameters;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import edittextfirework.FireworkView;

/*
 * 测试前请在MyApplication.java中配置您的appkey
 */
public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mTextView;
    private EditText mEditText;
    private String name;
    private String error;
    private static String city;
    private FireworkView mFireworkView;
    public static final String editTextString = "MainActivity_editTextString";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences= getSharedPreferences("test",
                Activity.MODE_PRIVATE);

        mEditText = (EditText) findViewById(R.id.editText);

        String name =sharedPreferences.getString("name", "");
        mEditText.setText(name);
        mFireworkView = (FireworkView) findViewById(R.id.fire_work);
        mFireworkView.bindEditText(mEditText);
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences mySharedPreferences= getSharedPreferences("test",
                        Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = mySharedPreferences.edit();
                city = mEditText.getText().toString();
                editor.putString("name", city);
                editor.commit();

                try {
                    city = URLEncoder.encode(city, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

               if(city.equals("")){
                   Toast.makeText(getApplicationContext(), "你什么都没输入O_O",
                           Toast.LENGTH_SHORT).show();
               }
                else
                  apiTest(city);
            }
        });



    }

    private void apiTest(String city) {
        mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
        Parameters para = new Parameters();
        para.put("city", city);
        ApiStoreSDK.execute("http://apis.baidu.com/heweather/weather/free",
                ApiStoreSDK.GET,
                para,
                new ApiCallBack() {

                    @Override
                    public void onSuccess(int status, String responseString) {
                        Log.i("sdkdemo", "onSuccess");
                        responseString=responseString.replace("r d", "rd");
                        responseString=responseString.replace("a s", "as");
                        responseString=responseString.replace("e ", "e");
                        responseString=responseString.replace("3.0", "");
                        System.out.println(responseString);
                        JsonUtils js=new JsonUtils();
                        js.praseJson(responseString);

                        mTextView.setText(js.praseJson(responseString));

                    }

                    @Override
                    public void onComplete() {
                        Log.i("sdkdemo", "onComplete");
                    }

                    @Override
                    public void onError(int status, String responseString, Exception e) {
                        Log.i("sdkdemo", "onError, status: " + status);
                        Log.i("sdkdemo", "errMsg: " + (e == null ? "" : e.getMessage()));
                        mTextView.setText(getStackTrace(e));
                        mTextView.setText(getStackTrace(e));
                    }

                });

    }

    String getStackTrace(Throwable e) {
        if (e == null) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        str.append(e.getMessage()).append("\n");

        for (int i = 0; i < e.getStackTrace().length; i++) {
            str.append(e.getStackTrace()[i]).append("\n");
        }
        error="你的网络有可能有点问题哟~请检查一下";

        return error;
    }

}
