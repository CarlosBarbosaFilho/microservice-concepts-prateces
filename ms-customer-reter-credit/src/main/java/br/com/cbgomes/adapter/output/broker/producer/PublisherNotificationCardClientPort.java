package br.com.cbgomes.adapter.output.broker.producer;

import br.com.cbgomes.adapter.output.broker.domain.DataIssuanceCard;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PublisherNotificationCardClientPort {

    void sendNotificationIssuanceCard(DataIssuanceCard dataIssuanceCard) throws JsonProcessingException;
}
