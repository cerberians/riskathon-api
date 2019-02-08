package lu.cerberians.sollist.constraints;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ConstraintForm {

    private List<Constraint> constraints;
    private String fconstraints;

    public List<Constraint> getConstraints() {
        return constraints != null ? constraints: new ArrayList<>();
    }
}
