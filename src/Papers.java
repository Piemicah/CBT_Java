import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Segun
 */
public class Papers extends JPanel implements ActionListener {

    private String subject;
    private String username;
    private int flag;
    private ResultSet r;
    private Student student;

    private int num;
    int t=600;
    Timer timer;
    long time1;
    long time2;
    String reward;
    String startText;
    int buttonCount=0;
    String directory = "";
    private String[] missedQ = new String[20];
    private String[] missedAns = new String[20];
    private int[] missedN = new int[20];
    private String[] questionArray = new String[200];
    private String[] optionA = new String[200];
    private String[] optionB = new String[200];
    private String[] optionC = new String[200];
    private String[] optionD = new String[200];
    private String[] optionAns = new String[200];
    private String[] optionImage = new String[200];
    ButtonModel[] bt;
    int score = 0;
    int level = 1;
    int hiscore = 0;
    int[] ans;
    private Color color = new Color(233, 171, 255);
    public Papers() {
        initComponents();
        setBackground(color);
        qPanel.setBackground(color);
        buttonPanel.setBackground(color);
        panel2.setBackground(color);
        panel3.setBackground(color);
        panel4.setBackground(color);
        panel5.setBackground(color);
        a.setBackground(color);
        b.setBackground(color);
        c.setBackground(color);
        d.setBackground(color);
        num=0;
        qPanel.setVisible(false);
        ans = new int[20];
        for (int i = 0; i < this.ans.length; i++) ans[i] = 0;
        bt = new ButtonModel[21];
        for (int i = 0; i < this.bt.length; i++) this.bt[i] = null;
        buttonPanel.setVisible(false);
        timeLabel.setVisible(false);
        rewardLabel.setVisible(false);
        levelLabel.setVisible(false);
        imageLabel.setVisible(false);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    private void initComponents() {
        //setBackground(new Color(233, 171, 255));
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        panel2 = new JPanel();
        buttonPanel = new JPanel();
        prevButton = new JButton();
        prevButton.addActionListener(this);
        nextButton = new JButton();
        nextButton.addActionListener(this);
        panel3 = new JPanel();
        levelLabel = new JLabel();
        timeLabel = new JLabel();
        qPanel = new JPanel();
        panel4 = new JPanel();
        numLabel = new JLabel();
        q = new JLabel();
        panel5 = new JPanel();
        a = new JRadioButton();
        b = new JRadioButton();
        c = new JRadioButton();
        d = new JRadioButton();
        buttonGroup = new ButtonGroup();
        buttonGroup.add(a);
        buttonGroup.add(b);
        buttonGroup.add(c);
        buttonGroup.add(d);
        imageLabel = new JLabel();
        rewardLabel = new JLabel();

        //======== this ========

        //======== panel2 ========
        {
            panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 60, 10));

            //======== buttonPanel ========
            {
                buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

                //---- prevButton ----
                prevButton.setText("<<Prev");
                buttonPanel.add(prevButton);

                //---- nextButton ----
                nextButton.setText("Next>>");
                buttonPanel.add(nextButton);
            }
            panel2.add(buttonPanel);

            //======== panel3 ========
            {
                panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));

                //---- levelLabel ----
                levelLabel.setText("Level: ");
                panel3.add(levelLabel);

