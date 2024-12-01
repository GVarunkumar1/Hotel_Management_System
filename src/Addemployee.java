import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Addemployee extends JFrame implements ActionListener {
    JTextField tfname, tfemail, tfphone, tfage, tfsalary, tfaadhar;
    JRadioButton rbMale, rbfeMale;
    JButton submit;
    JComboBox cbjob;

    Addemployee(){
        setLayout(null);

        //name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 30, 120, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);

        //age
        JLabel lblage = new JLabel("Age");
        lblage.setBounds(60, 80, 120, 30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);

        //gender
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 130, 120, 30);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblgender);

        rbMale = new JRadioButton("Male");
        rbMale.setBounds(200, 130, 70, 30);
        rbMale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbMale.setBackground(Color.WHITE);
        add(rbMale);

        rbfeMale = new JRadioButton("Female");
        rbfeMale.setBounds(280, 130, 70, 30);
        rbfeMale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbfeMale.setBackground(Color.WHITE);
        add(rbfeMale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbfeMale);

        //job
        JLabel lbljob = new JLabel("Job");
        lbljob.setBounds(60, 180, 120, 30);
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbljob);

        String str[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chef", "Weiter/Weitress", "Manager", "Accountant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);

        //salary
        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setBounds(60, 230, 120, 30);
        lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);

        //phone
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(60, 280, 120, 30);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);

        //email
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(60, 330, 120, 30);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);

        //aadhar
        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60, 380, 120, 30);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 380, 150, 30);
        add(tfaadhar);

        //submit
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200,430,150,30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,470,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,60,450,400);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();

        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name should not be empty!!");
            return;
        }

        //email.equals("") && contains("@") && contains(".com")  //contains/includes

        String gender = null;
        if(rbMale.isSelected()){
            gender = "Male";
        }else if(rbfeMale.isSelected()){
            gender = "Female";
        }

        String job = (String) cbjob.getSelectedItem();

        try{
            conn con = new conn();
            String query = "insert into employee values('"+ name +"','"+ age +"','"+ gender +"','"+ job +"','"+ salary +"','"+ phone +"','"+ email +"','"+ aadhar +"')";
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee added successfully");
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Addemployee();
    }
}

