package com.example.educational_courses_catalog.service;

import com.example.educational_courses_catalog.common.Result;
import com.example.educational_courses_catalog.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Service
public class DownloadService {

    @Autowired
    private CourseService courseService;

    @Value("${file.uploadFolder}")
    private String uploadFolder;

    public void download(Long id, HttpServletResponse response) throws UnsupportedEncodingException {
        uploadFolder = System.getProperty("user.dir") + "/src/main/resources/" +uploadFolder;

        Result result = courseService.findById(id);
        Course data = (Course) result.getData();
        String inventedAddress = data.getSyllabus();

        String fileName = new File(inventedAddress).getName();
        File file = new File(uploadFolder, fileName);

        // 如果文件存在，则进行下载
        if (file.exists()) {

            // 配置文件下载
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

            // 实现文件下载
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            }
            catch (Exception ignored) {}
            finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
