import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class List extends JFrame
{
    Database db;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JButton okBtn;
    private JButton removeBtn;

    public List()
            throws SQLException
    {
        initComponents();
        getContentPane().setBackground(new Color(95, 158, 160));
        loadNames();
    }

    private void initComponents()
    {
        this.jScrollPane1 = new JScrollPane();
        this.jTable1 = new JTable();
        this.removeBtn = new JButton();
        this.okBtn = new JButton();

        setDefaultCloseOperation(0);
        setTitle("LIST OF PLAYERS");
        setResizable(false);

        this.jTable1.setFont(new Font("Tahoma", 0, 14));
        this.jTable1.setModel(new DefaultTableModel(new Object[0][], new String[] { "Names" })
        {
            Class[] types = { String.class };

            public Class getColumnClass(int columnIndex)
            {
                return this.types[columnIndex];
            }
        });
        this.jTable1.setGridColor(new Color(255, 0, 51));
        this.jTable1.setRowHeight(20);
        this.jScrollPane1.setViewportView(this.jTable1);

        this.removeBtn.setText("Remove");
        this.removeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                List.this.removeBtnActionPerformed(evt);
            }
        });
        this.okBtn.setText("OK");
        this.okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                List.this.okBtnActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout
                        .createSequentialGroup()
                        .addComponent(this.jScrollPane1, -2, -1, -2)
                        .addGap(0, 0, 32767))
                .addGroup(layout
                        .createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(this.removeBtn)
                        .addGap(41, 41, 41)
                        .addComponent(this.okBtn, -2, 79, -2)
                        .addContainerGap(-1, 32767)));

        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout
                        .createSequentialGroup()
                        .addComponent(this.jScrollPane1, -1, 462, 32767)
                        .addGap(18, 18, 18)
                        .addGroup(layout
                                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.removeBtn)
                                .addComponent(this.okBtn))
                        .addGap(36, 36, 36)));

        pack();
    }

    private void removeBtnActionPerformed(ActionEvent evt) {
        try {
            String st = (String)this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0);

            int msg = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove the selected player?", "Comfirm", 0);

            if (msg != 1)
            {
                this.db = new Database();
                db.delete(st);
                loadNames();
            }
        }
        catch (Exception localException) {
        }
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
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new List().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void loadNames()
    {
        db = new Database();
        try {

            DefaultTableModel dt = (DefaultTableModel) this.jTable1.getModel();

            dt.setRowCount(0);



            ResultSet r = this.db.fetch();

            while (r.next())
            {

                Vector<String> v = new Vector<String>();

                v.add(r.getString(1));

                dt.addRow(v);

            }


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
}


