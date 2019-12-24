package com.ljb.test.controller;

import com.ljb.test.model.BaseResponce;
import com.ljb.test.model.UploadPictureResponce;
import com.ljb.test.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class FileController {
    private String TAG = FileController.class.getName();

    @Value("${server.servlet.context-path}")
    private String projectPath;

    @Value("${file.root-path}")
    private String rootPath;

    @Value("${file.picture-path}")
    private String picturePath;

    @Value("${file.picture-uri}")
    private String pictureUri;

    @PostMapping("/picture")
    public BaseResponce uploadPicture(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        if (null == file) throw new NullPointerException("the file cannot be null");
        String filename = file.getOriginalFilename();
        CommonUtils.logI(TAG, "filename=" + filename);

        String suffix = filename.substring(filename.lastIndexOf("."));
        CommonUtils.logI(TAG, "suffix=" + suffix);

        File root = new File(rootPath + picturePath);
        CommonUtils.logI(TAG, "root_path=" + root);

        String newName = UUID.randomUUID().toString() + suffix;
        CommonUtils.logI(TAG, "newName=" + newName);

        if (!root.exists()) root.mkdirs();

        File newPicture = new File(root, newName);
        try {
            file.transferTo(newPicture);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        String picturePath = CommonUtils.getServerIp(request) + projectPath + pictureUri + newName;
        CommonUtils.logI(TAG, "图片的访问地址 : " + picturePath);
        return new BaseResponce(true,new UploadPictureResponce(filename,picturePath));
    }
}
