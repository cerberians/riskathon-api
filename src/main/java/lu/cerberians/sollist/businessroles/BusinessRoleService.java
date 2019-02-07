package lu.cerberians.sollist.businessroles;

import lu.cerberians.sollist.entities.BusinessRole;
import lu.cerberians.sollist.mapper.BusinessRoleMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class BusinessRoleService {
    private BusinessRoleMapper businessRoleMapper;

    @Inject
    public BusinessRoleService(BusinessRoleMapper businessRoleMapper) {
        this.businessRoleMapper = businessRoleMapper;
    }

    public List<BusinessRole> getAll() {
        return businessRoleMapper.selectAll();
    }

}