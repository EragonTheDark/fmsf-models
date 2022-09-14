package jrandig;

import jmintraveltime.JMinTravelTime;

public class JRandigTestThread  extends Thread
{
	public String inputFilePath = "";
	public JRandig randig;
	
	public int returnCode = -1;
	
	public void run() 
	{
		randig = new JRandig();
		String inputs = inputFilePath;
		int returnValue = randig.loadInputsFile(inputs);
		if (returnValue != 1)
		{
			System.out.println("Error occurred loading inputs file - "
				+ returnValue + " returned for " + inputs);
			System.out.println("Error message: " + randig.getErrorMessage(returnValue));
		}
		returnValue = randig.launchRandig();
		if (returnValue != 1)
		{
			System.out.println("Error message: " + randig.getErrorMessage(returnValue));
		}
		returnCode = returnValue;		
	}	
}
