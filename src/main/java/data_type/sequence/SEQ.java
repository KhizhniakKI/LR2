package data_type.sequence;

import data_type.measurements.CMV;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class SEQ {

    private CMV c1 = new CMV();
    private CMV c2 = new CMV();
    private CMV c3 = new CMV();

    public enum seqT {
        POS, NEG, ZERO
    }



}
