package com.guier.configclient;

import com.guier.configclient.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigClientApplication implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Date birthday = DateUtil.localDateTime2date(LocalDateTime.of(LocalDate.of(2019, 2, 1), LocalTime.MIN));
        // userRepository.save(new User().setAge(18).setBirthday(birthday).setName("张三").setAddress("旧金山"));
        // userRepository.save(new User().setAge(23).setBirthday(birthday).setName("张三").setAddress("旧金山"));
        // userRepository.save(new User().setAge(15).setBirthday(birthday).setName("张三").setAddress("旧金山"));
        // userRepository.save(new User().setAge(15).setBirthday(birthday).setName("张三").setAddress("旧金山"));
        // userRepository.save(new User().setAge(15).setBirthday(birthday).setName("张三").setAddress("旧金山"));
        // userRepository.save(new User().setAge(32).setBirthday(birthday).setName("张三").setAddress("旧金山"));
        userRepository.findAll().forEach(System.out::println);
    }

/*    private void callRunners(ApplicationContext context, ApplicationArguments args) {
        List<Object> runners = new ArrayList<>();
        runners.addAll(context.getBeansOfType(ApplicationRunner.class).values());
        runners.addAll(context.getBeansOfType(CommandLineRunner.class).values());
        AnnotationAwareOrderComparator.sort(runners);
        for (Object runner : new LinkedHashSet<>(runners)) {
            if (runner instanceof ApplicationRunner) {
                callRunner((ApplicationRunner) runner, args);
            }
            if (runner instanceof CommandLineRunner) {
                callRunner((CommandLineRunner) runner, args);
            }
        }
    }*/
}
