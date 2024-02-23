package org.example.data;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BookDto {

    public Long id;

    private String title;

    private String description;

    private String price;

}
