package lu.cerberians.sollist.entities;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Constraint {

    private String id;

    private Boolean whitelist;

    // FROM
    private String from;

    // TO
    private String to;
}
