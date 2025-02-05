package online.githuboy.lagou.course;

import lombok.extern.slf4j.Slf4j;
import online.githuboy.lagou.course.support.Course;
import online.githuboy.lagou.course.support.Downloader;
import online.githuboy.lagou.course.support.ExecutorService;
import online.githuboy.lagou.course.domain.DownloadType;

import java.io.IOException;
import java.util.List;

/**
 * 启动类
 * 批量下载，下载账号下所有视频
 *
 * @author eric
 * @date 2021/05/09
 */
@Slf4j
public class App2 {
    public static void main(String[] args) throws IOException, InterruptedException {

        List<String> allCoursePurchasedRecordForPC = Course.getAllCoursePurchasedRecordForPC();

//        allCoursePurchasedRecordForPC.remove("1");
//        allCoursePurchasedRecordForPC.remove("287");
//        allCoursePurchasedRecordForPC.remove("490");
//        allCoursePurchasedRecordForPC.remove("615");
//        allCoursePurchasedRecordForPC.remove("640");
//        allCoursePurchasedRecordForPC.remove("668");
//        allCoursePurchasedRecordForPC.remove("685");
        allCoursePurchasedRecordForPC.remove("716"); // 716_Python入门与实战-至尊 这个视频有毒
//        allCoursePurchasedRecordForPC.remove("729");
//        allCoursePurchasedRecordForPC.remove("753");
//        allCoursePurchasedRecordForPC.remove("822");
//        allCoursePurchasedRecordForPC.remove("837");
//        allCoursePurchasedRecordForPC.remove("869"); // 这个视频有毒

        //视频保存的目录
        String savePath = "/media/iris/File-Old/lagou";

        // 开始下载所有课程
        int i = 1;
        for (String courseId : allCoursePurchasedRecordForPC) {
            Downloader downloader = new Downloader(courseId, savePath, DownloadType.ALL);
            downloader.start();
            log.info("\n\n\n");
            log.info("开始下载{}课程", i++);
//            Thread.sleep(5000);
        }
        log.info("\n====>程序运行完成");
        ExecutorService.tryTerminal();

    }
}
