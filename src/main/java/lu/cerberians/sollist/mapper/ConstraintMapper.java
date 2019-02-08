package lu.cerberians.sollist.mapper;

import lu.cerberians.sollist.constraints.Constraint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ConstraintMapper {
    void create(@Param("constraint") Constraint constraint);
}
