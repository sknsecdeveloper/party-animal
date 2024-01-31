package com.subh.jpademo.config.env;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
@Conditional(MyConditional.class)
@Profile(value = "dev")
public class EnvConfig implements CommandLineRunner {


    @Value("$message")
    private String msg;

    @Autowired
    private Environment environment;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("ENV SIZE :"+environment.getActiveProfiles().length);
        System.out.println("ACTIVE PROFILE : "+environment.getActiveProfiles()[0]);
        System.out.println("MESSAGE  : "+msg);
    }

}
