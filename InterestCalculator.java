//Author: Liam Hood
//Date: Jan 20, 2025
//Purpose: Create a GUI that enables the user to compute effective APR, and the Principal + interest given an APR, the number of times compounded annually, the principal, and whether or not it is compounded continuously.

import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JCheckBox;
//imports the necessary Java packages

public class InterestCalculator extends JFrame implements ActionListener
{
    private double apr;
    private double timesCompounded;
    private boolean continuous = false;
    private double effectiveApr;
    private double principal;
    private double totalCost = 0.00;
    private double time;
    //initializes local variables
     
    JButton button;
    //declares a new JButton object called 'button'
    
    JTextField aprTextField;
    JTextField princTextField;
    JTextField compTextField;
    JTextField timeTextField;
    JTextField effectiveAprTextField;
    JTextField totalTextField;
    //declares six new JTextField objects called 'aprTextField', 'princTextField', 'compTextField', 'timeTextField', 'effectiveAprTextField', 'totalTextField'. Creates the textfields used to input/output numerical data
  
    JLabel percent;
    JLabel percent1;
    JLabel dollar;
    JLabel dollar1;
    JLabel years;
    //Declares five new JLabel objects called 'percent', 'percent1', 'dollar', 'dollar1', and 'years'. Creates the text in the GUI.
    
    JCheckBox continuousCheck;
    //declaresa JCheckBox object called continuousCheck
    
    JFrame frame = new JFrame("Interest Calculator");
    //declares and initializes a new JFrame object called 'frame' with the title 'Interest Calculator'
    
    public static void main(String[] args) {
        InterestCalculator calc1 = new InterestCalculator(0, 0, false, 0, 0);
        //instantiates a new 'frameTester' object called 'calc1' and initializes the values 0, 0, false, 0, 0 for 'apr', 'timesCompounded', 'continuous', 'principal', and 'time' respectively.
    }

    
    public InterestCalculator(double apr, double timesCompounded, boolean continuous, double principal, double time)
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        //sets the default close operation and the layout for 'frame'
       
        this.apr = apr;
        this.timesCompounded = timesCompounded;
        this.continuous = continuous;
        this.principal = principal;
        this.time = time;
        //initialize local variables
        
        percent = new JLabel();
        percent.setText("%");
        percent.setFont(new Font("Arial", Font.PLAIN, 20));
        percent.setBounds(300, 140, 250, 50);
        //instantiates a new object of the JLabel class called 'percent' sets the font to 'Arial', sets the bounds, and assigns the text '%'.
        
        percent1 = new JLabel();
        percent1.setText("%");
        percent1.setFont(new Font("Arial", Font.PLAIN, 20));
        percent1.setBounds(650, 140, 250, 50);
         //instantiates a new object of the JLabel class called 'percent1' sets the font to 'Arial', sets the bounds, and assigns the text '%'.
        
        dollar = new JLabel();
        dollar.setText("$");
        dollar.setFont(new Font("Arial", Font.PLAIN, 20));
        dollar.setBounds(300, 190, 250, 50);
         //instantiates a new object of the JLabel class called 'dollar' sets the font to 'Arial', sets the bounds, and assigns the text '$'.
        
        dollar1 = new JLabel();
        dollar1.setText("$");
        dollar1.setFont(new Font("Arial", Font.PLAIN, 20));
        dollar1.setBounds(650, 190, 250, 50);
         //instantiates a new object of the JLabel class called 'dollar1' sets the font to 'Arial', sets the bounds, and assigns the text '$'.
        
        years = new JLabel();
        years.setText("years");
        years.setFont(new Font("Arial", Font.PLAIN, 20));
        years.setBounds(300, 290, 250, 50);
         //instantiates a new object of the JLabel class called 'years' sets the font to 'Arial', sets the bounds, and assigns the text 'years'.
        
        totalTextField = new JTextField();
        totalTextField.setBounds(400, 190, 250, 50);
        totalTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        totalTextField.setText("Total");
        totalTextField.setEditable(false);
         //instantiates a new object of the JTextField class called 'totalTextField' sets the font to 'Arial', sets the bounds, makes it uneditable, and assigns the text 'Total'.
        
        aprTextField = new JTextField();
        aprTextField.setBounds(50, 140, 250, 50);
        aprTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        aprTextField.setText("Input APR Here");
        //instantiates a new object of the JTextField class called 'aprTextField' sets the font to 'Arial', sets the bounds, and assigns the text 'Input APR Here'.
        
