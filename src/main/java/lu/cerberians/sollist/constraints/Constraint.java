package lu.cerberians.sollist.constraints;

import lombok.Builder;
import lombok.Data;
import lu.cerberians.sollist.entities.Entity;

@Data
@Builder
public class Constraint {
    private String id;
    private Boolean whitelist;
    private Entity fromEntity;
    private Entity toEntity;

}
