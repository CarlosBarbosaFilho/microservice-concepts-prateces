package br.com.cbgomes.mscustomer.controller.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CustomerRepresentationResponse {

    private Long id;
    private String name;
    private Integer age;
    private String document;
}
