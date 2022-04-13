package com.example.educational_courses_catalog.service;

import com.example.educational_courses_catalog.common.Result;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadService {
    @Value("${file.staticAccessPath}")
    private String staticAccessPath;

    @Value("${file.uploadFolder}")
    private String uploadFolder;

    public Result upload(MultipartFile file){
        if (file.isEmpty()) {
            throw new NullPointerException("文件为空");
        }

        uploadFolder = System.getProperty("user.dir") + "/src/main/resources/" +uploadFolder;

        //使用FilenameUtils获得文件的后缀(先导依赖Commons-fileUpload)
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        //生成新的文件名(队伍名+随机数+后缀名)
        String newFileName = System.currentTimeMillis() + "." + extension;

        File dateDir = new File(uploadFolder);
        if (!dateDir.exists()) {
            //判断目录是否存在，不存在则直接创建
            dateDir.mkdirs();
        }
        try {
            file.transferTo(new File(uploadFolder, newFileName));
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error("upload failed");
        }
        //上传完毕，存入数据库中的地址为：
        String inventedAddress = staticAccessPath + newFileName;
        return Result.success("upload successfully, invented address is:", inventedAddress);
    }

}
