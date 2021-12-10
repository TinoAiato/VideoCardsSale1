package org.exampl.comparison;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GameComparison {
    private long id;
    private String name;
    private int fps;
    private boolean rtx;
}
