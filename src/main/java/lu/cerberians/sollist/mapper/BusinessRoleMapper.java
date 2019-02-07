package lu.cerberians.sollist.mapper;

import lu.cerberians.sollist.entities.Privilege;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BusinessRoleMapper {
    List<Privilege> selectAll();
}
