import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Booklet extends JFrame
{
    JTabbedPane paperTab;
    public Booklet(String str)
    {
        super("Welcome " + str);
        init();
        getContentPane().setBackground(new Color(233, 171, 255));

    }

    private void init()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width = dim.width;
        int height = dim.height;
        setSize(width, height);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("media\\images\\cbt_logo.png"));
        paperTab = new JTabbedPane();
        add(paperTab);
        addWindowListener(new CloseHandler());
    }

    private class CloseHandler extends WindowAdapter
    {
        @Override
        public void windowClosing(WindowEvent evt) {
            super.windowClosing(evt);
            int msg = JOptionPane.showConfirmDialog(Booklet.this, "Are you sure you want to quit?", "Comfirm", 0);
            if (msg == 0)
            {
                setVisible(false);
                Login login = new Login();
                login.setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        Booklet booklet = new Booklet("");
        booklet.setVisible(true);
    }
}
