package pr10;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class app {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Programmer programmer = context.getBean(Junior.class);
        programmer.doCoding();
        programmer = context.getBean(Middle.class);
        programmer.doCoding();
        programmer = context.getBean(Senior.class);
        programmer.doCoding();
    }
}
