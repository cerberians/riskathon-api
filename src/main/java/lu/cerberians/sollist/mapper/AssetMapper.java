package lu.cerberians.sollist.mapper;

import lu.cerberians.sollist.entities.Asset;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AssetMapper {
    Asset selectById(@Param("id") String assetId);
}
