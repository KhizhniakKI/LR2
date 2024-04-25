package data_type.protection;

import data_type.Data;
import data_type.common.Attribute;
import data_type.common.Quality;
import data_type.common.Timestamp;
import data_type.measurements.AnalogValue;
import lombok.Getter;
import lombok.Setter;

public class SPS extends Data {
    @Getter @Setter
    private Attribute<Boolean> stVal = new Attribute<>();
    @Getter @Setter
    private Quality q = new Quality();
    @Getter @Setter
    private Timestamp t = new Timestamp();
}
