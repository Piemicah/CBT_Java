import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener
{
    Database db;
    private String name;
    private JPanel leftPanel, mainPanel,p1,p2,p3,p4,p5;
    private JPanel rightPanel,p6,p7;
    private JTextField newField,existField;
    private JComboBox<String> combo1,combo2,combo3;
    private JButton btnNew,btnExist;
    private String[] subjects = {"Account","Biology","Chemistry","Economics",
            "Government","Mathematics","Physics"};
    private Color color = new Color(0x21A563);
    private Font font = new Font("Serif",Font.BOLD,12);

    private String subject1, subject2, subject3, subject4;
    private Details details;
    private JLabel logoLabel;

    // Menu
    JMenu fileMenu,helpMenu;
    JMenuItem aboutMenuItem,hiScoreMenuItem,listMenuItem,exitMenuItem;
    JMenuBar menuBar;

    public Login()
    {
        init();

    }

    public void setSubject1() {
        this.subject1 = "english";
    }

    public void setSubject2() {
        this.subject2 = combo1.getSelectedItem().toString();
    }

    public void setSubject3() {
        this.subject3 = combo2.getSelectedItem().toString();
    }

    public void setSubject4() {
        this.subject4 = combo3.getSelectedItem().toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnNew)
        {
            setSubject1();
            setSubject2();
            setSubject3();
            setSubject4();
            name = newField.getText();

            try{
                db = new Database();

                ResultSet dataResult = db.fetch();
                while(dataResult.next())
                {
                    if (this.name.toUpperCase().trim().equals(dataResult.getString(1).toUpperCase()))
                    {
                        JOptionPane.showMessageDialog(null, this.name + " already exist. Try again");
                        return;
                    }
                }
                //db.close();
            }

            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Fetch Page", 0);
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

            if(subject2==subject3||subject2==subject4||subject3==subject4)
            {
                JOptionPane.showMessageDialog(null, "A subject must not be selected more than once");
            }
            else
            {
                if(name.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "You must enter a name");
                    return;
                }

                Student student = new Student();
                student.setName(name);
                student.setSubjects(subject1,subject2,subject3,subject4);
                student.addStudent();
                loadPage();
            }

        }
        // Existing User Section
        else if(e.getSource()==btnExist)
        {
            boolean found = false;
            name = existField.getText();
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null, "You must enter at least a character");
                return;
            }

            try{

                db = new Database();
                ResultSet r = db.fetch();
                while(r.next())
                {
                    if (name.trim().equalsIgnoreCase(r.getString(1)))
                    {
                        found = true;
                        name = r.getString(1);
                        break;
                    }

                    found =false;
                }

                if(!found)
                {
                    JOptionPane.showMessageDialog(null, "Wrong user ID. Try again");
                }
                else
                {
                    Student student = new Student().getStudent(name);
                    subject1 = student.getSubject1();
                    subject2 = student.getSubject2();
                    subject3 = student.getSubject3();
                    subject4 = student.getSubject4();
                    loadPage();

                }
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Fetch Page", 0);
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
        else if(e.getSource()==listMenuItem)
        {
            try
            {
                List list = new List();
                list.setVisible(true);
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Fetch Page", 0);
            }

        }

        else if(e.getSource()==hiScoreMenuItem)
        {
            try
            {
                String str = "SELECT name, (s1+s2+s3+s4) AS total FROM details ORDER BY total desc LIMIT 5";
                db = new Database();
                ResultSet r =db.getHiScore(str);
                String[] names = new String[5];
                int[] scores = new int[5];
                int i = 0;
                while ((i < 5) && (r.next()))
                {
                    names[i] = r.getString(1);
                    scores[i] = r.getInt(2);
                    i++;
                }

                HighScore hs = new HighScore(names, scores);
                hs.setVisible(true);
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Exception Error:  " + ex.getMessage(),"CBT",0);
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

        else if(e.getSource()==exitMenuItem)
        {
            closing();
        }
        else if(e.getSource()==aboutMenuItem)
        {
            JOptionPane.showMessageDialog(Login.this, "CBT Game by Segun Adeyemi\nPiemicah Institutes(piemicah@yahoo.com)\n+2347030829634", "CBT GAME", -1);
        }
        else
        {

        }
    }

    private void closing()
    {
        int msg = JOptionPane.showConfirmDialog(Login.this, "Are you sure you want to quit?", "Comfirm", 0);
        if (msg == 0) System.exit(0);
        //else return;
    }
    private class CloseHandler extends WindowAdapter
    {
        @Override
        public void windowClosing(WindowEvent evt) {
            //super.windowClosing(evt);
            closing();
        }
    }
    private void loadPage()
    {
        Booklet booklet = new Booklet(name);
        Papers paper1,paper2,paper3,paper4;

        // set paper1
        paper1 = new Papers();
        paper1.setFlag(1);
        paper1.setUsername(name);
        paper1.setSubject(subject1);

        // set paper2
        paper2 = new Papers();
        paper2.setFlag(2);
        paper2.setUsername(name);
        paper2.setSubject(subject2);

        // set paper3
        paper3 = new Papers();
        paper3.setFlag(3);
        paper3.setUsername(name);
        paper3.setSubject(subject3);

        // set paper4
        paper4 = new Papers();
        paper4.setFlag(4);
        paper4.setUsername(name);
        paper4.setSubject(subject4);

        // add details
        try {
            details = new Details(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // Add papers to booklet
        booklet.paperTab.addTab(subject1,paper1);
        booklet.paperTab.addTab(subject2,paper2);
        booklet.paperTab.addTab(subject3,paper3);
        booklet.paperTab.addTab(subject4,paper4);
        booklet.paperTab.addTab("Details",details);
        booklet.setVisible(true);
        setVisible(false);

    }

    public void init()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage("media\\images\\cbt_logo.png"));
        setTitle("CBT Game");
        setSize(550,500);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        leftPanel = new JPanel(new GridLayout(0,1,5,5));
        rightPanel = new JPanel(new GridLayout(0,1));
        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,50,20));
        p1 = new JPanel(new FlowLayout());
        p2 = new JPanel(new FlowLayout());
        p3 = new JPanel(new FlowLayout());
        p4 = new JPanel(new FlowLayout());
        p5 = new JPanel(new FlowLayout());
        p6 = new JPanel(new FlowLayout());
        p7= new JPanel(new FlowLayout());
        TitledBorder tb = new TitledBorder("New User");
        tb.setTitleColor(new Color(180, 10, 20));
        tb.setTitleFont(font);
        leftPanel.setBorder(tb);
        rightPanel.setBorder(new TitledBorder("Existing User"));
        newField = new JTextField(8);
        existField=new JTextField(8);
        btnExist = new JButton("OK");
        btnExist.addActionListener(this);
        btnNew = new JButton("OK");
        btnNew.addActionListener(this);
        combo1 = new JComboBox<String>(subjects);
        combo2 = new JComboBox<String>(subjects);
        combo3 = new JComboBox<String>(subjects);
        p1.add(new JLabel("Subject1"));
        p1.add(combo1);
        p2.add(new JLabel("Subject2"));
        p2.add(combo2);
        p3.add(new JLabel("Subject3"));
        p3.add(combo3);
        p4.add(new JLabel("Create ID"));
        p4.add(newField);
        p5.add(btnNew);
        leftPanel.add(p1);
        leftPanel.add(p2);
        leftPanel.add(p3);
        leftPanel.add(p4);
        leftPanel.add(p5);
        p6.add(new JLabel("User ID"));
        p6.add(existField);
        p7.add(btnExist);
        rightPanel.add(p6);
        rightPanel.add(p7);
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        logoLabel = new JLabel("Copyright@ Segun Adeyemi (piemicah@yahoo.com) 07030829634");
        logoLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        logoLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        Icon img = new ImageIcon("media\\images\\logo.png");
        logoLabel.setIcon(img);
        JPanel p = new JPanel();
        p.setBackground(color);
        p.add(logoLabel);
        add(mainPanel,BorderLayout.CENTER);
        add(p,BorderLayout.SOUTH);

        // Menu
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        listMenuItem = new JMenuItem("View List of Players");
        listMenuItem.addActionListener(this);
        hiScoreMenuItem = new JMenuItem("High Scores");
        hiScoreMenuItem.addActionListener(this);
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);
        fileMenu.add(listMenuItem);
        fileMenu.add(hiScoreMenuItem);
        fileMenu.add(exitMenuItem);

        helpMenu = new JMenu("Help");
        aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(this);
        helpMenu.add(aboutMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
        addWindowListener(new CloseHandler());

        //add(rightPanel,BorderLayout.EAST);
        setColor();
    }
    private void setColor()
    {
        mainPanel.setBackground(color);
        rightPanel.setBackground(color);
        leftPanel.setBackground(color);
        p1.setBackground(color);
        p2.setBackground(color);
        p3.setBackground(color);
        p4.setBackground(color);
        p5.setBackground(color);
        p6.setBackground(color);
        p7.setBackground(color);
    }
    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
    }
}
