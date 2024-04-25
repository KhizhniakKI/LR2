package data_type.description;

import data_type.Data;
import data_type.common.Attribute;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DPL extends Data {
    private Attribute<String> vendor = new Attribute<>();
}
