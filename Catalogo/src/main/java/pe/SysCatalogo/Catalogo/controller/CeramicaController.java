package pe.SysCatalogo.Catalogo.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.SysCatalogo.Catalogo.modelo.Ceramica;
import pe.SysCatalogo.Catalogo.service.ICeramicaService;


import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ceramica")
public class CeramicaController {
    private final ICeramicaService ceramicaService;
    @GetMapping
    public ResponseEntity<List<Ceramica>> findAll() {
        List<Ceramica> list = ceramicaService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ceramica> findById(@PathVariable("id") Long
                                                      id) {
        Ceramica obj = ceramicaService.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Ceramica dto) {
        Ceramica obj = ceramicaService.save(dto);
        URI location =

                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                        obj.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Ceramica> update(@PathVariable("id") Long
                                                    id, @RequestBody
    Ceramica dto) {
        dto.setId(id);
        Ceramica obj = ceramicaService.update(id, dto);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        ceramicaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}