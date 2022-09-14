/*
 * Created on Jun 26, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package jfspro;

/**
 * @author stu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class JFSProTestThread extends Thread
{
	String landScapePath = "";
	String inputFilePath = "";
	String outputPath = "";
	JFSPro fsPro;
	
	public int returnCode = -1;
	
	public void run() {
		int outIDs[] = new int[5];
		outIDs[0] = JFSPro.FSPRO_BURN_PROBABILITY;
		outIDs[1] = JFSPro.FSPRO_AVERAGE_ARRIVAL_TIME;
		outIDs[2] = JFSPro.FSPRO_AVERAGE_FLAMELENGTH;
		outIDs[3] = JFSPro.FSPRO_SUPPRESION_BURN_PROBABILTY;
		outIDs[4] = JFSPro.FSPRO_IGNITION;
		
		
		fsPro = new JFSPro();
		String path = landScapePath;
		int returnValue = fsPro.setLandscapeFile(path);
		System.out.println("fsPro.setLandscapeFile returned " + returnValue + " for " + path);
		if (returnValue != 1)
		{
			System.out.println("Error occurred setting landscape file - "
				+ returnValue + " returned for " + path);
		}

		path = inputFilePath;
		returnValue = fsPro.loadFsproSettingsFile(path);
		System.out.println("fsPro.loadFsproSettingsFile returned " + returnValue + " for " + path);
		if (returnValue != 1)
		{
			System.out.println("Error occurred loading the FSPro input file - "
				+ returnValue + " returned for " + path);
		}
		returnValue = fsPro.launchFspro();
		System.out.println("fsPro.launchFspro returned " + returnValue + " for " + path);
		returnCode = returnValue;		
		System.out.println("FSPro completed "
				+ fsPro.getNumFiresComplete() + " fires, writing outputs...");
			fsPro.writeProbabilityGrid(outputPath + "Probability.asc");
			fsPro.writeArrivalDayDistribution(outputPath + "ArrivalDay.shp");
			fsPro.writeAverageTimeGrid(outputPath + "AvgTime.asc");
			fsPro.writeAverageFlameLengthGrid(outputPath + "AvgFlameLength.asc");
			fsPro.writeIgnitionGrid(outputPath + "Ignitions.asc");
			fsPro.writeFirePerimeters(outputPath + "perimeters.shp");
			fsPro.writeSuppressionProbabilityGrid(outputPath + "SuppressionProb.asc");
			fsPro.writeDailyAcres(outputPath + "DailyAcres.txt");
			fsPro.writeEventCoverage(outputPath + "EventCoverage.txt");
			fsPro.writeDayTypes(outputPath + "DayTypes.txt");
			fsPro.writeFireStreams(outputPath + "FireStreams.txt");
			fsPro.writeOutputLayersGeotiff(outIDs, outputPath + "FSProOutputs.tif");
			fsPro.writeTimings(outputPath + "Timings.txt");
			System.out.println("FSPro outputs written to " + outputPath);
	}

}
