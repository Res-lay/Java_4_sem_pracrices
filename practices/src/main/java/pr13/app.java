package pr13;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class app {
    public static void main(String[] args) {
        System.out.println(args);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(StudentConfiguration.class);
        ctx.refresh();

        Student student = ctx.getBean(Student.class);

        ctx.close();
    }
}
