package com.skyros.demo.service;

import com.google.gson.Gson;
import com.skyros.demo.vo.EmployeeVO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@Setter
@Getter
@Log4j2
@RequiredArgsConstructor
public class EmployeeService {


    private final EmployeeUtil employeeUtil;
    private final Gson gson;
    private final KafkaTemplate kafkaTemplate;
    @Value("${producer.topic.msg}")
    private String topicMsg;
    @Value("${producer.topic.emp}")
    private String topicEmp;

    public void sendMessage(String msg) {
        log.info("Payload : {}", msg);
        try {
            getKafkaTemplate().send(topicMsg, msg);
        } catch (Exception ex) {
            log.error(ex);
        }
    }

    public void createRandomEmployee() {
        EmployeeVO employeeVO = getEmployeeUtil().createRandomEmployee();
        String employee = getGson().toJson(employeeVO);
        try {
            getKafkaTemplate().send(topicMsg, employee);
        } catch (Exception ex) {
            log.error(ex);
        }
    }

}
