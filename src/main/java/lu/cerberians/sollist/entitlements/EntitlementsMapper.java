package lu.cerberians.sollist.entitlements;

import lu.cerberians.sollist.entities.Entitlement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EntitlementsMapper {

    void create(@Param("entitlement") Entitlement entitlement);
    List<Entitlement> getAll();

}
