package pe.SysCatalogo.Catalogo.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.SysCatalogo.Catalogo.modelo.Pedido;
import pe.SysCatalogo.Catalogo.service.IPedidoService;


import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pedido")
public class PedidoController {
    private final IPedidoService pedidoService;
    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> list = pedidoService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable("id") Long
                                                    id) {
        Pedido obj = pedidoService.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Pedido dto) {
        Pedido obj = pedidoService.save(dto);
        URI location =

                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                        obj.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable("id") Long
                                                  id, @RequestBody
    Pedido dto) {
        dto.setId(id);
        Pedido obj = pedidoService.update(id, dto);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}