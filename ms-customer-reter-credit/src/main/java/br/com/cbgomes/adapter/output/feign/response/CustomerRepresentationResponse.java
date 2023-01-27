package br.com.cbgomes.adapter.output.feign.response;

import br.com.cbgomes.adapter.input.api.response.CardsCustomerResponse;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRepresentationResponse {

    private CustomerDataResponseClient customerDataResponse;
    private List<CardsCustomerResponse> cards;

}
