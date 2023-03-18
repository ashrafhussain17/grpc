package com.dohatec.pcbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.dohatec.pcbook", "com.dohatec"})
public class PcBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(PcBookApplication.class, args);
    }

}
