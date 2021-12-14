package org.exampl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NvidiaCardsGetByIdResponseDTO {
    private NvidiaCards nvidiaCards;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class NvidiaCards {
        private long id;
        private String name;
        private long price;
        private int videoMemory;
        private String coolingType;
        private String manufacture;
        private int qty;
    }
}
