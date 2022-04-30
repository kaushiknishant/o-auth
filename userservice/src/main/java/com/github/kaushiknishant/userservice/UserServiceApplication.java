package com.github.kaushiknishant.userservice;

import com.github.kaushiknishant.userservice.domain.Role;
import com.github.kaushiknishant.userservice.domain.User;
import com.github.kaushiknishant.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            userService.saveRole(new Role(null,"ROLE_USER"));
            userService.saveRole(new Role(null,"ROLE_MANAGER"));
            userService.saveRole(new Role(null,"ROLE_ADMIN"));
            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null,"John Doe", "johndoe","12345",new ArrayList<>()));
            userService.saveUser(new User(null,"Will Smith", "smithwill","12345",new ArrayList<>()));
            userService.saveUser(new User(null,"Katie William", "william123","12345",new ArrayList<>()));
            userService.saveUser(new User(null,"John Cena", "cenajohn","12345",new ArrayList<>()));

            userService.addRoleToUser("johndoe","ROLE_USER");
            userService.addRoleToUser("johndoe","ROLE_MANAGER");
            userService.addRoleToUser("johndoe","ROLE_ADMIN");
            userService.addRoleToUser("johndoe","ROLE_SUPER_ADMIN");
            userService.addRoleToUser("smithwill","ROLE_MANAGER");
            userService.addRoleToUser("william123","ROLE_ADMIN");
            userService.addRoleToUser("cenajohn","ROLE_SUPER_ADMIN");
            userService.addRoleToUser("cenajohn","ROLE_ADMIN");
            userService.addRoleToUser("cenajohn","ROLE_USER");

        };
    }

}
