package com.taoge.file;

import com.taoge.bean.A;
import com.taoge.bean.B;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Main {


//    public static void main(String[] args) throws IOException {
//        long start=System.currentTimeMillis();
//        File file=new File("D:\\repository.zip");
//        File file2=new File("D:\\repository1sss121.zip");
//        FileChannel channel=new FileInputStream(file).getChannel();
//        FileChannel fileChannel=new FileOutputStream(file2).getChannel();
//        ByteBuffer buffer=ByteBuffer.allocate(1024*1024);
//        while(channel.read(buffer)!=-1){
//            channel.read(buffer);
//            buffer.flip();
//            fileChannel.write(buffer);
//            buffer.clear();
//        }
//        channel.close();
//        fileChannel.close();
//        long end=System.currentTimeMillis();
//        System.out.println(end-start);
//    }


//    public static void main(String[] args) throws IOException {
//        long start=System.currentTimeMillis();
//        File file=new File("D:\\repository.zip");
//        File file2=new File("D:\\repository2oo.zip");
//        FileInputStream inputStream=new FileInputStream(file);
//        FileOutputStream outputstream=new FileOutputStream(file2);
//        BufferedInputStream inputStream1=new BufferedInputStream(inputStream);
//        BufferedOutputStream outputStream=new BufferedOutputStream(outputstream);
//        byte[] buffer=new byte[1024*1024*10];
//        while(inputStream.read(buffer)!=-1){
//            outputStream.write(buffer);
//        }
//        long end=System.currentTimeMillis();
//        System.out.println(end-start);
//    }

//    public static void main(String[] args) throws IOException {
//        long start=System.currentTimeMillis();
//        File file=new File("D:\\repository.zip");
//        File file2=new File("D:\\reposssssssitoaaary1sss121.zip");
//        FileChannel channel=new FileInputStream(file).getChannel();
//        FileChannel fileChannel=new FileOutputStream(file2).getChannel();
//        ByteBuffer buffer=ByteBuffer.allocate(1024*1024);
//        channel.transferTo(0,channel.size(),fileChannel);
//        channel.close();
//        fileChannel.close();
//        long end=System.currentTimeMillis();
//        System.out.println(end-start);
//    }


//    public static void main(String[] args) {
//        IntBuffer byteBuffer=ByteBuffer.allocate(1024).asIntBuffer();
//        for(int i=0;i<12;i++){
//            byteBuffer.put(i);
//        }
//        byteBuffer.flip();
//        while(byteBuffer.hasRemaining()){
//            byteBuffer.mark();
//            int a=byteBuffer.get();
//            int b=byteBuffer.get();
//            byteBuffer.reset();
//            byteBuffer.put(b).put(a);
//        }
//        byteBuffer.flip();
//        while(byteBuffer.hasRemaining()){
//            System.out.println(byteBuffer.get());
//        }
//    }

    public static void main(String[] args) {
        AtomicStampedReference<Integer> reference=new AtomicStampedReference<>(5,1);
    }

}
