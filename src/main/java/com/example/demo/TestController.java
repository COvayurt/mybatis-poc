package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final UserService caseService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return caseService.getUserById(id);
    }

    @GetMapping("/user")
    public List<User> list() {
        return caseService.getAll();
    }

    @GetMapping("/user-count")
    public List<CountOfSchemas> listCount() {
        return caseService.getAllByCount();
    }

    @PostMapping("/user")
    public void save(@RequestBody User c) {
        caseService.save(c);
    }

    @PostMapping("/user/schema")
    public void saveWithSchema(@RequestParam(value = "usert") User userT, @RequestParam String schema) {
        caseService.save(userT, schema);
    }
}
