package lu.cerberians.sollist.entities;

import lombok.Data;

import java.util.List;

@Data
public class Application {
    private String id;
    private String name;
    private  List<Asset> assets;
}
