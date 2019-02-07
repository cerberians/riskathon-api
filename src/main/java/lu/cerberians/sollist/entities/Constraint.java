package lu.cerberians.sollist.entities;

import lombok.Data;

@Data
public class Constraint {

    private ConstraintType type;
    private Entity a;
    private Entity b;
}
