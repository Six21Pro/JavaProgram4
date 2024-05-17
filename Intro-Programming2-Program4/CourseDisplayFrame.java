import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class CourseDisplayFrame extends JFrame
{
    private JButton add;//add button
    private JButton sc;//sort by code button
    private JButton sn;//sort by name button
    private JButton sg;//sort by grade button
    private JButton reset;//reset button
    private JLabel l1;//label1
    private JLabel l2;//label2
    private JLabel l3;//label3
    private JLabel l4;//label4
    private JTextField f1;//field1
    private JTextField f2;//field2
    private JTextField f3;//field3
    private JTextField f4;//field4
    private JTextArea result;//textarea

    private static final int FRAME_WIDTH = 450;//as specified
    private static final int FRAME_HEIGHT = 400;

    ArrayList<Course> list=new ArrayList<Course>();
    int i=0;//used for retrieving array list positions
    

    public CourseDisplayFrame()
    {
        // creat button/lable/fields
        add = new JButton("Add Course");
        sc = new JButton("Sort by Code");
        sn = new JButton("Sort by Name");
        sg = new JButton("Sort by Grade");
        reset = new JButton("Rest inputs");

        f1 = new JTextField(30);
        f2 = new JTextField(30);
        f3 = new JTextField(30);
        f4 = new JTextField(30);
        f1.setText("Gen ed");//set when program begins
        l1 = new JLabel("Course code:");
        l2 = new JLabel("Course name:");
        l3 = new JLabel("Course credit:");
        l4 = new JLabel("Course grade:");
        result = new JTextArea(10,35);

        //set when program begins
        result.setText("Code\tName\tCredit\tGrade\n--------------------------------------------------------------------------------------------");

        JScrollPane scrollpane = new JScrollPane(result);
        // set up button and listener
        ActionListener listener = new ClickListener();
        add.addActionListener(listener);//for add button
        ActionListener listener2 = new ClickListener2();
        sc.addActionListener(listener2);//for set by code button
        ActionListener listener3 = new ClickListener3();
        sn.addActionListener(listener3);//for set by name button
        ActionListener listener4 = new ClickListener4();
        sg.addActionListener(listener4);//for set by grade button
        ActionListener listener5 = new ClickListener5();
        reset.addActionListener(listener5);//for reset button
        // add everything into panel
        JPanel panel = new JPanel();
        panel.add(l1);
        panel.add(f1);
        panel.add(l2);
        panel.add(f2);
        panel.add(l3);
        panel.add(f3);
        panel.add(l4);
        panel.add(f4);
        panel.add(add);
        panel.add(sc);
        panel.add(sn);
        panel.add(sg);
        panel.add(reset);

        panel.add(scrollpane);

        this.add(panel);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    class ClickListener implements ActionListener
    {
        //@ override a method 
        public void actionPerformed(ActionEvent event)
        {
            Course a =new Course(f1.getText(),f2.getText(),Integer.parseInt(f3.getText()),f4.getText());//creates a course from the fields
            list.add(a);//course added to arraylist

            //This was just for testing
            /* String output1=f1.getText();
            String output2=f2.getText();
            String output3=f3.getText();
            String output4=f4.getText();
            result.append("\n"+output1+"\t"+output2+"\t"+output2+"\t"+output4);*/
            //String output4=list;

            result.append("\n"+list.get(i));//new course appendded to textarea
            i++;//for positioning within the arrayList
            //System.out.println("listaddedsize: "+list.size()+"i: "+i);//FOR TESTING
        }
    }            

    class ClickListener2 implements ActionListener
    {
        //@ override a method 
        public void actionPerformed(ActionEvent event)
        {

            Collections.sort(list, new CompAscending());//performs desired sort

            result.setText("Code\tName\tCredit\tGrade\n--------------------------------------------------------------------------------------------\n");
            for (Course p : list) {

                result.append(p.toString()+"\n");//sorted course appended to reset textarea
            }

        }            
    }
    class ClickListener3 implements ActionListener
    {
        //@ override a method 
        public void actionPerformed(ActionEvent event)
        {

            Collections.sort(list, new CompAscending2());//performs desired sort

            result.setText("Code\tName\tCredit\tGrade\n--------------------------------------------------------------------------------------------\n");
            //result.setText("Code\tName\tCredit\tGrade\n--------------------------------------------------------------------------------------------");
            for (Course p : list) {

                result.append(p.toString()+"\n");//sorted course appended to reset textarea
            }

        }            
    }
    class ClickListener4 implements ActionListener
    {
        //@ override a method 
        public void actionPerformed(ActionEvent event)
        {

            Collections.sort(list, new CompAscending3());//performs desired sort

            result.setText("Code\tName\tCredit\tGrade\n--------------------------------------------------------------------------------------------\n");

            for (Course p : list) {

                result.append(p.toString()+"\n");//sorted course appended to reset textarea
            }

        }           
    }
    class ClickListener5 implements ActionListener
    {
        //@ override a method 
        public void actionPerformed(ActionEvent event)
        {
            //resets the text area

            //System.out.println("listA: "+list.size());//FOR TESTING
            result.setText("Code\tName\tCredit\tGrade\n--------------------------------------------------------------------------------------------\n");
            list.clear();//found this method online because i was struggling to figure out how to reset the arraylist, which is what this does

            i=0;//i is set to 0. This is necessary for add to work properly after a reset

        }            
    }
    class CompAscending implements Comparator<Course> {
        @Override
        public int compare(Course arg0, Course arg1) {
            //sorts by code
            return arg0.getCode().compareTo(arg1.getCode());

        }
    }
    class CompAscending2 implements Comparator<Course> {
        @Override
        public int compare(Course arg0, Course arg1) {
            //sorts by name
            return arg0.getName().compareTo(arg1.getName());

        }
    }
    class CompAscending3 implements Comparator<Course> {
        @Override
        public int compare(Course arg0, Course arg1) {
            //sorts by grade
            return arg0.getGrade().compareTo(arg1.getGrade());

        }
    }
}
