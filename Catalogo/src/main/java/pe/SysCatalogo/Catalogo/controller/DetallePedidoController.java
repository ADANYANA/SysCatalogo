package pe.SysCatalogo.Catalogo.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import pe.SysCatalogo.Catalogo.modelo.DetallePedido;
import pe.SysCatalogo.Catalogo.service.IDetallePedidoService;


import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/detallePedido")
public class DetallePedidoController {
    private final IDetallePedidoService detallePedidoService;
    @GetMapping
    public ResponseEntity<List<DetallePedido>> findAll() {
        List<DetallePedido> list = detallePedidoService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> findById(@PathVariable("id") Long
                                                    id) {
        DetallePedido obj = detallePedidoService.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody DetallePedido dto) {
        DetallePedido obj = detallePedidoService.save(dto);
        URI location =

                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                        obj.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<DetallePedido> update(@PathVariable("id") Long
                                                  id, @RequestBody
    DetallePedido dto) {
        dto.setId(id);
        DetallePedido obj = detallePedidoService.update(id, dto);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        detallePedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}