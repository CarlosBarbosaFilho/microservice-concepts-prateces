package br.com.cbgomes.adapter.input.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EvaluationResultCustomerResponse {

    private List<CardApprovedResponse> cards_approved;

}
