package com.example.springbootwebtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class FileUploadController {

    @GetMapping("/uploadFile")
    public String uploadFile(RedirectAttributes redirectAttributes){
//        redirectAttributes.addFlashAttribute("message","Please upload file.");
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        String filePath = "D:\\temp\\sample.txt";
        // way 1
        File f = new File(filePath);
        file.transferTo(f);
//        // way 2
//        Files.write(Path.of(filePath),file.getBytes());
//
//        // way 3
//        try(FileOutputStream stream = new FileOutputStream(filePath)){
//            stream.write(file.getBytes());
//        }
        redirectAttributes.addFlashAttribute("message1", "File uploaded successfully: " + file.getOriginalFilename());
        return "redirect:/uploadFile";
    }
}
