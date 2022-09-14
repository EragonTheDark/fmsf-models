package jfarsite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import jfarsite.JFarsiteTestThread;
import jflammap.JFlamMap;

public class JFarsiteTest 
{
	//You must provide one argument to this program!
	// path to file with first line indicating the count of 
	//farsite commands, and then that number of lines containing the farsite commands:
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
		int testRet;
		int iftdssIDs[] = new int[9];
		iftdssIDs[0] = JFarsite.FARSITE_ARRIVAL_TIME;
		iftdssIDs[1] = JFarsite.FARSITE_CROWNSTATE;
		iftdssIDs[2] = JFarsite.FARSITE_FLAME_LENGTH;
		iftdssIDs[3] = JFarsite.FARSITE_HEAT_PER_UNIT_AREA;
		iftdssIDs[4] = JFarsite.FARSITE_IGNITION;
		iftdssIDs[5] = JFarsite.FARSITE_INTENSITY;
		iftdssIDs[6] = JFarsite.FARSITE_REACTION_INTENSITY;
		iftdssIDs[7] = JFarsite.FARSITE_SPREAD_DIRECTION;
		iftdssIDs[8] = JFarsite.FARSITE_SPREAD_RATE;
		BufferedReader csv = null;
		try
		{
			csv = new BufferedReader(new FileReader(args[0]));
			String l;
			int nLines = 0;
			l = csv.readLine();
			nLines = Integer.parseInt(l);
			JFarsiteTest test[] = new JFarsiteTest[nLines];
			JFarsiteTestThread testThread[] = new JFarsiteTestThread[nLines];
			int loc = 0;
			//while ((l = csv.readLine()) != null) 
			for(int f = 0; loc < nLines; f++)
			{
				if((l = csv.readLine()) != null)
				{
					String[] cmdStr = l.split(" ", 5);
					test[loc] = new JFarsiteTest();
					test[loc].landScapePath = cmdStr[0];
					test[loc].inputFilePath = cmdStr[1];
					test[loc].ignitionPath = cmdStr[2];
					test[loc].barrierPath = cmdStr[3];
					test[loc].outputPath = cmdStr[4];
					testThread[loc] = new JFarsiteTestThread();
					testThread[loc].landScapePath = test[loc].landScapePath;
					testThread[loc].inputFilePath = test[loc].inputFilePath;
					testThread[loc].ignitionFilePath = test[loc].ignitionPath;
					testThread[loc].barrierFilePath = test[loc].barrierPath;
					testThread[loc].start();
					loc++;
				}
			}
			
			//loop thru cheking progress so we know we're done with all threads
			for(loc = 0; loc < nLines; loc++)
			{
				Thread.sleep(1000);	
				double progress = testThread[loc].farsite.getFarsiteProgress();// + testThread2.farsite.getFarsiteProgress();
				while(progress < 1.0)
				{
					Thread.sleep(1000);	
					progress = testThread[loc].farsite.getFarsiteProgress();// + testThread2.farsite.getFarsiteProgress();
					System.out.println("Farsite " + loc + " Progress: "
						+ progress);
				}
			}
			
			//write all the outputs
			for(loc = 0; loc < nLines; loc++)
			{
				testThread[loc].farsite.writeSpreadRateGrid(test[loc].outputPath + "_J_SpreadRate.asc");
				testThread[loc].farsite.writePerimetersShapeFile(test[loc].outputPath + "_J_Perimeters.shp");
				testThread[loc].farsite.writeArrivalTimeGrid(test[loc].outputPath + "_J_ArrivalTime.asc");
				testThread[loc].farsite.writeTimingsFile(test[loc].outputPath + "_J_Timings.txt");
				testRet = testThread[loc].farsite.writeOutputLayersGeotiff(iftdssIDs, test[loc].outputPath + "_J_FarsiteALLbyIds.tif");
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
				System.out.println("JFarsiteTest complete");
			}
			catch (IOException ioExc) {}
		}
			
	}
}
