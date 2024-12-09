import javax.swing.*;
import java.sql.ResultSet;

public class Student
{
    private String name;
    private String subject1, subject2, subject3, subject4;
    private int sub1level = 1;
    private int sub2level = 1;
    private int sub3level = 1;
    private int sub4level = 1;
    private int score1 = 0, score2 = 0, score3 = 0, score4 = 0;
    private  Database db;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubjects(String sub1,String sub2,String sub3,String sub4)
    {
        this.subject1 =sub1;
        this.subject2 =sub2;
        this.subject3 =sub3;
        this.subject4 =sub4;
    }

    public String getSubject1() {
        return subject1;
    }

    public String getSubject2() {
        return subject2;
    }

    public String getSubject3() {
        return subject3;
    }

    public String getSubject4() {
        return subject4;
    }

    public int getScore(int flag) {
        if (flag == 1) return this.score1;
        if (flag == 2) return this.score2;
        if (flag == 3) return this.score3;
        return this.score4;
    }

    public void setScore(int score, int flag) {
        if (flag == 1) this.score1 += score;
        else if (flag == 2) this.score2 += score;
        else if (flag == 3) this.score3 += score; else
            this.score4 += score;
    }

    public void setScore(int sc1, int sc2, int sc3, int sc4) {
        this.score1 = sc1;
        this.score2 = sc2;
        this.score3 = sc3;
        this.score4 = sc4;
    }

    public int getLevel(int flag) {
        if (flag == 1) return this.sub1level;
        if (flag == 2) return this.sub2level;
        if (flag == 3) return this.sub3level;
        return this.sub4level;
    }

    public void setLevel(int level, int flag) {
        if (flag == 1) this.sub1level = level;
        else if (flag == 2) this.sub2level = level;
        else if (flag == 3) this.sub3level = level;
        else this.sub4level = level;
    }

    public void setLevel(int l1, int l2, int l3, int l4) {
        this.sub1level = l1;
        this.sub2level = l2;
        this.sub3level = l3;
        this.sub4level = l4;
    }

    public void addStudent() {
        try {
            db = new Database();
            db.insert(name, subject1, subject2, subject3, subject4,
                    score1, score2, score3, score4,
                    sub1level, sub2level, sub3level, sub4level);
        }

        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error  " + ex.getMessage(), "CBT", 0);

        }

        finally
        {
            try
            {
                db.close();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Exception Error:  " + ex.getMessage(),"CBT",0);
            }

        }
    }

    public Student getStudent(String str)
    {
        Student std = new Student();
        try {
            db = new Database();
            ResultSet result = db.selectSingle(str);
            while (result.next()) {
                std.setName(result.getString(1));

                String ss1 = result.getString(2);
                String ss2 = result.getString(3);
                String ss3 = result.getString(4);
                String ss4 = result.getString(5);

                std.setSubjects(ss1, ss2, ss3, ss4);

                int sco1 = result.getInt(6);
                int sco2 = result.getInt(7);
                int sco3 = result.getInt(8);
                int sco4 = result.getInt(9);

                std.setScore(sco1, sco2, sco3, sco4);

                int l1 = result.getInt(10);
                int l2 = result.getInt(11);
                int l3 = result.getInt(12);
                int l4 = result.getInt(13);

                std.setLevel(l1, l2, l3, l4);
            }


        }

        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error  " + ex.getMessage(), "CBT", 0);

        }

        finally
        {
            try
            {
                db.close();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Exception Error:  " + ex.getMessage(),"CBT",0);
            }

        }
        return std;
    }

    public void updateStudent() {
        try {
            db = new Database();
            db.update(name, score1, score2, score3, score4, sub1level, sub2level, sub3level, sub4level);
        }

        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error  " + ex.getMessage(), "CBT", 0);

        }

        finally
        {
            try
            {
                db.close();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Exception Error:  " + ex.getMessage(),"CBT",0);
            }

        }
    }

    public void remove(String str)
    {
        db = new Database();
        db.delete(str);
        db.close();
    }
}