        princTextField = new JTextField();
        princTextField.setBounds(50, 190, 250, 50);
        princTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        princTextField.setText("Input Principal Here");
        //instantiates a new object of the JTextField class called 'princTextField' sets the font to 'Arial', sets the bounds, and assigns the text 'Input Principal Here'.
        
        compTextField = new JTextField();
        compTextField.setBounds(50, 240, 250, 50);
        compTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        compTextField.setText("Input Times Compounded");
        //instantiates a new object of the JTextField class called 'compTextField' sets the font to 'Arial', sets the bounds, and assigns the text 'Input Times Compounded'.
        
        timeTextField = new JTextField();
        timeTextField.setBounds(50, 290, 250, 50);
        timeTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        timeTextField.setText("Input Time");
        //instantiates a new object of the JTextField class called 'timeTextField' sets the font to 'Arial', sets the bounds, and assigns the text 'Input Time'.
        
        effectiveAprTextField = new JTextField();
        effectiveAprTextField.setBounds(400, 140, 250, 50);
        effectiveAprTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        effectiveAprTextField.setText("Effective APR");
        effectiveAprTextField.setEditable(false);
        //instantiates a new object of the JTextField class called 'effectiveTextField' sets the font to 'Arial', makes it uneditable, sets the bounds, and assigns the text 'Input APR Here'.
        
        continuousCheck = new JCheckBox("Compounded Continuously");
        continuousCheck.addActionListener(this);
        continuousCheck.setBounds(50, 340, 220, 20);
        //instantiates a new object of the JCheckBox class called 'contiuousCheck', assigns it the text 'Compounded Continuously', sets the bounds, and adds an actionListener.
        
        button = new JButton("Calculate");
        button.addActionListener(this);
        button.setBounds(50, 370, 100, 50);
        //instantiates a new object called 'button' of the 'JButton' class with the text 'Calculate', assigns it an ActionListener, and sets the bounds.
        
