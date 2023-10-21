package ru.netology.db_entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreditEntity {
    String id;
    String bank_id;
    String created;
    String status;
}
