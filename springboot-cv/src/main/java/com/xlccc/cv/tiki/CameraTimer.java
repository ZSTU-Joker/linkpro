//package com.xlccc.cv.tiki;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.concurrent.atomic.AtomicLong;
//import org.bytedeco.javacv.FrameGrabber.Exception;
//import org.bytedeco.javacv.OpenCVFrameConverter;
//import org.bytedeco.javacv.OpenCVFrameGrabber;
//import org.bytedeco.opencv.global.opencv_imgcodecs;
//import org.bytedeco.opencv.opencv_core.Mat;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//
///**
// * @version 0.0.1
// * @since 2018/12/18
// * @author wxj233
// * 开启摄像头抓拍
// */
//@Component
//public class CameraTimer {
//    //原子类产生不重复数据
//    AtomicLong generator = new AtomicLong();
//
//    public static OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
//
//    @Scheduled(cron = "0/5 * * * * ?")
//    public void getPhoto() {
//        System.out.println("抓拍！");
//        OpenCVFrameGrabber grabber = Camera.grabber;
//        try {
//            if(Camera.InitCamera) {
//                Mat mat = converter.convertToMat(grabber.grabFrame());
//
//                if(Camera.saveImage == Camera.Img.save) {
//                    //SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");javaCV不支持中文路径
//                    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
//                    Date date = new Date();
//                    String imgname = format.format(date) + "Num" + String.valueOf(generator.incrementAndGet());
//                    opencv_imgcodecs.imwrite("C:\\Users\\Lenovo\\Desktop\\中文测试软件\\"+ imgname +".jpg", mat);
//                }
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//}