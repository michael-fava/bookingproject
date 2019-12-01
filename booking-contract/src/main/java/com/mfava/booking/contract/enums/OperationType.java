package com.mfava.booking.contract.enums;

import lombok.*;

/**
 * @author michaelfava
 */

@NoArgsConstructor
@AllArgsConstructor
public enum OperationType {
    ADD("booking.add"),
    UPDATE("booking.update"),
    DELETE("booking.delete");

    @Getter
    @Setter
    private String operationTag;
}
