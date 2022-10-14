package kr.eddi.demo.controller.vue.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/56th/file")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class FileUploadController {

    @ResponseBody
    @PostMapping("/uploadImgs")
    public String requestUploadFile (
            @RequestParam("fileList") List<MultipartFile> fileList) {

        log.info("requestUploadFile(): " + fileList);

        try {
            for (MultipartFile multipartFile: fileList) {
                log.info("requestUploadFile() - Make file: " +
                        multipartFile.getOriginalFilename());

                FileOutputStream writer = new FileOutputStream(
                    "../../vue/frontend/src/assets/uploadImgs/" + multipartFile.getOriginalFilename()
                );

                log.info("디렉토리에 파일 배치 성공!");

                writer.write(multipartFile.getBytes());

                writer.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        log.info("requestUploadFile(): Success!");

        return "Upload Success!!!";
    }
}
