package net.yorksolutions.jsontestcomp.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.HashMap;
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

    @GetMapping("/dateAndTime")
    HashMap dateTimeInfo() {
        LocalDateTime dt = LocalDateTime.now();
        var date = dt.toLocalDate();
        var milliseconds = dt.toEpochSecond(ZoneOffset.UTC);
        var time = dt.toLocalTime();

        HashMap<String,String> dtInfo = new HashMap<>();
        dtInfo.put("date", date.toString());
        dtInfo.put("milliseconds_since_epoch", String.valueOf(milliseconds));
        dtInfo.put("time", time.toString());

        return dtInfo;
    }
}