package lu.cerberians.sollist.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(chain = true)
@Data
public class Matrix {

    private String id;

    Asset asset;

    List<Constraint> constraints;
}
