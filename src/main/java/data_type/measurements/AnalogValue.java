package data_type.measurements;

import data_type.Data;
import data_type.common.Attribute;
import data_type.common.Quality;
import data_type.common.Timestamp;
import lombok.Getter;
import lombok.Setter;

@lombok.Data
public class AnalogValue extends Data {

    @Getter @Setter
    private Attribute<Double> f = new Attribute<>();

    private Quality q;
    private Timestamp t;
}
