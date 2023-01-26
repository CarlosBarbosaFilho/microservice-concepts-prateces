package br.com.cbgomes.adapter.output.feign.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CustomerData {

    private Long id;
    private String name;
}
