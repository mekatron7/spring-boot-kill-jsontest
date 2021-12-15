package net.yorksolutions.jsontestcomp.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    ToDoRepository repository;

    @GetMapping("/hello")
    String respond() {
        return "Hello, World!";
    }

    @GetMapping("/echo")
    String echo(@RequestParam("id") String strToEcho) {
        return strToEcho;
    }

    @GetMapping("/add")
    String add(String text) {
        repository.save(new ToDo(text));
        return "success";
    }

    @GetMapping("/getAll")
    Iterable<ToDo> getAll() {
        return repository.findAll();
    }

    @GetMapping("/getById")
    ToDo getById(Long id) {
        return repository.findById(id).orElse(new ToDo());
    }

    @GetMapping("/headers")
    Map<String, String> header(@RequestHeader Map<String, String> headers) {
        return headers;
    }

    @GetMapping("/todo/{id}")
    ToDo todoById(@PathVariable Long id){
        return repository.findById(id).orElse(new ToDo());
    }
}