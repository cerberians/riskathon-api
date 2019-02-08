package lu.cerberians.sollist.constraints;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ConstraintForm {

    List<Constraint> constraints;

    public List<Constraint> getConstraints() {
        return constraints != null ? constraints: new ArrayList<>();
    }
}
