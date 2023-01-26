package br.com.cbgomes.mscustomer.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerData {
    private Long id;
    private String name;
    private Integer age;
    private String document;
}
