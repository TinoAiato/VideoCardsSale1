package org.exampl.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NvidiaCards {
    private long id;
    private String name;
    private long price;
    private int videoMemory;
    private String coolingType;
    private String manufacture;
    private int qty;
}
