package data_type.protection;

import data_type.Data;
import data_type.common.Attribute;
import data_type.common.Quality;
import data_type.common.Timestamp;

public class BCR extends Data {
    private Attribute<Integer> actVal = new Attribute<>();
    private Attribute<Integer> frVal = new Attribute<>();
    private Timestamp frTm = new Timestamp();
    private Quality q = new Quality();
    private Timestamp t = new Timestamp();
}
