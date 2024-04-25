package data_type.measurements;

import data_type.Data;
import lombok.Getter;
import lombok.Setter;

public class Vector extends Data {
    @Getter @Setter
    private AnalogValue Mag = new AnalogValue();
    @Getter @Setter
    private AnalogValue ang = new AnalogValue();
}
