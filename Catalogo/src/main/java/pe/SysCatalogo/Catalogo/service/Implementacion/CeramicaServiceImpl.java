package pe.SysCatalogo.Catalogo.service.Implementacion;

import pe.SysCatalogo.Catalogo.modelo.Ceramica;
import pe.SysCatalogo.Catalogo.repository.ICeramicaRepository;
import pe.SysCatalogo.Catalogo.repository.ICrudGenericRepository;
import pe.SysCatalogo.Catalogo.service.ICeramicaService;

import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor

public class CeramicaServiceImpl extends CrudGenericoServiceImplementacion<Ceramica,Long>
        implements ICeramicaService {

    private final ICeramicaRepository ceramicaRepository;
    @Override
    protected ICrudGenericRepository<Ceramica, Long> getRepo() {
        return ceramicaRepository;
    }
}
