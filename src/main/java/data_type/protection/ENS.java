package data_type.protection;

import data_type.Data;
import data_type.common.Attribute;
import data_type.common.Quality;
import data_type.common.Timestamp;

public class ENS extends Data {
    private Attribute<Values> stVal = new Attribute<>();
    private Quality q = new Quality();
    private Timestamp t = new Timestamp();

    private enum Values{}
}
