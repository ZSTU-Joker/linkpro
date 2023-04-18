//package com.xlccc.cv.tiki;
//
//
//import javax.annotation.PostConstruct;
//
//
//import org.bytedeco.javacv.FrameGrabber.Exception;
//import org.bytedeco.javacv.OpenCVFrameGrabber;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//
///**
// * @version 0.0.1
// * @since 2018/12/18
// * @author wxj233
// *
// */
//@Component
//class CameraTimerInit {
//
//    /**
//     * 初始化摄像头
//     */
//    @PostConstruct
//    void CameraInit(){
//        Camera.grabber = new OpenCVFrameGrabber(0);
//        try {
//            Camera.StartCamera();
//            Camera.InitCamera = true; //摄像头正常启动
//            System.out.println("初始化摄像头！");
////            syLogService.info(CameraTimerInit.class, "初始化摄像头！");
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            Camera.InitCamera = false;  //摄像头启动失败
//            System.out.println("请检查摄像头是否正常或驱动是否更新！");
////            syLogService.info(CameraTimerInit.class, "请检查摄像头是否正常或驱动是否更新！");
//            //e.printStackTrace();
//        }
//
//    }
//
//}