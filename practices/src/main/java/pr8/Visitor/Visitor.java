package pr8.Visitor;

public interface Visitor {
    void create(ProjectClass projectClass);
    void create(Database database);
    void create(Test test);
}
