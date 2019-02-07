package lu.cerberians.sollist.entities;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Constraint {

    private String id;

    private Boolean isWhitelist;

    // FROM
    private Entity a;

    // TO
    private Entity b;
}
