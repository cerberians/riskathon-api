package lu.cerberians.sollist;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HelloMapper {

    void createNode(@Param("id") String nodeId);

}
