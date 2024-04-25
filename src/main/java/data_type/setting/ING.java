package data_type.setting;

import data_type.Data;
import data_type.common.Attribute;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ING extends Data {

    private Attribute<Integer> setVal = new Attribute<>();
}
