package com.taoge;

import com.alibaba.fastjson.JSON;
import com.taoge.spring.bean.Animal;
import com.taoge.spring.bean.Dag;
import com.taoge.spring.bean.InterestParam;
import sun.misc.ClassLoaderUtil;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author taoxuefeng
 * @date 2019/05/22
 */
public class Main {

//    public static void main(String[] args) throws FileNotFoundException {
//        File file=new File("D:\\phone.xls");
//        ParseSheet parseSheet=new ParseSheet();
//        String fileName=file.getName();
//        InputStream stream=new FileInputStream(file);
//        List2<LocInfo> infos=parseSheet.getListByStream(stream,fileName,LocInfo.class);
//        for(int i=0;i<infos.size();i++){
//            System.out.println(infos.get(i).toString());
//        }
//    }


    //public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        String[] names=applicationContext.getBeanDefinitionNames();
//        for(String name:names){
//            System.out.println(name);
//        }

//        for(int i=0;i<10;i++){
//            final int key=i;
//            new Thread(()->{
//                System.out.println(key+"hello");
//            }).start();
//        }
//        InterestParam param=new InterestParam();
//        param.setPhone("13900000000");
//        param.setStartDate("2019-09-01");
//        param.setEndDate("2019-10-01");
//        param.setDayType("all");
//        InterestParam param1=new InterestParam();
//        param1.setStartDate("13900000001");
//        param1.setStartDate("2019-08-01");
//        param1.setEndDate("2019-09-01");
//        param1.setEndDate("all");
//        List2<InterestParam> params=Arrays.asList(param,param1);
//        System.out.println(JSON.toJSONString(params));
//        try {
//            Thread.sleep(Integer.MAX_VALUE);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //http://localhost:17010/address/getMultiAccAddress?phones=13900000000_13900000001_13900000002
        //http://localhost:17080/interestPoint/getMultiAccInterestPointWithEqualParam?phones=13900000000_13900000001&startDate=2019-09-01&endDate=2019-10-01
        //http://localhost:17080/interestPoint/getMultiAccInterestPoint?paramJson=[{"dayType":"all","endDate":"2019-10-01","phone":"13900000000","startDate":"2019-09-01"},{"endDate":"all","startDate":"2019-08-01"}]
        //http://localhost:17080/interestPoint/getMultiAccInterestPoint?paramJson=[{"dayType":"all","endDate":"2019-10-01","phone":"13900000000","startDate":"2019-09-01"},{"endDate":"all","startDate":"2019-08-01"}]
        //http://localhost:17080/realTimeLocation/getMultiAccLocations?paramJson=[{"acc":"13900000000","accType":"phone","type":"01"},{"acc":"渝K10000","accType":"plate","type":"02"},{"acc":"522227198601016440","accType":"idCard","type":"01"}]


//        Pattern p = Pattern.compile("cat");
//        Matcher m = p.matcher("one cat two cats in the yard");
//        StringBuffer sb = new StringBuffer();
//        int i=0;
//        while (m.find()) {
//            if(i>0){
//                m.appendReplacement(sb, "dog");
//            }else{
//                m.appendReplacement(sb, "monkey");
//            }
//            i++;
//            System.out.println(sb.toString());
//        }
//        System.out.println("end");
//        m.appendTail(sb);
//        System.out.println("tail  end");
//        System.out.println(sb.toString());
//
//        Dag dag=new Dag();
//        Animal animal=new Animal();
//        System.out.println(Animal.class.isInstance(dag));
//        System.out.println(Dag.class.isInstance(dag));
//        String a=new String("a");
//        String b=new String("a");
//        System.out.println(a==b);
//        System.out.println(a.equals(b));

    //}

//    public static void main(String[] args) {
//        int n=-2;
//    }

//    public static void main(String[] args){
//         Enumeration<URL> resources = null;
//        try {
//            resources = Main.class.getClassLoader().getResources("");
//        } catch (IOException e) {
//        }
//        while(resources.hasMoreElements()){
//            URL temp=resources.nextElement();
//            System.out.println(temp);
//            System.out.println(temp.getFile());
//            if(temp.getProtocol().equalsIgnoreCase("file")){
//                File file= new File(temp.getFile());
//                showAllFile(file);
//            }
//        }
//    }
//
//    public static void showAllFile(File file){
//        if(file.isDirectory()){
//            for(File temp:file.listFiles()){
//                showAllFile(temp);
//            }
//        }else{
//            System.out.println(file.getName());
//        }
//    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
