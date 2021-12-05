package org.exampl.comparison;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GameComparison {
    private long id;
    private String name;
    private int fps;
    private boolean rtx;
}
