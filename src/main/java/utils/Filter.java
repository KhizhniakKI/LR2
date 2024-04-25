package utils;

import data_type.measurements.SAV;
import data_type.measurements.Vector;

public abstract class Filter {

    public abstract void process(SAV instMag , Vector vector);
}
