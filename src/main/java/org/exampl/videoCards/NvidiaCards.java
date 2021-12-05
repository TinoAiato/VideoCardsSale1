package org.exampl.videoCards;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class NvidiaCards {
    private long id;
    public String name;
    public long price;
    public int videoMemory;
    public String coolingType;
    public String manufacture;
}
