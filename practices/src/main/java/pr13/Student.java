package pr13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@ConfigurationProperties("program")
@Component
public class Student {
    @Value("${program.student.name}")
    private String name;

    @Value("${program.student.last_name}")
    private String last_name;

    @Value("${program.student.group}")
    private String group;

    @PostConstruct
    private void init(){
        System.out.println(name);
        System.out.println(last_name);
        System.out.println(group);
    }
}
