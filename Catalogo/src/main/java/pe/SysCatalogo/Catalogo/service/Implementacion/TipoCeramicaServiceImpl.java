package pe.SysCatalogo.Catalogo.service.Implementacion;

import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.SysCatalogo.Catalogo.modelo.TipoCeramica;
import pe.SysCatalogo.Catalogo.repository.ICrudGenericRepository;
import pe.SysCatalogo.Catalogo.repository.ITipoCeramicaRepository;
import pe.SysCatalogo.Catalogo.service.ITipoCeramicaService;

@Transactional
@Service
@RequiredArgsConstructor

public class TipoCeramicaServiceImpl extends CrudGenericoServiceImplementacion<TipoCeramica,Long>
        implements ITipoCeramicaService {
    private final ITipoCeramicaRepository tipoCeramicaRepository;

    @Override
    protected ICrudGenericRepository<TipoCeramica, Long> getRepo() {
        return tipoCeramicaRepository;
    }
}
