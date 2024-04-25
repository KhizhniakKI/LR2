package data_type.common;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
public class Attribute<T> {
    @Getter @Setter
    private T value;
}
