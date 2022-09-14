package jfarsite;


public class JFarsiteTestThread  extends Thread
{
	String landScapePath = "";
	String inputFilePath = "";
	String ignitionFilePath = "";
	String barrierFilePath = "";

	JFarsite farsite;
	
	public int returnCode = -1;
	
	public void run() {
		
		farsite = new JFarsite();
		String path = landScapePath;
		int returnValue = farsite.setLandscapeFile(path);
		System.out.println("farsite.setLandscapeFile returned " + returnValue + " for " + path);
		if (returnValue != 1)
		{
			System.out.println("Error occurred setting landscape file - "
				+ returnValue + " returned for " + path);
		}

		path = inputFilePath;
		returnValue = farsite.loadFarsiteTextSettingsFile(path);
		System.out.println("farsite.loadFarsiteTextSettingsFile returned " + returnValue + " for " + path);
		if (returnValue != 1)
		{
			System.out.println("Error occurred loading the Farsite input file - "
				+ returnValue + " returned for " + path);
			System.out.println("Error Message: " + farsite.getFarsiteInputsErrorMessage(returnValue));
		}
		path = ignitionFilePath;
		returnValue = farsite.setIgnition(path);
		System.out.println("farsite.setIgnition returned " + returnValue + " for " + path);
		if (returnValue != 1)
		{
			System.out.println("Error occurred setting the Farsite ignition file - "
				+ returnValue + " returned for " + path);
		}
		if(barrierFilePath.length() > 0)
		{
			path = barrierFilePath;
			returnValue = farsite.setBarrier(path);
			System.out.println("farsite.setBarrier returned " + returnValue + " for " + path);
			if (returnValue != 1)
			{
				System.out.println("Error occurred setting the Farsite barrier file - "
						+ returnValue + " returned for " + path);
			}
		}
		//farsite.setNumProcessors(2);
		//farsite.setStartProcessor(0);
		returnValue = farsite.launchFarsite();
		System.out.println("farsite.launchFarsite returned " + returnValue + " for " + inputFilePath);
		returnCode = returnValue;		
		
	}


}
