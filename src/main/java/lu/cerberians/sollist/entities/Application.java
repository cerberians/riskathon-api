package lu.cerberians.sollist.entities;

import lombok.Data;

import java.util.List;

@Data
public class Application {
    private String id;
    private String name;
    private  List<Asset> assets;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }
}
