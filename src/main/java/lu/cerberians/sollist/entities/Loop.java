package lu.cerberians.sollist.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Objects;

@Data
@Accessors(chain = true)
public class Loop {
    private String acc;
    private String af;
    private String br;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loop loop = (Loop) o;
        return Objects.equals(acc, loop.acc) &&
                Objects.equals(af, loop.af);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acc, af);
    }
}
