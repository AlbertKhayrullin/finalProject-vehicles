package tech.itpark.jdbc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.itpark.jdbc.domain.Auto;
import tech.itpark.jdbc.manager.AutoManager;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/autos")

public class AutoController {
    public final AutoManager manager;

    @GetMapping
    public List<Auto> getAll() {
        return manager.getAll();
    }

    @GetMapping("/{id}")
    public Auto getById(@PathVariable long id) {
        return manager.getById(id);
    }

    @PostMapping
    public Auto save(@RequestBody Auto item) {
        return manager.save(item);
    }

    @DeleteMapping("/{id}")
    public Auto removeById(@PathVariable long id) { return manager.removeById(id);}

}




