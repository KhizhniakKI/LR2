package data_type.measurements;

import data_type.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DEL extends Data {
    private CMV phsAB = new CMV();
    private CMV phsBC = new CMV();
    private CMV phsCA = new CMV();
}
