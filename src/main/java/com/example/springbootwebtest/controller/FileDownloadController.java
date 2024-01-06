package com.example.springbootwebtest.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileDownloadController {
    @GetMapping("downloadFile")
    public String downloadFile(){
        return "download.html";
    }

    @GetMapping("download/{fileName}")
    public ResponseEntity<byte[]> download(@PathVariable String fileName) throws IOException {
        File file = new File("D:\\temp\\"+fileName);
        HttpHeaders headers = new HttpHeaders();
        Path path = Paths.get("D:\\temp\\"+fileName);
        byte[] data = Files.readAllBytes(path);
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName);
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(data);

    }
}
