package lu.cerberians.sollist.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Entity {
    private String id;
    private String name;

    public Entity() {
    }

    public Entity(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
