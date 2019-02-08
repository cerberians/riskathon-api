package lu.cerberians.sollist.assetfunctions;

import lu.cerberians.sollist.ApplicationContext;
import lu.cerberians.sollist.entities.Asset;
import lu.cerberians.sollist.entities.AssetFunction;
import lu.cerberians.sollist.mapper.AssetFunctionMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Service
public class AssetFunctionService {

    private AssetFunctionMapper assetFunctionMapper;
    private ApplicationContext applicationContext;

    @Inject
    public AssetFunctionService(AssetFunctionMapper assetFunctionMapper,
                                ApplicationContext applicationContext) {
        this.assetFunctionMapper = assetFunctionMapper;
        this.applicationContext = applicationContext;
    }

    public AssetFunction create(AssetFunction assetFunction) {
        assetFunction.setId(UUID.randomUUID().toString());
        final Asset asset = applicationContext.getAsset();
        assetFunctionMapper.create(asset, assetFunction);
        return assetFunction;
    }

    public List<AssetFunction> getAll() {
        final Asset asset = new Asset();
        asset.setId("2");
        return assetFunctionMapper.getAll(asset);
    }

}
