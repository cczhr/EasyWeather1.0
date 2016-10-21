package com.app.cczhr.easyweather;

import android.widget.TextView;

/**
 * Created by cczhr on 2016/10/7.
 */

public class JsonUtils {
    private  String praseJson;
    private String basic;
    private String now;
    private String hourly_forecast;
    private String suggestion;
    private String daily_forecast;
    public String praseJson(String jsonData) {

             JavaBean bean =GsonImpl.get().toObject(jsonData,JavaBean.class);
         if(bean.getHeWeatherdataservice().get(0).getStatus().equals("ok")) {
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
             praseJson = basic + now + hourly_forecast+ daily_forecast;
             return praseJson;
         }
        else{
             praseJson="你输入的城市错误，请检查一下哦~";
             return praseJson;
         }


           // JavaBean.HeWeatherdataserviceBean.AqiBean.CityBean b22=new JavaBean.HeWeatherdataserviceBean.AqiBean.CityBean();


            //reader.beginObject();
           /* System.out.println(reader.nextName());
            reader.beginArray();
            reader.beginObject();
            System.out.println(reader.nextName());
            reader.beginObject();
            System.out.println(reader.nextName());
            reader.beginObject();
            while (reader.hasNext()) {
            System.out.println(reader.nextName());
            System.out.println(reader.nextString());}*/









           // System.out.println("8999999");
         //  while (reader.hasNext()) {
               // reader.beginObject();
              //String id = reader.nextString();
              // System.out.println("88888888888888888");
               //System.out.println(id);
                //while (reader.hasNext()) {

                    //String name1 = reader.nextName();
                   // System.out.println(name1);
                    // System.out.println("88888888888888888");
                    // reader.beginObject();
               // System.out.println(id);
               // System.out.println("8999999");
                //}
               // String name2 = reader.nextName();
                //System.out.println(name2);
                //reader.beginObject();


                //while (reader.hasNext()) {
                  //  System.out.println("99999999999999999999");
                  //  String name = reader.nextName();
                  //  System.out.println(name);
                   // reader.beginObject();
                   // if (name.equals("retData")) {

                      // System.out.println("00000000000");

                   // }
              //  }

            //}
            //reader.endObject();
            ///}

            // else if(tagName.equals("userId")){
            //   System.out.println(reader.nextString());
           // }







   }
}




