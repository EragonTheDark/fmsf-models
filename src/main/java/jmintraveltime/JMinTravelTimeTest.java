package jmintraveltime;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import jflammap.JFlamMap;



public class JMinTravelTimeTest 
{
	//You must provide one argument to this program!
	// path to file with first line indicating the count of 
	//MinTravelTime commands, and then that number of lines containing the MinTravelTime commands:
	//lcpfile inputsfile ignitionfile barrierfile outputspathname

	public String landScapePath;
	public String inputFilePath;
	public String outputPath;
	public String ignitionPath;
	public String barrierPath;

	public static void main(String[] args) 
	{
		CmdMain(args);
	}

	public static void CmdMain(String[] args) 
	{
		int iftdssIDs[] = new int[24];
		iftdssIDs[0] = JMinTravelTime.FMP_FLAMELENGTH;
		iftdssIDs[1] = JMinTravelTime.FMP_SPREADRATE;
		iftdssIDs[2] = JMinTravelTime.FMP_INTENSITY;
		iftdssIDs[3] = JMinTravelTime.FMP_HEATAREA;
		iftdssIDs[4] = JMinTravelTime.FMP_CROWNSTATE;
		iftdssIDs[5] = JMinTravelTime.FMP_MIDFLAME;
		iftdssIDs[6] = JMinTravelTime.FMP_HORIZRATE;
		iftdssIDs[7] = JMinTravelTime.FMP_MAXSPREADDIR;
		iftdssIDs[8] = JMinTravelTime.FMP_MAXSPOT_DIR;
		iftdssIDs[9] = JMinTravelTime.FMP_MAXSPOT_DX;
		iftdssIDs[10] = JMinTravelTime.FMP_CROWNFRACTIONBURNED;
		iftdssIDs[11] = JMinTravelTime.FMP_WINDDIRGRID;
		iftdssIDs[12] = JMinTravelTime.FMP_WINDSPEEDGRID;
		iftdssIDs[13] = JMinTravelTime.FMP_SOLARRADIATION;
		iftdssIDs[14] = JMinTravelTime.FMP_FUELMOISTURE1;
		iftdssIDs[15] = JMinTravelTime.FMP_FUELMOISTURE10;
		iftdssIDs[16] = JMinTravelTime.FMP_FUELMOISTURE100;
		iftdssIDs[17] = JMinTravelTime.FMP_FUELMOISTURE1000;
		iftdssIDs[18] = JMinTravelTime.MTT_ARRIVAL_TIME;
		iftdssIDs[19] = JMinTravelTime.MTT_FLAME_LENGTH;
		iftdssIDs[20] = JMinTravelTime.MTT_SPREAD_RATE;
		iftdssIDs[21] = JMinTravelTime.MTT_INTENSITY;
		iftdssIDs[22] = JMinTravelTime.MTT_INFLUENCE;
		iftdssIDs[23] = JMinTravelTime.MTT_IGNITION;
		BufferedReader csv = null;
		try
		{
			csv = new BufferedReader(new FileReader(args[0]));
			String l;
			int nLines = 0;
			l = csv.readLine();
			nLines = Integer.parseInt(l);
			JMinTravelTimeTest test[] = new JMinTravelTimeTest[nLines];
			JMinTravelTimeTestThread testThread[] = new JMinTravelTimeTestThread[nLines];
			int loc = 0;
			for(loc = 0; loc < nLines; loc++)
			{
				if((l = csv.readLine()) != null)
				{
					String[] cmdStr = l.split(" ", 5);
					test[loc] = new JMinTravelTimeTest();
					test[loc].landScapePath = cmdStr[0];
					test[loc].inputFilePath = cmdStr[1];
					test[loc].ignitionPath = cmdStr[2];
					test[loc].barrierPath = cmdStr[3];
					test[loc].outputPath = cmdStr[4];
					testThread[loc] = new JMinTravelTimeTestThread();
					testThread[loc].landScapePath = test[loc].landScapePath;
					testThread[loc].inputFilePath = test[loc].inputFilePath;
					testThread[loc].ignitionFilePath = test[loc].ignitionPath;
					if(test[loc].barrierPath.length() > 1)
						testThread[loc].barrierFilePath = test[loc].barrierPath;
					else
						testThread[loc].barrierFilePath = "";
					testThread[loc].startProc = loc;
					testThread[loc].numProcs = 1;
					testThread[loc].start();
				}
			}
			
			//loop thru checking progress so we know we're done with all threads
			for(loc = 0; loc < nLines; loc++)
			{
				Thread.sleep(1000);	
				double progress = testThread[loc].mtt.getMTTProgress();// + testThread2.farsite.getFarsiteProgress();
				while(progress < 1.0)
				{
					Thread.sleep(1000);	
					progress = testThread[loc].mtt.getMTTProgress();// + testThread2.farsite.getFarsiteProgress();
					System.out.println("MTT " + loc + " Progress: " + progress);
				}
			}
			
			//write all the outputs
			int err;
			for(loc = 0; loc < nLines; loc++)
			{
				testThread[loc].mtt.writeArrivalTimeGrid(test[loc].outputPath + "_J_ARRIVALTIME.asc");
				testThread[loc].mtt.writeFliMapGrid(test[loc].outputPath + "_J_FLIMAP.asc");
				testThread[loc].mtt.writeInfluenceGrid(test[loc].outputPath + "_J_MTTInfluence.asc");
				testThread[loc].mtt.writeROSGrid(test[loc].outputPath + "_J_MTTROS.asc");
				testThread[loc].mtt.writeFlowPathsShapeFile(test[loc].outputPath + "_J_FLOWPATHS.shp");
				testThread[loc].mtt.writeMajorPathsShapeFile(test[loc].outputPath + "_J_MAJORPATHS.shp");
				//show how regular flammap outputs can be retrieved
				err = testThread[loc].mtt.writeWindVectorKML(test[loc].outputPath + "_J_WINDVECTORS.kml", 180.0);
				if(err != 1)
				{
					System.out.println("MTT " + loc + " Error: "
							+ testThread[loc].mtt.getErrorMessage(err) + " for " + test[loc].outputPath + "_J_WINDVECTORS.kml");
				}
				System.out.println("MTT " + loc + " WindVectorKML Resolution: " + testThread[loc].mtt.getWindVectorKMLResolution());
				testThread[loc].mtt.writeOutputLayersGeotiff(iftdssIDs, test[loc].outputPath + "_J_MinTravelTimeALLbyIds.tif");
				testThread[loc].mtt.writeEmbersShapeFile(test[loc].outputPath + "_J_Embers.shp");
				testThread[loc].mtt.writeEmbersCsvFile(test[loc].outputPath + "_J_Embers.csv");
				testThread[loc].mtt.writeFlameLengthGrid(test[loc].outputPath + "_J_MTTFlameLength.asc");
				testThread[loc].mtt.writeIgnitionGrid(test[loc].outputPath + "_J_MTTIgnitions.asc");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try	// Close the input stream
			{
				if (csv != null)
				{
					csv.close();
				}
				System.out.println("JMinTravelTimeTest complete");
			}
			catch (IOException ioExc) {}
		}
			
	}


	public static void oldmain(String[] args) 
	{
		try
		{
			if(args.length < 3)
			{
				System.out.println("JMinTravelTimeTest requires four arguments:\n"
						+ "landscapePath, inputsFilePath, ignitionPath, outputPath\n"
						+ "where outputPath is complete path plus base filename for the output, e.g. C:\\output\\test\n");
				return;
			}
			JMinTravelTimeTest test = new JMinTravelTimeTest();
			test.landScapePath = args[0];
			test.inputFilePath = args[1];
			test.ignitionPath = args[2];
			test.outputPath = args[3];
			
			
			JMinTravelTimeTestThread testThread = new JMinTravelTimeTestThread();
			testThread.landScapePath = test.landScapePath;
			testThread.inputFilePath = test.inputFilePath;
			testThread.ignitionFilePath = test.ignitionPath;
			testThread.barrierFilePath = "";//test.barrierPath;
			testThread.run();
			Thread.sleep(1000);	
			double progress = testThread.mtt.getMTTProgress();
			while(progress < 1.0)
			{
				Thread.sleep(1000);	
				progress = testThread.mtt.getMTTProgress();
				System.out.println("MTT Progress: "
						+ progress);
			}
			//ok we're done, get the outputs
			//testThread.mtt.writeArrivalTimeGrid(test.outputPath + "_J_ARRIVALTIME.asc");
			testThread.mtt.writeFlowPathsShapeFile(test.outputPath + "_J_FLOWPATHS.shp");
			testThread.mtt.writeMajorPathsShapeFile(test.outputPath + "_J_MAJORPATHS.shp");
			//show how regular flammap outputs can be retrieved

			//Do it synchronously
/*			JMinTravelTime mtt = new JMinTravelTime();
			String path = landScapePath;
			int returnValue = mtt.setLandscapeFile(landScapePath);
			System.out.println("mtt.setLandscapeFile returned " + returnValue + " for " + path);
			if (returnValue != 1)
			{
				System.out.println("Error occurred setting landscape file - "
					+ returnValue + " returned for " + path);
			}

			path = inputFilePath;
			returnValue = mtt.loadMTTTextSettingsFile(path);
			System.out.println("mtt.loadFlamMapTextSettingsFile returned " + returnValue + " for " + path);
			if (returnValue != 1)
			{
				System.out.println("Error occurred loading the MTT input file - "
					+ returnValue + " returned for " + path);
				System.out.println("Error Message: " + mtt.getMTTInputsErrorMessage(returnValue));
			}
			returnValue = mtt.launchMTT();
			System.out.println("mtt.launchMTT returned " + returnValue + " for " + path);
			//write MTT outputs
			mtt.writeArrivalTimeGrid(test.outputPath + "_J_ARRIVALTIME.asc");
			mtt.writeFliMapGrid(test.outputPath + "_J_FLIMAP.asc");
			mtt.writeROSGrid(test.outputPath + "_J_MTTROS.asc");
			mtt.writeArrivalTimeGridBinary(test.outputPath + "_J_ARRIVALTIME.fbg");
			mtt.writeFliMapGridBinary(test.outputPath + "_J_FLIMAP.fbg");
			mtt.writeROSGridBinary(test.outputPath + "_J_MTTROS.fbg");
			//show how regular flammap outputs can be retrieved
			mtt.writeFlamMapOutputLayerBinary(JMinTravelTime.FMP_FLAMELENGTH, test.outputPath + "_J_FLAMELENGTH.fbg");
			System.out.println("mtt outputs written");*/
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
