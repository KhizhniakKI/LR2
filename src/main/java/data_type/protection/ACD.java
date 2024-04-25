package data_type.protection;

import data_type.common.Attribute;
import data_type.common.Quality;
import data_type.common.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ACD extends ACT{
    private Attribute<Boolean> general = new Attribute<>();
    private Attribute<Direction> dirGeneral = new Attribute<>();
    private Attribute<Boolean> phsA = new Attribute<>();
    private Attribute<Direction> dirPhsA = new Attribute<>();
    private Attribute<Boolean> phsB = new Attribute<>();
    private Attribute<Direction> dirPhsB = new Attribute<>();
    private Attribute<Boolean> phsC = new Attribute<>();
    private Attribute<Direction> dirPhsC = new Attribute<>();
    private Attribute<Boolean> neut = new Attribute<>();
    private Attribute<Direction> dirNeut = new Attribute<>();
    private Quality q = new Quality();
    private Timestamp t = new Timestamp();

    public enum Direction {
        UNKNOWN, FORWARD, BACKWARD, BOTH
    }
}
