package com.example.spingboot.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/26 8:04
 */

@Component
@Data
@ConfigurationProperties(prefix = "file")
public class FileUtil {

        private String path;
        private String fileName;

        private String absolutePath;

        public String getType(String fileName){
                int begin = fileName.lastIndexOf('.');
                return fileName.substring(begin);
        }

        public String getFileName(String type){
                return System.currentTimeMillis() + type;
        }

        public File saveFile(String fileName){
                String type = getType(fileName);
                String newFileName = getFileName(type);
                File file = new File(path,newFileName);
                this.fileName = newFileName;
                this.absolutePath  = path + File.separator + newFileName;
                return file;
        }


}
