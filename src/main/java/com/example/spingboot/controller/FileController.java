package com.example.spingboot.controller;

import com.example.spingboot.domain.vo.ResultVo;
import com.example.spingboot.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/27 10:04
 */
@RestController
@RequestMapping("/file")
public class FileController {

        @Autowired
        private FileUtil fileUtil;

        @PostMapping("/upload")
        public ResultVo upload(MultipartFile file) throws IOException {
                String fileName = file.getOriginalFilename();
                file.transferTo(fileUtil.saveFile(fileName));
                return new ResultVo(fileUtil.getAbsolutePath());
        }

        @GetMapping("download/{fileName}")
        public void downLoad(@PathVariable String fileName, HttpServletResponse response) throws IOException {
                response.setHeader("content-disposition", "attachment;fileName = " + URLEncoder.encode(fileName, "UTF-8"));
                String fileFullName = fileUtil.getPath() + File.separator + fileName;
                FileInputStream fileInputStream = new FileInputStream(fileFullName);
                ServletOutputStream outputStream = response.getOutputStream();
                FileCopyUtils.copy(fileInputStream,outputStream);
        }

}
