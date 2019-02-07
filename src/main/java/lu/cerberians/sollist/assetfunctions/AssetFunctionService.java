package lu.cerberians.sollist.assetfunctions;

import lu.cerberians.sollist.entities.AssetFunction;
import lu.cerberians.sollist.mapper.AssetFunctionMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Service
public class AssetFunctionService {

    private AssetFunctionMapper assetFunctionMapper;

    @Inject
    public AssetFunctionService(AssetFunctionMapper assetFunctionMapper) {
        this.assetFunctionMapper = assetFunctionMapper;
    }

    public AssetFunction create(AssetFunction assetFunction) {
        assetFunction.setId(UUID.randomUUID().toString());
        assetFunctionMapper.create(assetFunction);
        return assetFunction;
    }

    public List<AssetFunction> getAll() {
        return assetFunctionMapper.getAll();
    }

}
