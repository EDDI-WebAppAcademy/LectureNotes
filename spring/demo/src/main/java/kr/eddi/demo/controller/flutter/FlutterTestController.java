package kr.eddi.demo.controller.flutter;

import kr.eddi.demo.controller.flutter.request.FlutterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/flutter-test")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FlutterTestController {

    @PostMapping("/login")
    public Boolean flutterMemgerLogin (@RequestBody FlutterRequest request) {
        log.info("flutterMemberLogin(): " + request);

        return true;
    }

    /*
    @PostMapping("/login")
    public Boolean flutterMemgerLogin (
            @RequestParam("email") String email,
            @RequestParam("password") String password) {

        log.info("email: " + email + ", password: " + password);

        return true;
    }
     */
}
