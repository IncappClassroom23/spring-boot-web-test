package com.example.springbootwebtest.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Controller
public class FileDownloadController {
    @GetMapping("downloadFile")
    public String downloadFile(){
        return "download.html";
    }

    @GetMapping("download/{fileName}")
    public ResponseEntity<InputStreamResource> download(@PathVariable String fileName) throws FileNotFoundException {
        File file = new File("D:\\temp\\sample.txt");
        HttpHeaders headers = new HttpHeaders();

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName);
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);

    }
}
