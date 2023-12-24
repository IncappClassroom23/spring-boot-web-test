package com.example.springbootwebtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    @GetMapping("/uploadFile")
    public String uploadFile(RedirectAttributes redirectAttributes){
//        redirectAttributes.addFlashAttribute("message","Please upload file.");
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        File f = new File("D:\\temp\\sample.txt");
        file.transferTo(f);
        redirectAttributes.addFlashAttribute("message1", "File uploaded successfully: " + file.getOriginalFilename());
        return "redirect:/uploadFile";
    }
}
