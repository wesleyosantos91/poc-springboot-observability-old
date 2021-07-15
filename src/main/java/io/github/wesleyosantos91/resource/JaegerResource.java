package io.github.wesleyosantos91.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jaeger/v1")
public class JaegerResource {

    @GetMapping
    public String helloWorld() {
        return "Hello World";
    }
}