                //---- timeLabel ----
                timeLabel.setText("Time");
                panel3.add(timeLabel);
            }
            panel2.add(panel3);
            panel2.add(startButton);
        }

        //======== qPanel ========
        {
            qPanel.setLayout(new GridLayout(2, 1, 20, 0));

            //======== panel4 ========
            {
                panel4.setLayout(new GridLayout(2, 1));

                //---- numLabel ----
                numLabel.setText("num");
                numLabel.setHorizontalAlignment(SwingConstants.CENTER);
                panel4.add(numLabel);

                //---- q ----
                q.setText("q");
                q.setHorizontalAlignment(SwingConstants.CENTER);
                panel4.add(q);
            }
            qPanel.add(panel4);

            //======== panel5 ========
            {
                panel5.setLayout(new GridLayout(4, 1));
                panel5.add(a);
                panel5.add(b);
                panel5.add(c);
                panel5.add(d);
            }
            qPanel.add(panel5);
        }


        //---- rewardLabel ----
        rewardLabel.setText("rewardImageLabel");
        rewardLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        rewardLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 745, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addGroup(layout.createParallelGroup()
                                                        .addComponent(qPanel, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(imageLabel)
                                                                .addGap(450, 450, 450)
                                                                .addComponent(rewardLabel)))))
                                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(qPanel, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(imageLabel))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(rewardLabel)))
                                .addGap(80, 80, 80))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    private JButton startButton;
    private JPanel panel2;
    private JPanel buttonPanel;
    private JButton prevButton;
    private JButton nextButton;
    private JPanel panel3;
    private JLabel levelLabel;
    private JLabel timeLabel;
    private JPanel qPanel;
    private JPanel panel4;
    private JLabel numLabel;
    private JLabel q;
    private JPanel panel5;
    private JRadioButton a;
    private JRadioButton b;
    private JRadioButton c;
    private JRadioButton d;
    private JLabel imageLabel;
    private JLabel rewardLabel;
    private ButtonGroup buttonGroup;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startButton)
        {
            buttonCount=0;
            student = new Student().getStudent(username);
            level = student.getLevel(this.flag);
            levelLabel.setText("Level: " + level);
            levelLabel.setVisible(true);
            Subject sub = new Subject(subject);
            r=sub.load();
            copyToArray();
            for (int i = 0; i < 20; i++)
            {
                missedQ[i] = questionArray[i];
                missedAns[i] = optionAns[i];
                missedN[i] = i;
            }
            time1 = System.currentTimeMillis();
            if (level == 1) num = 0;
            else if (level == 2) num = 20;
            else if (level == 3) num = 40;
            else if (level == 4) num = 60;
            else if (level == 5) num = 80;
            else if (level == 6) num = 100;
            else if (level == 7) num = 120;
            else if (level == 8) num = 140;
            else if (level == 9) num = 160;
            else if (level == 10) num = 180;
            displayQuestion();
            nextButton.setText("Next >>");
            buttonPanel.setVisible(true);
            timeLabel.setVisible(true);
            rewardLabel.setVisible(false);
            levelLabel.setVisible(true);
            qPanel.setVisible(true);
            imageLabel.setVisible(true);
            startButton.setVisible(false);
            prevButton.setVisible(false);
            numLabel.setText("" + (buttonCount + 1));
            refresh();
            countDown();

        }
        else if(e.getSource()==nextButton)
        {
            timeLabel.setVisible(true);
            String st = optionAns[num].trim();
            prevButton.setVisible(true);
            if (((a.isSelected()) && (a.getText().equals(st))) || ((b.isSelected()) && (b.getText().equals(st))) ||
                    ((c.isSelected()) && (c.getText().equals(st))) || ((d.isSelected()) && (d.getText().equals(st))))
            {
                missedQ[buttonCount] = questionArray[num];
                missedAns[buttonCount] = "wrong";
                missedN[buttonCount] = buttonCount;
                ans[buttonCount] = 5;
            }
            else
            {
                missedQ[buttonCount] = questionArray[num];
                missedAns[buttonCount] = st;
                missedN[buttonCount] = buttonCount;
                ans[buttonCount] = 0;
            }
            bt[buttonCount] = buttonGroup.getSelection();
            num++;
            buttonCount++;
            numLabel.setText("" + (buttonCount + 1));
            buttonGroup.clearSelection();
            buttonGroup.setSelected(bt[buttonCount], true);
            displayQuestion();
            if (buttonCount == 19) nextButton.setText("Finish");
            if (buttonCount == 20) {
                time2 = System.currentTimeMillis();
                qPanel.setVisible(false);
                buttonPanel.setVisible(false);
                imageLabel.setVisible(false);
                timer.stop();
                showTime();
                analyse();
            }
        }
        else if(e.getSource()==prevButton)
        {
            nextButton.setText("Next >>");

            num -= 1;
            bt[buttonCount] = buttonGroup.getSelection();
            buttonCount -= 1;
            numLabel.setText("" + (buttonCount + 1));
            buttonGroup.clearSelection();
            buttonGroup.setSelected(bt[buttonCount], true);
            displayQuestion();
            if (buttonCount == 0) prevButton.setVisible(false);
        }
        else
        {

        }
    }

    private void showTime() {

        long tsec = (this.time2 - this.time1) / 1000L;
        String time;

        if (tsec >= 60L) {
            long tmin = tsec / 60L;

            time = tmin + " min. " + (tsec - tmin * 60L) + " sec";
        }
        else {
            time = tsec + " s";
        }
        String tt = "You spent " + time;
        timeLabel.setText(tt);
        timeLabel.setVisible(true);
    }

    private void countDown() {

        this.timer = new Timer(1000, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String time;

                if (t >= 60) {
                    int tmin = t / 60;

                    time = tmin + " min.  " + (t - tmin * 60) + " s";
                }
                else {
                    time = t + " s";
                }
                String st = time + " remaining";
                timeLabel.setText(st); t -= 1;

                //change the color of time when time is less than 5 minutes
                if(t<300) timeLabel.setForeground(new Color(189, 4, 4));

                if (t == 0)
                {
                    qPanel.setVisible(false);
                    imageLabel.setVisible(false);
                    timeLabel.setText("Stopped");

                    analyse();
                }
            }
        });
        timer.start(); this.t = 600;
    }

    private void analyse() {

        Sounds ps = new Sounds();
        if (this.timer.isRunning()) this.timer.stop();

        for (int i = 0; i < ans.length; i++)  score += ans[i];
        if(score<50 && level==1) ;
        else if(score>=50 && level==1) {level+=1; student.setScore(score, flag);}
        else if(score<50 && level==2);
        else if(score>=50 && level==2){level+=1;student.setScore(score, flag);}
        else if(score<50 && level==3);
        else if(score>=50 && level==3) {level+=1;student.setScore(score, flag);}
        else if(score<50 && level==4) ;
        else if(score>=50 && level==4) {level+=1;student.setScore(score, flag);}
        else if(score<50 && level==5) ;
        else if(score>=50 && level==5) {level+=1;student.setScore(score, flag);}
        else if(score<50 && level==6);
        else if(score>=50 && level==6){level+=1;student.setScore(score, flag);}
        else if(score<50 && level==7);
        else if(score>=50 && level==7){level+=1;student.setScore(score, flag);}
        else if(score<50 && level==8);
        else if(score>=50 && level==8){level+=1;student.setScore(score, flag);}
        else if(score<50 && level==9);
        else if(score>=50 && level==9){level+=1;student.setScore(score, flag);}
        else if(score<50 && level==10);
        else level=1;
        student.setLevel(this.level, this.flag);

        student.updateStudent();
        Icon img;
        String imgDir="media\\images\\";
        String audDir = "media\\audio\\";
        if (this.score < 50) {
            reward = "too poor! You received no reward";
            startText = "Start again";
            img = new ImageIcon(imgDir+"skull.png");
            ps.setAudio(audDir+"boo2.wav");
            ps.play();
        }
        else if ((this.score >= 50) && (this.score <= 60)) {
            reward = "u need more practice. You received a Pen";
            startText = "Next Level";
            img = new ImageIcon(imgDir+"biro.png");
            ps.setAudio(audDir+"crowdApplaud.wav");
            ps.play();
        }
        else if ((this.score > 60) && (this.score <= 70)) {
            reward = "there is room for improvement. You received a box of jewelries";
            startText = "Next Level";
            img = new ImageIcon(imgDir+"jewel.png");
            ps.setAudio(audDir+"claps.wav");
            ps.play();
        }
        else {
            reward = "Excellent!!! u ar ready for the exam. You lift a trophy";
            startText = "Next Level";
            img = new ImageIcon(imgDir+"trophy.png");
            ps.setAudio(audDir+"claps2.wav");
            ps.play();
        }
        rewardLabel.setText(reward);
        rewardLabel.setIcon(img);
        rewardLabel.setVisible(true);
        JOptionPane.showMessageDialog(null, username + ",U scored " + this.score + "%");
        ps.stop();
        CorrectionDialog cd = new CorrectionDialog(this.missedQ, this.missedAns, this.missedN);
        cd.setVisible(true);
        startButton.setText(this.startText);
        startButton.setVisible(true);
    }

    private void refresh() {
        buttonGroup.clearSelection();
        for (int i = 0; i < ans.length; i++) ans[i] = 0;
        for (int i = 0; i < this.bt.length; i++) bt[i] = null;
        buttonCount = 0;
        score = 0;
    }

    private void copyToArray() {

        try{
            int i=0;
            while(r.next())
            {
                questionArray[i] = r.getString(2);
                optionA[i] = r.getString(3);
                optionB[i] = r.getString(4);
                optionC[i] = r.getString(5);
                optionD[i] = r.getString(6);
                optionAns[i] = r.getString(7);
                optionImage[i] = r.getString(8);
                i++;

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
                r.close();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Exception Error:  " + ex.getMessage(),"CBT",0);
            }

        }

    }

    private void displayQuestion() {

        String str = "<html>" + questionArray[num] + "</html>";
        q.setPreferredSize(new Dimension(1000, 1));
        q.setText(str);
        a.setText(optionA[num]);
        b.setText(optionB[num]);
        c.setText(optionC[num]);
        d.setText(optionD[num]);
        loadImage(optionImage[num]);
    }

    private void loadImage(String img) {
        if (img.equals("noimage")) {
            imageLabel.setIcon(null);
        }
        else {
            directory = "media\\images\\" + subject + "\\" + img + ".png";
            Icon image = new ImageIcon(directory);
            imageLabel.setIcon(image);
        }
    }
}
