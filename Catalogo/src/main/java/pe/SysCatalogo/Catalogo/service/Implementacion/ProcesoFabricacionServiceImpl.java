package pe.SysCatalogo.Catalogo.service.Implementacion;

import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.SysCatalogo.Catalogo.modelo.ProcesoFabricacion;
import pe.SysCatalogo.Catalogo.repository.ICrudGenericRepository;
import pe.SysCatalogo.Catalogo.repository.IProcesoFabricacionRepository;
import pe.SysCatalogo.Catalogo.service.IProcesoFabricacionService;

@Transactional
@Service
@RequiredArgsConstructor
public class ProcesoFabricacionServiceImpl extends CrudGenericoServiceImplementacion<ProcesoFabricacion,Long>
        implements IProcesoFabricacionService {
    private final IProcesoFabricacionRepository procesoFabricacionRepository;

    @Override
    protected ICrudGenericRepository<ProcesoFabricacion, Long> getRepo() {
        return procesoFabricacionRepository;
    }
}
