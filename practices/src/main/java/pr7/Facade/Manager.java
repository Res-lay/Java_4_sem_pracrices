package pr7.Facade;

public class Manager {
    void doStuff(boolean bugTracker){
        if(bugTracker){
            System.out.println("Manger is thinking...");
        }else{
            System.out.println("Manager is chilling...");
        }
    }
}
