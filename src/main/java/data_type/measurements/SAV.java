package data_type.measurements;

import data_type.Data;
import data_type.common.Quality;
import data_type.common.Timestamp;
//import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class SAV extends Data {
    @Getter @Setter
    private AnalogValue instMag = new AnalogValue();
    @Getter @Setter
    private Quality q = new Quality();
    @Getter @Setter
    private Timestamp t = new Timestamp();
}
