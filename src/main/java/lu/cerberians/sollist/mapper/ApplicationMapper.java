package lu.cerberians.sollist.mapper;

import lu.cerberians.sollist.entities.Application;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplicationMapper {
    List<Application> selectAll();
}
