package com.example.propietarioservice.test.cucumber;

import com.example.propietarioservice.PropietarioServiceApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = PropietarioServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = PropietarioServiceApplication.class, loader = SpringBootContextLoader.class)
public class CucumberSpringConfiguration {
}
