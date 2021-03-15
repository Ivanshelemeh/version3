package org.itstep.msk.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private final KafkaTemplate<String,Object> kafkaTemplate;

    private String topic = "product-demo";

        @Autowired
    public KafkaController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
     //   this.topic=topic;
    }
    @GetMapping("/check/{name}")
    public String messageConsum(@PathVariable String name){
            kafkaTemplate.send(topic, "Let work" +name+ "with kafka");
            return "Message published";
    }

}
