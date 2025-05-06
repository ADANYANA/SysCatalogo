package pe.SysCatalogo.Catalogo.service.Implementacion;
import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.SysCatalogo.Catalogo.modelo.DetallePedido;
import pe.SysCatalogo.Catalogo.repository.ICrudGenericRepository;
import pe.SysCatalogo.Catalogo.repository.IDetallePedidoRepository;
import pe.SysCatalogo.Catalogo.service.IDetallePedidoService;

@Transactional
@Service
@RequiredArgsConstructor
public class DetallePedidoServiceImpl extends CrudGenericoServiceImplementacion<DetallePedido, Long>
        implements IDetallePedidoService {
    private final IDetallePedidoRepository detallePedidoRepository;
    @Override
    protected ICrudGenericRepository<DetallePedido, Long> getRepo() {
        return detallePedidoRepository;
    }
}
