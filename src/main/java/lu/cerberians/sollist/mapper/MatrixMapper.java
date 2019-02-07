package lu.cerberians.sollist.mapper;

import lu.cerberians.sollist.entities.Matrix;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MatrixMapper {
    void create(@Param("matrix") Matrix matrix);
}
