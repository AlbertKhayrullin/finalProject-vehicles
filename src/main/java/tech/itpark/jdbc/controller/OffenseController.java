package tech.itpark.jdbc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.itpark.jdbc.domain.Offense;
import tech.itpark.jdbc.manager.OffenseManager;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/offenses")

public class OffenseController {
    public final OffenseManager manager;

    @GetMapping("")
    public List<Offense> getAll() { return manager.getAll();}

    @GetMapping("/{id}")
    public Offense getById(@PathVariable long id) {
        return manager.getById(id);
    }

    @PostMapping("")
    public Offense save(@RequestBody Offense item) { return manager.save(item); }
}
