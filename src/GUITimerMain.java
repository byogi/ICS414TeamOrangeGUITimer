/******************************
 * TEAM ORANGE ICS414 GUI TIMER
 * @BRYSON YOGI
 * @KEVIN BEYDLER
 * @KERWIN YADAO
 * VERSION1.0
 *****************************/

import javax.swing.*;


public class GUITimerMain 
{
	
	//create a GUITimer using main to execute
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new GUITimer();
            }

        });
    }

}
