package berger.levrault.users;

import berger.levrault.users.Entity.Role;
import berger.levrault.users.Repo.RoleRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaRepositories
@EnableAsync
public class UsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(RoleRepo roleRepo){
        return args -> {
         if (roleRepo.findByName("User").isEmpty()){
             roleRepo.save(
                     Role.builder().name("User")
                             .build()
             );
         }
        };
    }

}
