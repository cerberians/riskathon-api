package lu.cerberians.sollist.mapper;

import lu.cerberians.sollist.entities.Privilege;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PrivilegeMapper {
    List<Privilege> selectAll();

    void create(@Param("privilege") Privilege privilege);
}
