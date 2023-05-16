package pr12;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.exists;

public class MyBean {
    Scanner scanner = new Scanner(System.in);
    private String filename;
    private String hashname;
    public MyBean() {
        System.out.println("MyBean instance created");
    }

    @PostConstruct
    private void init() throws Exception{
        filename = scanner.nextLine();
        hashname = scanner.nextLine();
        if (exists(Path.of(filename))) {
            String text = "";
            FileReader fileReader = new FileReader(filename);
            FileWriter fileWriter = new FileWriter(hashname);
            Scanner scanner1 = new Scanner(fileReader);
            while (scanner1.hasNextLine()){
                text = scanner1.nextLine();
                fileWriter.write(fileReader.hashCode());
                System.out.println(text);
                System.out.println(text.hashCode());
            }
            fileReader.close();
            fileWriter.flush();
        }
        else{
            FileWriter fileWriter = new FileWriter(hashname);
            String text = "Null";
            fileWriter.write(text);
            fileWriter.flush();
        }
    }

    @PreDestroy
    private void shutdown(){
        File file = new File(filename);
        file.delete();
    }

    public void close(){
        System.out.println("Closing All Resources");
    }
    public static void startWorking() throws Exception{


    }
}
