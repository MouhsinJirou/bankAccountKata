package org.acensi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Getter
public class Transaction {

    private final int amount;
    private final TransactionType type;
    private final LocalDate date;

}
