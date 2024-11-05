package com.skyros.demo.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;
    @Value("#{'${app.topic.list}'.split(',')}")
    private List<String> topicList;
    @Value("${app.partitions.num}")
    private int numPartitions;
    @Value("${app.replicationFactor}")
    private short replicationFactor;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    /*
    @Bean
    public List<NewTopic> topicList() {
        List<NewTopic> newTopics = new ArrayList<>();
        topicList.forEach(topic -> {
            newTopics.add(new NewTopic(topic, numPartitions, replicationFactor));
        });
        return newTopics;
    }
     */

    @Bean
    public NewTopic newTopic() {
        return new NewTopic("dummy", numPartitions, replicationFactor);
    }
}
