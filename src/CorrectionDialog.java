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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class CorrectionDialog extends JFrame
{
    private String[] missedQ = new String[20];
    private String[] missedAns = new String[20];
    private int[] missedN = new int[20];
    private JLabel jLabel1;
    private JScrollPane jScrollPane2;
    private JTextArea jTextArea2;
    private JButton okBtn;

    public CorrectionDialog(String[] q, String[] a, int[] n)
    {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage("cbt_logo.png"));
        getContentPane().setBackground(new Color(103, 218, 104));
        missedQ = q;
        missedAns = a;
        missedN = n;
        wrongDialog();
    }

    private CorrectionDialog() {
        throw new UnsupportedOperationException("Not supported yet.");
    }



    private CorrectionDialog(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void wrongDialog() {
        String str = "";
        for (int i = 0; i < 20; i++)
        {
            if (!this.missedAns[i].equals("wrong"))
                str = str + "(" + (1 + this.missedN[i]) + ") " + this.missedQ[i] + "\nAns: " + this.missedAns[i] + "\n\n";
        }
        jTextArea2.setText(str);
    }

    private void initComponents()
    {
        jScrollPane2 = new JScrollPane();
        jTextArea2 = new JTextArea();
        okBtn = new JButton();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(0);
        setAlwaysOnTop(true);
        setResizable(false);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new Font("Monospaced", 0, 16));
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(this.jTextArea2);

        okBtn.setText("Ok");
        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                CorrectionDialog.this.okBtnActionPerformed(evt);
            }
        });
        jLabel1.setFont(new Font("Tahoma", 1, 18));
        jLabel1.setText("MISSED ANSWERS");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout
                        .createSequentialGroup()
                        .addContainerGap(74, 32767)
                        .addGroup(layout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout
                                        .createSequentialGroup()
                                        .addComponent(this.okBtn, -2, 88, -2)
                                        .addGap(497, 497, 497))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout
                                        .createSequentialGroup()
                                        .addComponent(this.jScrollPane2, -2, 982, -2)
                                        .addGap(52, 52, 52))))
                .addGroup(layout
                        .createSequentialGroup()
                        .addGap(466, 466, 466)
                        .addComponent(this.jLabel1)
                        .addGap(0, 0, 32767)));

        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout
                        .createSequentialGroup()
                        .addContainerGap(21, 32767)
                        .addComponent(this.jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(this.jScrollPane2, -2, 489, -2)
                        .addGap(18, 18, 18)
                        .addComponent(this.okBtn)
                        .addGap(19, 19, 19)));

        pack();
    }

    private void okBtnActionPerformed(ActionEvent evt) {
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
            Logger.getLogger(CorrectionDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CorrectionDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CorrectionDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CorrectionDialog.class.getName()).log(Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CorrectionDialog(null).setVisible(true);
            }
        });
    }
}

