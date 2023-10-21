package ru.netology.db_entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class OrderEntity {
    String id;
    String bank_id;
    String created;
    String credit_id;
    String payment_id;
}
