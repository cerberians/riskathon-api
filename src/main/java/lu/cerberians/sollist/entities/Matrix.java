package lu.cerberians.sollist.entities;

import lombok.Data;

import java.util.List;

@Data
public class Matrix {

    Asset asset;

    List<Constraint> constraints;
}
