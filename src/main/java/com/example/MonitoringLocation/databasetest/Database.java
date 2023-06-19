package com.example.MonitoringLocation.databasetest;

import com.example.MonitoringLocation.model.User;
import com.example.MonitoringLocation.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {


    @Bean
    CommandLineRunner createDataUsers(UserRepository repository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                User u1 = new User("giang", "giang@gmail.com", "123");
                User u2 = new User("giang", "giang@gmail.com", "123");
                User u3 = new User("khai", "giang@gmail.com", "123");
                User u4 = new User("hieu", "giang@gmail.com", "123");
                User u5 = new User("quang", "giang@gmail.com", "123");
                User u6 = new User("nghia", "giang@gmail.com", "123");

                System.out.println("insert data : " + repository.save(u1));
                System.out.println("insert data : " + repository.save(u2));
                System.out.println("insert data : " + repository.save(u3));
                System.out.println("insert data : " + repository.save(u4));
                System.out.println("insert data : " + repository.save(u5));
                System.out.println("insert data : " + repository.save(u6));

            }
        };
    }

//   // @Bean
//    CommandLineRunner createDataLocation(LocationRepository repository){
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
////                Location l1 = new Location(u1 ,  LocalDateTime.of(2023,5,3,0,0), 123,334);
////                Location l2 = new Location(u1 ,  LocalDateTime.of(2023,5,3,0,0), 123,334);
////                Location l3 = new Location(u1 ,  LocalDateTime.of(2023,5,3,0,0), 123,334);
////                Location l4 = new Location(u1 ,  LocalDateTime.of(2023,5,3,0,0), 123,334);
////
////                System.out.println("insert data : " + repository.save(l1));
////                System.out.println("insert data : " + repository.save(l2));
////                System.out.println("insert data : " + repository.save(l3));
//             //   System.out.println("insert data : " + repository.save(l4));
//            }
//        };
//    }

}
