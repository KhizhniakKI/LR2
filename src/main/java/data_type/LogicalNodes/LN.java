package data_type.LogicalNodes;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public abstract class LN {

    private String pref;
    private String clazz;
    private int inst;

    public abstract void process();
}
