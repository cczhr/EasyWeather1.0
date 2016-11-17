package com.app.cczhr.easyweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by cczhr on 2016/10/26.
 */

public class StartAty extends Activity {
    protected  void  onCreate(Bundle savedInstanc){
        super.onCreate(savedInstanc);
        startActivity(new Intent(this,MainActivity.class));
    }
}
