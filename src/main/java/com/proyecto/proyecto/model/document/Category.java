package com.proyecto.proyecto.model.document;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("category")
public class Category {
    @Id
    private String id;
    private String code;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private boolean status;
}
