package lu.cerberians.sollist.matrix;

import lu.cerberians.sollist.ApplicationContext;
import lu.cerberians.sollist.entities.Constraint;
import lu.cerberians.sollist.entities.Matrix;
import lu.cerberians.sollist.mapper.ConstraintMapper;
import lu.cerberians.sollist.mapper.MatrixMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
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

    public Matrix createMatrix(List<Constraint> constraints) {
        Matrix matrix = new Matrix()
                .setId(UUID.randomUUID().toString())
                .setConstraints(constraints)
                .setAsset(applicationContext.getAsset());
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
