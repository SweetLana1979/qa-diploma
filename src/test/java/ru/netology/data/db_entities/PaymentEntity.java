package ru.netology.data.db_entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentEntity {
    String id;
    String amount;
    String created;
    String status;
    String transaction_id;
}
