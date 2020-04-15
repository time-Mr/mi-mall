package com.time.demo.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * 文件上传
 *
 * @author time
 */
@Component
public class UploadUtil {

    private final String path = System.getProperty("user.dir")+"/src/main/resources/static/picture/";

    /**
     * 文件上传
     *
     * @param file 需要上传得文件对象
     * @return 上传后的路劲
     */
    public String upload(MultipartFile file) {
        if (VerdictUtil.isNotNull(file)) {
            String fileName = UUID.randomUUID() + file.getOriginalFilename();
            String realPath = this.path + fileName;
            File dest = new File(realPath);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdir();
            }
            try {
                file.transferTo(dest);
                return fileName;
            } catch (Exception e) {
                e.printStackTrace();
                return "上传失败";
            }
        }
        return "上传失败";
    }

    public boolean deleteFile(String fileName) {
        File file = new File(this.path + fileName);
        if (file.exists()) {
            file.delete();
            return true;
        } else {
            return false;
        }
    }

}
