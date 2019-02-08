package lu.cerberians.sollist.matrix;

import lu.cerberians.sollist.ApplicationContext;
import lu.cerberians.sollist.constraints.Constraint;
import lu.cerberians.sollist.entities.*;
import lu.cerberians.sollist.mapper.ConstraintMapper;
import lu.cerberians.sollist.mapper.MatrixMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MatrixService {

    private ConstraintMapper constraintMapper;
    private MatrixMapper matrixMapper;
    private ApplicationContext applicationContext;

    @Inject
    public MatrixService(ConstraintMapper constraintMapper, MatrixMapper matrixMapper, ApplicationContext applicationContext) {
        this.constraintMapper = constraintMapper;
        this.matrixMapper = matrixMapper;
        this.applicationContext = applicationContext;
    }

    public Matrix createMatrix(List<String> list) {
        List<Constraint> constraints= new ArrayList<>();
        for(String elem : list) {
               String[] str = elem.split(",");
            Entity from = Entity.builder().id(str[0]).build();
            Entity to = Entity.builder().id(str[1]).build();
            Constraint constraint = Constraint.builder().fromEntity( from)
                    .toEntity( to)
                    .id(UUID.randomUUID().toString())
                    .whitelist("true".equals(str[2]) ? Boolean.TRUE : Boolean.FALSE).build();
            constraints.add(constraint);
        }
        Asset asset = new Asset();
        asset.setId("16");
        Matrix matrix = new Matrix()
                .setId(UUID.randomUUID().toString())
                .setConstraints(constraints)
                .setAsset(asset);
        matrix.getConstraints().forEach(this::createConstraint);
        matrix.setId(UUID.randomUUID().toString());
        matrixMapper.create(matrix);
        return matrix;
    }

    public Constraint createConstraint(Constraint constraint) {
         constraint .setId(UUID.randomUUID().toString());
        constraintMapper.create(constraint);
        return constraint;
    }
}
