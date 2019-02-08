package lu.cerberians.sollist.sollcreation;

import lu.cerberians.sollist.constraints.Constraint;

import java.util.List;

public class ToxicEntitlementsForm {

    private List<Constraint> constraints;
    private String fconstraints;

    public ToxicEntitlementsForm(List<Constraint> constraints) {
        this.constraints = constraints;
    }
}
