package lu.cerberians.sollist.mapper;

import lu.cerberians.sollist.entities.Application;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ApplicationMapper {
    List<Application> selectAll();
}
