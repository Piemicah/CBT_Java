import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class Details extends JPanel
{
    private ResultSet r;
    Student student;
    private String name;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JButton refreshButton;
    private JLabel sub1Label;
    private JLabel sub1LevelLabel;
    private JLabel sub1ScoreLabel;
    private JLabel sub2Label;
    private JLabel sub2LevelLabel;
    private JLabel sub2ScoreLabel;
    private JLabel sub3Label;
    private JLabel sub3LevelLabel;
    private JLabel sub3ScoreLabel;
    private JLabel sub4Label;
    private JLabel sub4LevelLabel;
    private JLabel sub4ScoreLabel;

    public Details(String name)  throws SQLException
    {
        initComponents();
        this.name = name;
        showDetails();
    }

    public void showDetails() throws SQLException
    {
        student = new Student().getStudent(this.name);
        sub1Label.setText(this.student.getSubject1());
        sub2Label.setText(this.student.getSubject2());
        sub3Label.setText(this.student.getSubject3());
        sub4Label.setText(this.student.getSubject4());
        sub1LevelLabel.setText("" + this.student.getLevel(1));
        sub2LevelLabel.setText("" + this.student.getLevel(2));
        sub3LevelLabel.setText("" + this.student.getLevel(3));
        sub4LevelLabel.setText("" + this.student.getLevel(4));
        sub1ScoreLabel.setText("" + this.student.getScore(1));
        sub2ScoreLabel.setText("" + this.student.getScore(2));
        sub3ScoreLabel.setText("" + this.student.getScore(3));
        sub4ScoreLabel.setText("" + this.student.getScore(4));
    }

    private void initComponents()
    {
        jPanel2 = new JPanel();
        sub1Label = new JLabel();
        sub2Label = new JLabel();
        sub3Label = new JLabel();
        sub4Label = new JLabel();
        jPanel3 = new JPanel();
        sub1LevelLabel = new JLabel();
        sub1ScoreLabel = new JLabel();
        sub2ScoreLabel = new JLabel();
        sub2LevelLabel = new JLabel();
        sub3LevelLabel = new JLabel();
        sub3ScoreLabel = new JLabel();
        sub4LevelLabel = new JLabel();
        sub4ScoreLabel = new JLabel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        refreshButton = new JButton();

        setBackground(new Color(233, 171, 255));
        addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        jPanel2.setBackground(new Color(233, 171, 255));

        sub1Label.setText("sub1");

        sub2Label.setText("sub2");

        sub3Label.setText("sub3");

        sub4Label.setText("sub4");

        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout
                        .createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(this.sub1Label)
                                .addComponent(this.sub2Label)
                                .addComponent(this.sub4Label)
                                .addComponent(this.sub3Label))
                        .addContainerGap(156, 32767)));

        jPanel2Layout.setVerticalGroup(jPanel2Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout
                        .createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(this.sub1Label)
                        .addGap(32, 32, 32)
                        .addComponent(this.sub2Label)
                        .addGap(29, 29, 29)
                        .addComponent(this.sub3Label)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, 32767)
                        .addComponent(this.sub4Label)
                        .addContainerGap()));

        jPanel3.setBackground(new Color(233, 171, 255));

        sub1LevelLabel.setText("jLabel3");

        sub1ScoreLabel.setText("jLabel4");

        sub2ScoreLabel.setText("jLabel6");

        sub2LevelLabel.setText("jLabel5");

        sub3LevelLabel.setText("jLabel7");

        sub3ScoreLabel.setText("jLabel8");

        sub4LevelLabel.setText("jLabel9");

        sub4ScoreLabel.setText("jLabel10");

        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout
                        .createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(this.sub4LevelLabel)
                                .addComponent(this.sub3LevelLabel, GroupLayout.Alignment.TRAILING)
                                .addComponent(this.sub2LevelLabel, GroupLayout.Alignment.TRAILING)
                                .addComponent(this.sub1LevelLabel, GroupLayout.Alignment.TRAILING))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel3Layout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(this.sub1ScoreLabel)
                                .addComponent(this.sub2ScoreLabel)
                                .addComponent(this.sub3ScoreLabel)
                                .addComponent(this.sub4ScoreLabel))
                        .addContainerGap(13, 32767)));

        jPanel3Layout.setVerticalGroup(jPanel3Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout
                        .createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout
                                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.sub1LevelLabel)
                                .addComponent(this.sub1ScoreLabel))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout
                                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.sub2LevelLabel)
                                .addComponent(this.sub2ScoreLabel))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout
                                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.sub3LevelLabel)
                                .addComponent(this.sub3ScoreLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, 32767)
                        .addGroup(jPanel3Layout
                                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.sub4LevelLabel)
                                .addComponent(this.sub4ScoreLabel))
                        .addContainerGap()));

        this.jLabel1.setText("Level");

        this.jLabel2.setText("Score");

        this.refreshButton.setText("Refresh");
        this.refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Details.this.refreshButtonActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout
                        .createSequentialGroup()
                        .addGroup(layout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout
                                        .createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(this.jPanel2, -2, -1, -2)
                                        .addGap(93, 93, 93)
                                        .addComponent(this.jPanel3, -2, -1, -2))
                                .addGroup(layout
                                        .createSequentialGroup()
                                        .addGap(346, 346, 346)
                                        .addComponent(this.jLabel1)
                                        .addGap(74, 74, 74)
                                        .addComponent(this.jLabel2))
                                .addGroup(layout
                                        .createSequentialGroup()
                                        .addGap(106, 106, 106)
                                        .addComponent(this.refreshButton)))
                        .addContainerGap(339, 32767)));

        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout
                        .createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(refreshButton)
                        .addGap(18, 18, 18)
                        .addGroup(layout
                                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(this.jPanel2, -2, -1, -2)
                                .addComponent(this.jPanel3, -2, -1, -2))
                        .addContainerGap(80, 32767)));
    }

    private void refreshButtonActionPerformed(ActionEvent evt)
    {
        try
        {
            showDetails();
        } catch (SQLException ex) {
            Logger.getLogger(Details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void formFocusGained(FocusEvent evt) {
        try {
            showDetails();
        } catch (SQLException ex) {
            Logger.getLogger(Details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
