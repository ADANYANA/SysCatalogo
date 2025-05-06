package pe.SysCatalogo.Catalogo.service.Implementacion;

import pe.SysCatalogo.Catalogo.modelo.Cliente;
import pe.SysCatalogo.Catalogo.repository.IClienteRepository;
import pe.SysCatalogo.Catalogo.repository.ICrudGenericRepository;
import pe.SysCatalogo.Catalogo.service.IClienteService;
import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class ClienteServiceImpl extends CrudGenericoServiceImplementacion<Cliente,Long>
        implements IClienteService {

    private final IClienteRepository clienteRepository;
    @Override
    protected ICrudGenericRepository<Cliente, Long> getRepo() {
        return clienteRepository;
    }
}
