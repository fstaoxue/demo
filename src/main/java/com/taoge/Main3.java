package com.taoge;

import com.alibaba.fastjson.JSON;
import com.taoge.loc.BaseParam;
import com.taoge.tree.Text;

import java.util.ArrayList;
import java.util.List;

public class Main3 {

//    public static void main(String[] args) {
//        Text text=new Text("11","22","33");
//        String result=JSON.toJSONString(text);
//        System.out.println(result);
//        Text text1=JSON.parseObject(result,Text.class);
//        System.out.println(text1);
//    }


    public static void main(String[] args) {
        List<BaseParam> list=new ArrayList<>();
        BaseParam param=new BaseParam();
        param.setAcc("13900000000");
        param.setAccType("phone");
        param.setType("01");
        param.setStartTime(System.currentTimeMillis()/1000L-10*3600);
        param.setEndTime(System.currentTimeMillis()/1000L);
        list.add(param);
        System.out.println(JSON.toJSONString(list));
    }
}
