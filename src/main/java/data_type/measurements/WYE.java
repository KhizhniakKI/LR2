package data_type.measurements;

import data_type.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class WYE extends Data {

    private CMV phsA = new CMV();
    private CMV phsB = new CMV();
    private CMV phsC = new CMV();
    private CMV neut = new CMV();

}
