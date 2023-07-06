package Course;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import StudentScreen.ViewCourse;

public class OopsTheory extends JFrame implements ActionListener {
    JPanel panel1, panel2;
    JLabel label, label2, label3;
    String courseName;
    JButton button,button2;

    public OopsTheory(String courseName) {
        this.courseName = courseName;
        ArrayList<String> check = new ArrayList<>();
        button = new JButton("Quiz :)");
        panel1 = new JPanel();
        panel2 = new JPanel();
        label = new JLabel("Student Console");
        label2 = new JLabel("Course Title: " + courseName);
        label3 = new JLabel("Course Teacher: Miss Sumaira");

        this.setSize(800, 800);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        panel2.setLayout(null);
        panel1.add(label);
        panel2.add(label2);
        panel2.add(label3);
        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        panel1.setBackground(Color.LIGHT_GRAY);
        label2.setBounds(20, 10, 430, 20);
        label3.setBounds(20, 30, 190, 20);
        button.setBounds(20, 60, 190, 20);
        button.addActionListener(this);

        
        button2 = new JButton("Back to Course");
     button2.addActionListener(this);
         panel2.add(button2);
         button2.setBackground(Color.BLACK);
         button2.setForeground(Color.white);
         button2.setBounds(20,130,180,30);
        button2.setFocusable(false);
        
        button.setBackground(Color.black);
            button.setForeground(Color.WHITE);
        try {
            BufferedReader reader = new BufferedReader(new FileReader("quizTiming.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                check.add(line);
            }
            reader.close();
        } catch (Exception err) {
            System.out.println(err);
        }
        // if(check.get(1).equals(courseName)) {
        //     panel2.add(button);
        // }
 String QuizTime = check.get(0);
        LocalTime currentTime = LocalTime.now();
        String currentTimeString = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        int comparison = QuizTime.compareTo(currentTimeString);
        System.out.println(check.get(1));
        if(check.get(1).equals(courseName) && comparison <=0){
            panel2.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == button){
            this.dispose();
            new QuizPage();
        }
        if(e.getSource() == button2){
            this.dispose();
            new ViewCourse();
        }
    }
}