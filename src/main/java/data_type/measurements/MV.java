package data_type.measurements;

import data_type.Data;
import data_type.common.Quality;
import data_type.common.Timestamp;

@lombok.Data
public class MV extends Data {

    private AnalogValue mag = new AnalogValue();
    private Quality q = new Quality();
    private Timestamp t = new Timestamp();

}
