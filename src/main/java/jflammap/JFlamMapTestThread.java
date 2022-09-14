/*
 * Created on Jun 26, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package jflammap;

/**
 * @author stubrittain copied from JFSProTestThread by bstoltz
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class JFlamMapTestThread extends Thread
{
	String landScapePath = "";
	String inputFilePath = "";
	JFlamMap flamMap;
	
	public int returnCode = -1;
	public int startProc = 0;
	public int numProcs = 0;
	
	public void run() {
		
		flamMap = new JFlamMap();
		String path = landScapePath;
		int returnValue = flamMap.setLandscapeFile(path);
		System.out.println("flamMap.setLandscapeFile returned " + returnValue + " for " + path);
		if (returnValue != 1)
		{
			System.out.println("Error occurred setting landscape file - "
				+ returnValue + " returned for " + path);
		}

		path = inputFilePath;
		returnValue = flamMap.loadFlamMapTextSettingsFile(path);
		System.out.println("flamMap.loadFlamMapTextSettingsFile returned " + returnValue + " for " + path);
		if (returnValue != 1)
		{
			System.out.println("Error occurred loading the FlamMap input file - "
				+ returnValue + " returned for " + path);
			System.out.println("Error Message: " + flamMap.getFlamMapInputsErrorMessage(returnValue));
		}
		flamMap.setNumProcessors(numProcs);
		flamMap.setStartProcessor(startProc+1);
		returnValue = flamMap.launchFlamMap();
		System.out.println("flamMap.launchFlamMap returned " + returnValue + " for " + path);
		returnCode = returnValue;		
		
	}

}
