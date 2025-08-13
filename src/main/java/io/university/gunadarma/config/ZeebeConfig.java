package io.university.gunadarma.config;

import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.springframework.context.annotation.Configuration;

@Configuration
@Deployment(resources = {
    "classpath*:/bpmn/*.bpmn",
    "classpath*:/forms/*.form"
})
public class ZeebeConfig {
    // Simplified configuration focusing on BPMN and form deployment
} 