        frame.add(button);
        frame.add(aprTextField);
        frame.add(princTextField);
        frame.add(compTextField);
        frame.add(timeTextField);
        frame.add(effectiveAprTextField);
        frame.add(dollar);
        frame.add(dollar1);
        frame.add(years);
        frame.add(percent);
        frame.add(percent1);
        frame.add(continuousCheck);
        frame.add(totalTextField);
        frame.setSize(900, 1000);
        frame.setVisible(true);
        //adds the above Java objects to 'frame'
        
    }
    
       @Override
     public void actionPerformed(ActionEvent e) 
     //method ran by actionListener
     {
         
             if(continuousCheck.isSelected()){          //executed if the checkBox is checked
                 setContinuous(true);
                 //sets 'continuous' to true
                 compTextField.setText("Compounded Continuously");
                 compTextField.setEditable(false);
                 //sets the text of 'compTextField' to 'Compounded Continuously' and makes it uneditable
                }
             else if(!(continuousCheck.isSelected()))       //executed if the checkBox is not checked
             {
                 setContinuous(false);
                 //sets 'continuous' to false
                 compTextField.setEditable(true);
                 //makes 'compTextField' editable
            }
         if(e.getSource()==button){             //executed if the ActionPerfomed is from the object 'button'
            
             setApr(Double.parseDouble(aprTextField.getText()));
             setPrincipal(Double.parseDouble(princTextField.getText()));
             //sets 'apr' and 'principal' to the information inputted to their associated textFields
             
             if(!continuous){           //executed if 'continuousCheck' is not checked
                 setTimesCompounded(Integer.parseInt(compTextField.getText()));
                //sets 'timesCompounded' to the value inputted to its textField 
                 setTime(Double.parseDouble(timeTextField.getText()));
                   //sets 'time' to the value inputted to its textField 
                //   System.out.printf("time: %f", getTime());
                 effectiveInterestApr(getApr(), getTimesCompounded());
                    //calls the 'effectiveInterestApr' method and passes in the values of 'apr', and 'timesCompounded'
                 totalCost(getEffectiveApr(), getContinuous(), getTimesCompounded(), getPrincipal());
                 //calls the 'totalCost' method and passes in the values of 'effectiveApr', 'continuous', 'timesCompounded', and principal'.
                 totalTextField.setText(""+ Math.round(100.0 * getTotalCost())/100.0);
                 //sets the text of 'totalTextField' to 'totalCost'
                 effectiveAprTextField.setText("" + (Math.round(10000.0*(getEffectiveApr()-1))/100.0));
                 //sets the text of 'effectiveAprTextField' to effective interest rate as a percent rounded to the nearest hundredth.
            }
             
             else if(continuous)            //executed if continuous is checked
             {
                 setTime(Double.parseDouble(timeTextField.getText()));
                 //sets 'time' to the information inputted to its textField
                 contEffectiveInterestApr(getApr());
                 //calls the 'contEffectiveInterestRate' method and passes in the value 'apr'
                 totalCost(getEffectiveApr(), getContinuous(), getTimesCompounded(), getPrincipal());
                 //calls the 'totalCost' method and passes in the values 'effectiveApr', 'continuous', 'timesCompounded' and 'principal'
                 totalTextField.setText(""+ Math.round((getTotalCost() * 100.0))/100.0);
                 //sets the text in 'totalTextField' to the calculated value of 'totalCost' rounded to the nearest cent.
                 effectiveAprTextField.setText("" + Math.round(100.0 * (100.0*(getEffectiveApr()-1.00)))/100.0);
                 //sets the text in 'effectiveAprTextField' to the calculated interest rate rounded to the nearest hundredth of a percent.
             }
         }
     }
    
    public void paint(Graphics g)
    {
        super.paint(g);
    }
    //paint method
    
    public void effectiveInterestApr(double apr, double timesCompounded)
    {
        effectiveApr = Math.pow((1+(apr / (100.00 * timesCompounded))), timesCompounded);
        setEffectiveApr(effectiveApr);
    }
    //computes effective interest rate (not as a percent), when it is not compounded continuously.
    
    public void contEffectiveInterestApr(double apr)
    {
        if(getContinuous())
            setEffectiveApr((Math.pow(Math.E, (apr/100))));
    }
    //computes effective interest rate (not as a percent), when it is compounded continuously.
    
    public void totalCost(double effectiveApr, boolean continuous, double timesCompounded, double principal)
    {
        if(!continuous){
            setTotalCost(principal * (Math.pow(1+ (((getApr()/timesCompounded))/100), timesCompounded * getTime())));
            //if 'continuousCheck' is unchecked, sets 'totalCost' to 'principal' multiplied by APR compounded the required number of times
        }
        else if(continuous){
            setTotalCost((principal * (Math.pow(Math.E, ((apr/100) * getTime()))))); 
            //if 'continuousCheck' is checked, sets 'totalCost' to (principal * e^((apr/100) * 'time')
        }
    }
    //computes totalCost using 'effectiveApr', 'time', and 'principal'.
    
    /************** Setters ************************/
    public void setApr(double apr)
    {
        this.apr = apr;
    }
    //sets the value of 'apr'
    
    public void setTimesCompounded(int timesCompounded)
    {
        this.timesCompounded = timesCompounded;
    }
    //sets the value of 'timesCompounded'
    
    public void setContinuous(boolean continuous)
    {
        this.continuous = continuous;
    }
    //sets the value of 'continuous'
    
    public void setEffectiveApr(double effectiveApr)
    {
        this.effectiveApr = effectiveApr;
    }
    //sets the value of 'effectiveApr'
    
    public void setTotalCost(double totalCost)
    {
        this.totalCost = totalCost;
    }
    //sets the value of 'totalCost'
    
    public void setPrincipal(double principal)
    {
        this.principal = principal;
    }
    //sets the value of 'principal'
    
    public void setTime(double time)
    {
        this.time = time;
    }
    //sets the value of 'time'
    
    /***************** getters *******************/
    public double getApr()
    {
        return apr;
    }
    //returns the value of 'apr'
    
    public double getTimesCompounded()
    {
        return timesCompounded;
    }
    //returns the value of 'timesCompounded'
    
    public boolean getContinuous()
    {
        return continuous;
    }
    //returns the value of 'continuous'
    
    public double getEffectiveApr()
    {
        return effectiveApr;
    }
    //returns the value of 'effectiveApr'
    
    public double getTotalCost()
    {
        return totalCost;
    }
    //returns the value of 'totalCost'
    
    public double getPrincipal()
    {
        return principal;
    }
    //returns the value of 'principal'
    
    public double getTime()
    {
        return time;
    }
    //returns the value of 'time'
}