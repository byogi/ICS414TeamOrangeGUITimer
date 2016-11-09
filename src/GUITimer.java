/******************************
 * TEAM ORANGE ICS414 GUI TIMER
 * @BRYSON YOGI
 * @KEVIN BEYDLER
 * @KERWIN YADAO
 * VERSION1.0
 *****************************/


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;



public class GUITimer extends JFrame implements ItemListener 
{


    JLabel timerDisplay;
    JLabel dropDownMenuLabel;
    JComboBox<Integer> minutesDropDownMenu;
    JButton startButton;
    JButton resetButton;
    NumberFormat format;
    public String maxMinutes;
    public long initialTime;
    public Timer timer;
    public long userInputTime;
    public long remainingTime;
    static final long serialVersionUID = 1L;
    
    //Holds the specifications for our timers GUI
    public GUITimer() //creates the layout for the timer
    {
    	
    	//creates new jpanel for our display
        JPanel layoutPanel = new JPanel();
        //sets default background color for GUI
        layoutPanel.setForeground(Color.BLACK);

        timerDisplay = new JLabel("Set Time");
        timerDisplay.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        timerDisplay.setForeground(Color.WHITE);
        timerDisplay.setBackground(Color.BLACK);
        timerDisplay.setOpaque(true);
        timerDisplay.setFont(new Font("Helvetica", Font.BOLD, 80));

        layoutPanel.add(timerDisplay);

        //creates jpanel for our dropdown menu and buttons
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout());
        
        
        
        dropDownMenuLabel = new JLabel("Set Time (minutes):");
        menuPanel.add(dropDownMenuLabel);

        
        //creates our new drop down menu which holds the available minutes
        minutesDropDownMenu = new JComboBox<Integer>();
        
        //runs a for loop that will interate x amount of times
        //each run adds a new value to the drop down menu which allows you
    	//to set the drop down menus amount of minutes to choose from
        for (int i = 20; i > 0; i--)
        {
            minutesDropDownMenu.addItem(Integer.valueOf(i));
        }
        
        
        minutesDropDownMenu.setSelectedIndex(0);
        
        //sets the max amount of minutes possible
        maxMinutes = "20";
        //needs to be placed first
        menuPanel.add(minutesDropDownMenu);
        
        //to be displayed on menuPanel
        //needs to be placed second
        startButton = new JButton("START");
        menuPanel.add(startButton);
        
        //to be displayed on menuPanel
        //needs to be placed third
        resetButton = new JButton("RESET");
        menuPanel.add(resetButton);

        //set menuPanel to top of window
        getContentPane().add(menuPanel, BorderLayout.NORTH);
        //set layoutPanel to center of panel below menuPanel
        getContentPane().add(layoutPanel, BorderLayout.CENTER);

        userInput e = new userInput();
        startButton.addActionListener(e);
        resetButton.addActionListener(e);

        minutesDropDownMenu.addItemListener(this);

        setBackground(Color.RED);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Countdown Timer");
        pack();
        setLocationByPlatform(true);
        setVisible(true);
    }
    
    
    
    //code for what happens when user presses the start or reset button
    //NOTE: Need to edit this method they don't work ideally yet
    public class userInput implements ActionListener 
    {

        public void actionPerformed(ActionEvent e) 
        {
            String buttonName = e.getActionCommand();
            
            //if the button pressed is START then update display
            if (buttonName.equals("START"))
            {
                updateDisplay();
            } 
            
            //else statement to handle the case in which RESET is pressed
            else 
            {
                timerDisplay.setText("RESET");
                timer.stop();
                remainingTime = timeConversion();
            }
        }
    }
    
    
    //starts timer when jbutton START is clicked
    void updateDisplay() 
    {

        Timeclass tc = new Timeclass();
        timer = new Timer(1000, tc);
        initialTime = System.currentTimeMillis();
        timer.start();
    }
  
    
   //converts mins from string format to a long 
   //from long to milliseconds for timer use
    public long timeConversion()
    {
        userInputTime = Long.parseLong(maxMinutes);
        long converted = (userInputTime * 60000) + 1000;
        return converted;
    }
    
    
    //updates display for swing timer as time decrements
    public class Timeclass implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {

            remainingTime = timeConversion();
            long current = System.currentTimeMillis();
            long elapsed = current - initialTime;
            remainingTime -= elapsed;

            format = NumberFormat.getNumberInstance();
            format.setMinimumIntegerDigits(2);

            if (remainingTime < 0)
                remainingTime = (long) 0;
	            int minutes = (int) (remainingTime / 60000);
	            int seconds = (int) ((remainingTime % 60000) / 1000);
	            timerDisplay.setText(format.format(minutes) + ":"
                + format.format(seconds));

            if (remainingTime == 0)
            {
                timerDisplay.setText("Stop");
                timer.stop();
            }
        }
    }
  
    //based on the total time selected from drop down menu method will change
    //the maxMinutes variable to match so that correct amount of time is set
    public void itemStateChanged(ItemEvent ie)
    {

        maxMinutes = (String) minutesDropDownMenu.getSelectedItem().toString();
        timeConversion();
    }


    
}