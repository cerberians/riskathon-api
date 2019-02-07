package lu.cerberians.sollist.entitlements;

import lu.cerberians.sollist.entities.Entitlement;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Service
public class EntitlementsService {

    private EntitlementsMapper entitlementsMapper;

    @Inject
    public EntitlementsService(EntitlementsMapper entitlementsMapper) {
        this.entitlementsMapper = entitlementsMapper;
    }

    public Entitlement create(Entitlement entitlement) {
        entitlement.setId(UUID.randomUUID().toString());
        entitlementsMapper.create(entitlement);
        return entitlement;
    }

    public List<Entitlement> getAll() {
        return entitlementsMapper.getAll();
    }

}
