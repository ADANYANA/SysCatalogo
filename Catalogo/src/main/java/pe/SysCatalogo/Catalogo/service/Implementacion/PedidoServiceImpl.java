package pe.SysCatalogo.Catalogo.service.Implementacion;
import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.SysCatalogo.Catalogo.modelo.Pedido;
import pe.SysCatalogo.Catalogo.repository.ICrudGenericRepository;
import pe.SysCatalogo.Catalogo.repository.IPedidoRepository;
import pe.SysCatalogo.Catalogo.service.IPedidoService;

@Transactional
@Service
@RequiredArgsConstructor
public class PedidoServiceImpl extends CrudGenericoServiceImplementacion <Pedido,Long>
        implements IPedidoService {
    private final IPedidoRepository pedidoRepository;

    @Override
    protected ICrudGenericRepository<Pedido, Long> getRepo() {
        return pedidoRepository;
    }
}
