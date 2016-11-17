package com.app.cczhr.easyweather;




import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import static com.app.cczhr.easyweather.MainActivity.city;

/**
 * Created by cczhr on 2016/10/7.
 */

public class JsonUtils extends MainActivity {
    private  String praseJson;
    private String basic;
    private String now;
    private String hourly_forecast;
    private String okk;
    private String daily_forecast;
    private SharedPreferences pref;


    /*public void onCreate(Bundle savedInstanceState) {
        save(bean.getHeWeatherdataservice().get(0).getBasic().getCity());
    }*/

    public String praseJson (String  jsonData,Context context) {
        JavaBean bean =GsonImpl.get().toObject(jsonData,JavaBean.class);


         if(bean.getHeWeatherdataservice().get(0).getStatus().equals("ok")) {

             save(bean.getHeWeatherdataservice().get(0).getBasic().getCity(),context);
             Toast.makeText(context, "已更新", Toast.LENGTH_SHORT).show();
             basic = "你输入的城市：" + bean.getHeWeatherdataservice().get(0).getBasic().getCity() + "\n" + "天气更新时间：" +
                     bean.getHeWeatherdataservice().get(0).getBasic().getUpdate().getLoc() + "\n";

             if (bean.getHeWeatherdataservice().get(0).getAqi() != null) {
                 now = "实时天气为：" + bean.getHeWeatherdataservice().get(0).getNow().getCond().getTxt() + "\n" + "温度：" + bean.getHeWeatherdataservice().get(0).getNow().getTmp()
                         + "℃" + "\t" + "   体感温度：" + bean.getHeWeatherdataservice().get(0).getNow().getFl() + "℃" + "\n" + "降水量：" + bean.getHeWeatherdataservice().get(0).getNow().getPcpn()
                         + "mm" + "  相对湿度：" + bean.getHeWeatherdataservice().get(0).getNow().getHum() + "%\n" + "能见度：" + bean.getHeWeatherdataservice().get(0).getNow().getVis()
                         + "km" + "\n" + "空气质量：" + bean.getHeWeatherdataservice().get(0).getAqi().getCity().getQlty() + "\t" + "\t" + "\t" +
                         "  紫外线强度：" + bean.getHeWeatherdataservice().get(0).getSuggestion().getUv().getBrf() + "\n";
             } else {
                 now = "实时天气为：" + bean.getHeWeatherdataservice().get(0).getNow().getCond().getTxt() + "\n" + "温度：" + bean.getHeWeatherdataservice().get(0).getNow().getTmp() + "℃" + "\t" + "   体感温度："
                         + bean.getHeWeatherdataservice().get(0).getNow().getFl() + "℃" + "\n" + "降水量：" + bean.getHeWeatherdataservice().get(0).getNow().getPcpn() + "mm" + "  相对湿度：" + bean.getHeWeatherdataservice().get(0).getNow().getHum() + "%" + "  能见度：" + bean.getHeWeatherdataservice().get(0).getNow().getVis()
                         + "km" + "\n";
             }
             try {
                 hourly_forecast = "三小时内降雨概率为：" + bean.getHeWeatherdataservice().get(0).getHourly_forecast().get(0).getPop() + "%" + "\n" + "预测时间至：" + bean.getHeWeatherdataservice().get(0).getHourly_forecast().get(0).getDate() + "\n";
             } catch (Exception e) {
                 hourly_forecast = "三小时内降雨概率为：暂时无法获取" + "\n" + "预测时间至：暂时无法获取" + "\n";
             }
             daily_forecast = "\n" + "\n" + "三天天气预报:" + "\n" + "日期： " + bean.getHeWeatherdataservice().get(0).getDaily_forecast().get(0).getDate() + "\n" + "最高温度：" + bean.getHeWeatherdataservice().get(0).getDaily_forecast().get(0).getTmp().getMax() + "℃" + "\t" + " 最低温度："
                     + bean.getHeWeatherdataservice().get(0).getDaily_forecast().get(0).getTmp().getMin() + "℃" + "\n" + "降雨概率为:" + bean.getHeWeatherdataservice().get(0).getDaily_forecast().get(0).getPop() + "%"
                     + "\n" + "\n" + "日期： " + bean.getHeWeatherdataservice().get(0).getDaily_forecast().get(1).getDate() + "\n" + "最高温度：" + bean.getHeWeatherdataservice().get(0).getDaily_forecast().get(1).getTmp().getMax() + "℃" + "\t" + " 最低温度："
                     + bean.getHeWeatherdataservice().get(0).getDaily_forecast().get(1).getTmp().getMin() + "℃" + "\n" + "降雨概率为:" + bean.getHeWeatherdataservice().get(0).getDaily_forecast().get(1).getPop() + "%" +
                     "\n" + "\n" + "日期： " + bean.getHeWeatherdataservice().get(0).getDaily_forecast().get(2).getDate() + "\n" + "最高温度：" + bean.getHeWeatherdataservice().get(0).getDaily_forecast().get(2).getTmp().getMax() + "℃" + "\t" + " 最低温度："
                     + bean.getHeWeatherdataservice().get(0).getDaily_forecast().get(2).getTmp().getMin() + "℃" + "\n" + "降雨概率为:" + bean.getHeWeatherdataservice().get(0).getDaily_forecast().get(2).getPop() + "%";
             praseJson = basic + now + hourly_forecast + daily_forecast;

             return praseJson;

         }

        else{
             Toast.makeText(context, "你输入的城市错误，请检查一下。", Toast.LENGTH_SHORT).show();
             praseJson="";
             return praseJson;
         }

   }

}




