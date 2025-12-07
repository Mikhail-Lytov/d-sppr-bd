package com.lytov.diplom.dspprbd.dto;


import com.lytov.diplom.dspprbd.dto.enums.OrderDirection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * This class contains fields of request sort representation.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SortRequestDTO {
    private String key;

    private OrderDirection direction;
}
