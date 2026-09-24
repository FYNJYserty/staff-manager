package org.example.staffmanager;

import org.springframework.boot.SpringApplication;

public class TestStaffManagerApplication {

    public static void main(String[] args) {
        SpringApplication.from(StaffManagerApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
