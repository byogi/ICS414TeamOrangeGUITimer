/******************************
 * TEAM ORANGE ICS414 GUI TIMER TEST CASES
 * @BRYSON YOGI
 * @KEVIN BEYDLER
 * @KERWIN YADAO
 * VERSION 1.0
 *****************************/

import static org.junit.Assert.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import org.junit.Test;

public class GUITimerTestCases {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public final void testUpdateDisplay() 
	{
		GUITimer test0 = new GUITimer();
	}

	@Test
	public void testTimeConversion() 
	{
		GUITimer test1 = new GUITimer();	
		
		assertEquals("testnumber(5) * 60000 + 1000 must be 301000",5,test1.timeConversion()); //5 minutes must convert to 301,000ms for timer test
	}
	
	@Test
	public void testitemStateChanged()
	{
		GUITimer test2  = new GUITimer();
		
		assertEquals(2,itemStateChanged(2));
	}

	private Object itemStateChanged(int i) 
	{
		return null;
	}
	
}
