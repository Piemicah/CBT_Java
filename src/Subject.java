import java.sql.ResultSet;

public class Subject
{
    private String name;
    public Subject(String n)
    {
        name=n;
    }

    public ResultSet load()
    {
        Database db = new Database();
        return db.fetchQuestion(name);
    }
}
