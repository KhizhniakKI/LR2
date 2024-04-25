package data_type.setting;

import data_type.Data;
import data_type.measurements.AnalogValue;

@lombok.Data
public class ASG extends Data {

    private AnalogValue setMag = new AnalogValue();
}
