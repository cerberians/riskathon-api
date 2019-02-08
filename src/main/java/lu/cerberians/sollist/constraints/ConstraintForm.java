package lu.cerberians.sollist.constraints;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

public class ConstraintForm {

    @Valid
    private List<Constraint> constraints = new ArrayList<>();

    public ConstraintForm() {
    }

    public List<Constraint> getConstraints() {
return constraints;    }

    public void setConstraints(List<Constraint> constraints) {
        this.constraints = constraints;
    }
}
