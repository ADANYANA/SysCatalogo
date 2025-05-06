package pe.SysCatalogo.Catalogo.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.SysCatalogo.Catalogo.modelo.ProcesoFabricacion;
import pe.SysCatalogo.Catalogo.service.IProcesoFabricacionService;


import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/procesoFabricacion")
public class ProcesoFabricacionController {
    private final IProcesoFabricacionService procesoFabricacionService;
    @GetMapping
    public ResponseEntity<List<ProcesoFabricacion>> findAll() {
        List<ProcesoFabricacion> list = procesoFabricacionService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProcesoFabricacion> findById(@PathVariable("id") Long
                                                    id) {
        ProcesoFabricacion obj = procesoFabricacionService.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ProcesoFabricacion dto) {
        ProcesoFabricacion obj = procesoFabricacionService.save(dto);
        URI location =

                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                        obj.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProcesoFabricacion> update(@PathVariable("id") Long
                                                  id, @RequestBody
    ProcesoFabricacion dto) {
        dto.setId(id);
        ProcesoFabricacion obj = procesoFabricacionService.update(id, dto);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        procesoFabricacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}