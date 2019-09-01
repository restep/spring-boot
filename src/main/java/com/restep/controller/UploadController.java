package com.restep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author restep
 * @date 2019/9/1
 */
@Controller
public class UploadController {
    private static String UPLOADED_FOLDER = "D://temp//";

    @GetMapping("/toUpload")
    public String toUpload() {
        return "upload";
    }

    @GetMapping("/toUploadMore")
    public String toUploadMore() {
        return "uploadMore";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "请选择文件");
            return UrlBasedViewResolver.REDIRECT_URL_PREFIX + "/uploadStatus";
        }

        try {
            byte[] byteArr = new byte[0];
            byteArr = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, byteArr);

            redirectAttributes.addFlashAttribute("message", "成功上传" + file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return UrlBasedViewResolver.REDIRECT_URL_PREFIX + "/uploadStatus";
    }

    @PostMapping("/uploadMore")
    public String uploadMore(@RequestParam("file") MultipartFile[] files, RedirectAttributes redirectAttributes) {
        if (files.length == 0) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        for (MultipartFile file : files) {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded all");
        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
}
