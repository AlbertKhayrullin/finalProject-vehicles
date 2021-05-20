package tech.itpark.jdbc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.itpark.jdbc.domain.Protocol;
import tech.itpark.jdbc.manager.ProtocolManager;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("protocols")

public class ProtocolController {
    public final ProtocolManager manager;

    @GetMapping()
    public List<Protocol> getAll() {return manager.getAll();
    }

    @GetMapping(path = "/{regNumber}", params = "paid")
    public List<Protocol> getByRegNumberPaid(@PathVariable String regNumber, @RequestParam boolean paid) {
        return manager.getByRegNumberPaid(regNumber, paid);
    }

    @GetMapping(path = "/regNumberSumNoPaid", params = "regNumber")
    public int getByRegNumberSumPaid(@RequestParam String regNumber ) {
        return manager.getByRegNumberSumNoPaid(regNumber);
    }

    @GetMapping("/{name}")
    public List<Protocol> getByName(@PathVariable String name) {
        return manager.getByName(name);
    }

    @GetMapping(path = "/nameSumNoPaid", params = "name")
    public int getByNameSumNoPaid(@RequestParam String name ) {
        return  manager.getByNameSumNoPaid(name);
    }
}
