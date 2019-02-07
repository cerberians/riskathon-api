package lu.cerberians.sollist.constraints;

import lu.cerberians.sollist.entities.Constraint;
import lu.cerberians.sollist.entities.Entitlement;
import lu.cerberians.sollist.entities.Entity;
import lu.cerberians.sollist.mapper.ConstraintMapper;
import lu.cerberians.sollist.mapper.EntitlementMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Service
public class ConstraintsService {

    private ConstraintMapper mapper;

    @Inject
    public ConstraintsService(ConstraintMapper mapper) {
        this.mapper = mapper;
    }

    public Constraint create(String a, String b, boolean whitelist) {
        Constraint constraint = new Constraint()
                .setId(UUID.randomUUID().toString())
                .setAId(a)
                .setBId(b)
                .setIsWhitelist(whitelist);
        mapper.create(constraint);
        return constraint;
    }
}
