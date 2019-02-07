package lu.cerberians.sollist.applications;

import lu.cerberians.sollist.entities.Application;
import lu.cerberians.sollist.entities.Asset;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ApplicationsConverter {

    public Stream<ApplicationsDto> convert(Application application){
        int appId = Integer.valueOf(application.getId());
        String appName = application.getName();
        return application.getAssets().stream()
                .map(a -> convert(a, appId, appName));
    }

    public ApplicationsDto convert(Asset asset, int appId, String appName){
        ApplicationsDto dto = new ApplicationsDto();
        dto.setAssetId(Integer.valueOf(asset.getId()));
        dto.setAssetName(asset.getName());
        dto.setApplication(appName);
        dto.setAppId(appId);
        return dto;
    }
}
