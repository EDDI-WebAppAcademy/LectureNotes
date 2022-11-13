package kr.eddi.demo.controller.flutter.image;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/flutter-image")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ImageController {

    @PostMapping(value = "/upload",
                consumes = {
                    MediaType.IMAGE_JPEG_VALUE,
                    MediaType.IMAGE_GIF_VALUE,
                    MediaType.IMAGE_PNG_VALUE,
                    MediaType.MULTIPART_FORM_DATA_VALUE,
                    MediaType.APPLICATION_JSON_VALUE })
    public Boolean imageProcedure(@RequestPart(value = "files") List<MultipartFile> imageFileList) {

        log.info("imageProcedure(): " + imageFileList);

        try {
            for (MultipartFile multipartFile: imageFileList) {
                log.info("requestUploadFilesWithText() - Make file: " +
                        multipartFile.getOriginalFilename());

                /*
                FileOutputStream writer = new FileOutputStream(
                        "../../vue/frontend/src/assets/uploadImgs/" + multipartFile.getOriginalFilename()
                );

                log.info("디렉토리에 파일 배치 성공!");

                writer.write(multipartFile.getBytes());

                writer.close();
                 */
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("requestUploadFilesWithText(): Success!");

        return true;
    }
}
