package lu.cerberians.sollist.mapper;

import lu.cerberians.sollist.entities.Loop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoopMapper {

    List<Loop> whitelist();
    List<Loop> blacklist();
}
