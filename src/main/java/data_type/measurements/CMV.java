package data_type.measurements;

import data_type.Data;
import data_type.common.Quality;
import data_type.common.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CMV extends Data {
    private Vector cVal = new Vector();
    private Quality q = new Quality();
    private Timestamp t = new Timestamp();
}
