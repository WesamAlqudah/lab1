package miu.edu.demo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin
public class AdminController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public String adminCall(){
        return "This admin page";
    }
}

