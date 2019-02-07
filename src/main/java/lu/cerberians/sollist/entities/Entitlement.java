package lu.cerberians.sollist.entities;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Entitlement {

    private String id;
    private String name;
    private Privilege privilege;

}
