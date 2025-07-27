package com.bootrestuser.bootrestuser.Helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadHelper {
    
    public final String UPLOAD_DIR = new File("src/main/resources/static/image").getAbsolutePath();
   
    public boolean uploadFile(MultipartFile file) {
        try{
            Files.createDirectories(Paths.get(UPLOAD_DIR));

            Files.write(
               Paths.get(UPLOAD_DIR, file.getOriginalFilename()),
                       file.getBytes()
            );
            return true;
         } catch (Exception e) {
             e.printStackTrace();
             return false;
        }
    }
}
