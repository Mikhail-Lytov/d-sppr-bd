package com.lytov.diplom.dparser;

import com.lytov.diplom.dspprbd.DSpprBdApplication;
import org.springframework.boot.SpringApplication;

public class TestDParserBpmnApplication {

    public static void main(String[] args) {
        SpringApplication.from(DSpprBdApplication::main).with(RepositoryTestConfiguration.class).run(args);
    }

}
