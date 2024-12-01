import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {
    JButton newcustomer, rooms, department, allemployee, managerinfo, customerinfo, searchRoom, updateStatus, updateRStatus, pickupService, checkout, logout;
    Reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //new customer
        newcustomer = new JButton("New Customer Form");
        newcustomer.setBounds(10,30,200,30);
        newcustomer.setBackground(Color.BLACK);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.addActionListener(this);
        add(newcustomer);

        //rooms
        rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);

        //departments
        department = new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);

        //All employees
        allemployee = new JButton("All Employees");
        allemployee.setBounds(10,150,200,30);
        allemployee.setBackground(Color.BLACK);
        allemployee.setForeground(Color.WHITE);
        allemployee.addActionListener(this);
        add(allemployee);

        //customer info
        customerinfo = new JButton("Customer Info");
        customerinfo.setBounds(10,190,200,30);
        customerinfo.setBackground(Color.BLACK);
        customerinfo.setForeground(Color.WHITE);
        customerinfo.addActionListener(this);
        add(customerinfo);

        //manager info
        managerinfo = new JButton("Manager Info");
        managerinfo.setBounds(10,230,200,30);
        managerinfo.setBackground(Color.BLACK);
        managerinfo.setForeground(Color.WHITE);
        managerinfo.addActionListener(this);
        add(managerinfo);

        //checkout
        checkout = new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        //update status
        updateStatus = new JButton("Update Status");
        updateStatus.setBounds(10,310,200,30);
        updateStatus.setBackground(Color.BLACK);
        updateStatus.setForeground(Color.WHITE);
        updateStatus.addActionListener(this);
        add(updateStatus);

        //update room status
        updateRStatus = new JButton("Update Room Status");
        updateRStatus.setBounds(10,350,200,30);
        updateRStatus.setBackground(Color.BLACK);
        updateRStatus.setForeground(Color.WHITE);
        updateRStatus.addActionListener(this);
        add(updateRStatus);

        //pickup service
        pickupService = new JButton("Pickup Service");
        pickupService.setBounds(10,390,200,30);
        pickupService.setBackground(Color.BLACK);
        pickupService.setForeground(Color.WHITE);
        pickupService.addActionListener(this);
        add(pickupService);

        //search room
        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10,430,200,30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(searchRoom);

        //logout
        logout = new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);

        //Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);


        setBounds(350,200,800,570);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== newcustomer){
            setVisible(false);
            new Addcustomer();
        }else if(ae.getSource()==rooms){
            setVisible(false);
            new rooms();
        }else if(ae.getSource()==department){
            setVisible(false);
            new Department();
        }else if(ae.getSource()==allemployee){
            setVisible(false);
            new EmployeeInfo();
        }else if(ae.getSource()==managerinfo){
            setVisible(false);
            new ManagerInfo();
        }else if(ae.getSource()==customerinfo){
            setVisible(false);
            new CustomerInfo();
        }else if(ae.getSource()==searchRoom){
            setVisible(false);
            new SearchRoom();
        }else if(ae.getSource()==updateStatus){
            setVisible(false);
            new updateCheck();
        }else if(ae.getSource()==updateRStatus){
            setVisible(false);
            new updateRoom();
        }else if(ae.getSource()==pickupService){
            setVisible(false);
            new SearchDriver();
        }else if(ae.getSource()==checkout){
            setVisible(false);
            new Checkout();
        }else if(ae.getSource()==logout){
            setVisible(false);
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new Reception();
    }
}
