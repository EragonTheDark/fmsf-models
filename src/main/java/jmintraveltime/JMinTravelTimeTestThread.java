package jmintraveltime;


public class JMinTravelTimeTestThread extends Thread
{
	String landScapePath = "";
	String inputFilePath = "";
	String ignitionFilePath = "";
	String barrierFilePath = "";
	
	JMinTravelTime mtt;
	
	public int returnCode = -1;
	public int startProc = 0;
	public int numProcs = 0;
	
	public void run() {
		
		mtt = new JMinTravelTime();
		String path = landScapePath;
		int returnValue = mtt.setLandscapeFile(path);
		System.out.println("mtt.setLandscapeFile returned " + returnValue + " for " + path);
		if (returnValue != 1)
		{
			System.out.println("Error occurred setting landscape file - "
				+ returnValue + " returned for " + path);
		}

		path = inputFilePath;
		returnValue = mtt.loadMTTTextSettingsFile(path);
		System.out.println("mtt.loadMTTTextSettingsFile returned " + returnValue + " for " + path);
		if (returnValue != 1)
		{
			System.out.println("Error occurred loading the MTT input file - "
				+ returnValue + " returned for " + path);
			System.out.println("Error Message: " + mtt.getMTTInputsErrorMessage(returnValue));
		}
		mtt.setNumProcessors(1);
		mtt.setStartProcessor(0);
		path = ignitionFilePath;
		returnValue = mtt.setIgnition(path);
		System.out.println("mtt.setIgnition returned " + returnValue + " for " + path);
		if (returnValue != 1)
		{
			System.out.println("Error occurred setting the MTT ignition file - "
				+ returnValue + " returned for " + path);
		}
		if(barrierFilePath.length() > 0)
		{
			path = barrierFilePath;
			returnValue = mtt.setBarrier(path);
			System.out.println("mtt.setBarrier returned " + returnValue + " for " + path);
			if (returnValue != 1)
			{
				System.out.println("Error occurred setting the MTT barrier file - "
						+ returnValue + " returned for " + path);
			}
		}
		mtt.setNumProcessors(numProcs);
		mtt.setStartProcessor(startProc+1);
		returnValue = mtt.launchMTT();
		System.out.println("mtt.launchMTT returned " + returnValue + " ");
		returnCode = returnValue;		
		
	}
}
