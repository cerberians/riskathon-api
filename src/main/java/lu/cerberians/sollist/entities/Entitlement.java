package lu.cerberians.sollist.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class Entitlement extends Entity {
    private Privilege privilege;
}
