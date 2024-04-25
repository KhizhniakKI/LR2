package data_type.controls;

import data_type.Data;
import data_type.common.Attribute;
import data_type.common.Quality;
import data_type.common.Timestamp;
import lombok.Getter;
import lombok.Setter;

public class INC extends Data {
    @Getter
    @Setter
    private Attribute<Integer> stVal = new Attribute<>();
    @Getter @Setter
    private Quality q = new Quality();
    @Getter @Setter
    private Timestamp t = new Timestamp();
}
