package org.body.balance.recipe.sender;

import org.body.balance.recipe.exception.SendDataToKafkaException;

public interface DataSender {
    void send(String value) throws SendDataToKafkaException;
}
