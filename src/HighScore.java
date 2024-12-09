import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class HighScore extends JFrame
{
    private String[] names = new String[5];
    private int[] scores = new int[5];
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JLabel name1;
    private JLabel name2;
    private JLabel name3;
    private JLabel name4;
    private JLabel name5;
    private JLabel score1;
    private JLabel score2;
    private JLabel score3;
    private JLabel score4;
    private JLabel score5;

    public HighScore(String[] n, int[] s)
    {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage("cbt_logo.png"));
        getContentPane().setBackground(Color.PINK);
        this.names = n;
        this.scores = s;
        display();
    }

    private HighScore() { }



    private HighScore(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void display() {
        this.name1.setText(this.names[0]); this.score1.setText("" + this.scores[0]);
        this.name2.setText(this.names[1]); this.score2.setText("" + this.scores[1]);
        this.name3.setText(this.names[2]); this.score3.setText("" + this.scores[2]);
        this.name4.setText(this.names[3]); this.score4.setText("" + this.scores[3]);
        this.name5.setText(this.names[4]); this.score5.setText("" + this.scores[4]);
    }

    private void initComponents()
    {
        jButton1 = new JButton();
        jPanel1 = new JPanel();
        score3 = new JLabel();
        name4 = new JLabel();
        score4 = new JLabel();
        name5 = new JLabel();
        score5 = new JLabel();
        name1 = new JLabel();
        score1 = new JLabel();
        name2 = new JLabel();
        score2 = new JLabel();
        name3 = new JLabel();
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(0);
        setTitle("High Scores");
        setResizable(false);

        jButton1.setFont(new Font("Tahoma", 0, 18));
        jButton1.setText("OK");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                HighScore.this.jButton1ActionPerformed(evt);
            }
        });
        jPanel1.setBackground(new Color(0, 0, 255));

        score3.setFont(new Font("Tahoma", 1, 14));
        score3.setForeground(new Color(255, 255, 0));
        score3.setHorizontalAlignment(2);
        score3.setText("score3");

        name4.setFont(new Font("Tahoma", 1, 14));
        name4.setForeground(new Color(255, 255, 0));
        name4.setHorizontalAlignment(2);
        name4.setText("name4");

        score4.setFont(new Font("Tahoma", 1, 14));
        score4.setForeground(new Color(255, 255, 0));
        score4.setHorizontalAlignment(2);
        score4.setText("score4");

        name5.setFont(new Font("Tahoma", 1, 14));
        name5.setForeground(new Color(255, 255, 0));
        name5.setHorizontalAlignment(2);
        name5.setText("name5");

        score5.setFont(new Font("Tahoma", 1, 14));
        score5.setForeground(new Color(255, 255, 0));
        score5.setHorizontalAlignment(2);
        score5.setText("score5");

        name1.setFont(new Font("Tahoma", 1, 14));
        name1.setForeground(new Color(255, 255, 0));
        name1.setHorizontalAlignment(2);
        name1.setText("namel1");

        score1.setFont(new Font("Tahoma", 1, 14));
        score1.setForeground(new Color(255, 255, 0));
        score1.setHorizontalAlignment(2);
        score1.setText("score1");

        name2.setFont(new Font("Tahoma", 1, 14));
        name2.setForeground(new Color(255, 255, 0));
        name2.setHorizontalAlignment(2);
        name2.setText("name2");

        score2.setFont(new Font("Tahoma", 1, 14));
        score2.setForeground(new Color(255, 255, 0));
        score2.setHorizontalAlignment(2);
        score2.setText("score2");

        name3.setFont(new Font("Tahoma", 1, 14));
        name3.setForeground(new Color(255, 255, 0));
        name3.setHorizontalAlignment(2);
        name3.setText("name3");

        jPanel2.setBackground(new Color(0, 153, 0));

        jLabel1.setFont(new Font("Tahoma", 1, 14));
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Name");

        jLabel2.setFont(new Font("Tahoma", 1, 14));
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("Score");

        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout
                        .createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(this.jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                        .addComponent(this.jLabel2)
                        .addGap(104, 104, 104)));

        jPanel2Layout.setVerticalGroup(jPanel2Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout
                        .createSequentialGroup()
                        .addContainerGap(60, 32767)
                        .addGroup(jPanel2Layout
                                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jLabel1)
                                .addComponent(this.jLabel2))
                        .addGap(28, 28, 28)));

        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.jPanel2, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
                .addGroup(jPanel1Layout
                        .createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(jPanel1Layout
                                .createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout
                                        .createSequentialGroup()
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(this.name2)
                                                .addComponent(this.name3)
                                                .addComponent(this.name4)
                                                .addComponent(this.name5))
                                        .addGap(118, 118, 118)
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(this.score2)
                                                .addComponent(this.score3)
                                                .addComponent(this.score4)
                                                .addComponent(this.score5)))
                                .addGroup(jPanel1Layout
                                        .createSequentialGroup()
                                        .addComponent(this.name1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                                        .addComponent(this.score1)))
                        .addContainerGap(101, 32767)));

        jPanel1Layout.setVerticalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout
                        .createSequentialGroup()
                        .addComponent(this.jPanel2, -2, -1, -2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout
                                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.name1)
                                .addComponent(this.score1))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout
                                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.name2)
                                .addComponent(this.score2))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout
                                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.name3)
                                .addComponent(this.score3))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout
                                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.name4)
                                .addComponent(this.score4))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout
                                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.name5)
                                .addComponent(this.score5))
                        .addContainerGap(99, 32767)));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout
                        .createSequentialGroup()
                        .addContainerGap(226, 32767)
                        .addGroup(layout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout
                                        .createSequentialGroup()
                                        .addComponent(this.jPanel1, -2, -1, -2)
                                        .addGap(181, 181, 181))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout
                                        .createSequentialGroup()
                                        .addComponent(this.jButton1, -2, 136, -2)
                                        .addGap(325, 325, 325)))));

        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout
                        .createSequentialGroup()
                        .addContainerGap(25, 32767)
                        .addComponent(this.jPanel1, -2, -1, -2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(this.jButton1)
                        .addGap(24, 24, 24)));

        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        setVisible(false);
    }

    public static void main(String[] args)
    {
        try
        {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(HighScore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(HighScore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(HighScore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(HighScore.class.getName()).log(Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HighScore(null).setVisible(true);
            }
        });
    }
}
