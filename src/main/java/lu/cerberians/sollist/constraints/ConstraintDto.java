package lu.cerberians.sollist.constraints;

import lombok.Builder;
import lombok.Data;
import lu.cerberians.sollist.entities.Entity;

@Data
@Builder
public class ConstraintDto {
    private Entity fromEntity;
    private Entity toEntity;
    private boolean allowed;

}
