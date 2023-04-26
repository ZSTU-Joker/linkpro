package com.xlccc.cv;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Linker
 * @Date: 2023/4/26 8:59
 * @Description:
 */
public class SimplePhotos {
    public static void main(String[] args) throws FrameGrabber.Exception, InterruptedException {
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);//新建opencv抓取器，一般的电脑和移动端设备中摄像头默认序号是0，不排除其他情况
        grabber.start();//开始获取摄像头数据

        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();

        //窗口是否关闭
        while (true) {
            /*获取摄像头图像并在窗口中显示,这里Frame frame=grabber.grab()得到是解码后的视频图像*/
            opencv_core.Mat mat = converter.convertToMat(grabber.grabFrame());
            //保存第一帧到本地
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
            Date d = new Date();
            String date = sdf.format(d);
            String substring = date.substring(date.length() - 2);
            if (Integer.valueOf(substring) % 2 == 0) {
                opencv_imgcodecs.imwrite("D:\\joker\\pic-upload\\" + date + ".jpg", mat);
            }
        }
    }
}
