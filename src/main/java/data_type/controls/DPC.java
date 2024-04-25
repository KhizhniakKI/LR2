package data_type.controls;

import data_type.Data;
import data_type.common.Attribute;
import data_type.common.Quality;
import data_type.common.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DPC extends Data {
    private Attribute<Values> stVal = new Attribute<>();
    private Quality q = new Quality();
    private Timestamp t = new Timestamp();

    public enum Values{
        INTERMEDIATE_STATE, OFF, ON, BAD_STATE
    }
}
