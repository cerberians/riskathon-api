package lu.cerberians.sollist.entitlements;

import lu.cerberians.sollist.entities.Entitlement;
import lu.cerberians.sollist.mapper.EntitlementMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Service
public class EntitlementsService {

    private EntitlementMapper entitlementMapper;

    @Inject
    public EntitlementsService(EntitlementMapper entitlementMapper) {
        this.entitlementMapper = entitlementMapper;
    }

    public Entitlement create(Entitlement entitlement) {
        entitlement.setId(UUID.randomUUID().toString());
        entitlementMapper.create(entitlement);
        return entitlement;
    }

    public List<Entitlement> getAll() {
        return entitlementMapper.getAll();
    }

}
