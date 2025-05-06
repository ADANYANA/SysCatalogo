package pe.SysCatalogo.Catalogo.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.SysCatalogo.Catalogo.modelo.TipoCeramica;
import pe.SysCatalogo.Catalogo.service.ITipoCeramicaService;


import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipoCeramica")
public class TipoCeramicaController {
    private final ITipoCeramicaService tipoCeramicaService;
    @GetMapping
    public ResponseEntity<List<TipoCeramica>> findAll() {
        List<TipoCeramica> list = tipoCeramicaService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TipoCeramica> findById(@PathVariable("id") Long
                                                    id) {
        TipoCeramica obj = tipoCeramicaService.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipoCeramica dto) {
        TipoCeramica obj = tipoCeramicaService.save(dto);
        URI location =

                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                        obj.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<TipoCeramica> update(@PathVariable("id") Long
                                                  id, @RequestBody
    TipoCeramica dto) {
        dto.setId(id);
        TipoCeramica obj = tipoCeramicaService.update(id, dto);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        tipoCeramicaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}