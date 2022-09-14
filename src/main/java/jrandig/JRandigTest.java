package jrandig;

import java.io.IOException;

public class JRandigTest {

	public String inputFilePath;
	public String outputPath;

	public static void main(String[] args) 
	{
		int iftdssIDs[] = new int[26];
		iftdssIDs[0] = JRandig.FMP_FLAMELENGTH;
		iftdssIDs[1] = JRandig.FMP_SPREADRATE;
		iftdssIDs[2] = JRandig.FMP_INTENSITY;
		iftdssIDs[3] = JRandig.FMP_HEATAREA;
		iftdssIDs[4] = JRandig.FMP_CROWNSTATE;
		iftdssIDs[5] = JRandig.FMP_MIDFLAME;
		iftdssIDs[6] = JRandig.FMP_HORIZRATE;
		iftdssIDs[7] = JRandig.FMP_MAXSPREADDIR;
		iftdssIDs[8] = JRandig.FMP_MAXSPOT_DIR;
		iftdssIDs[9] = JRandig.FMP_MAXSPOT_DX;
		iftdssIDs[10] = JRandig.FMP_CROWNFRACTIONBURNED;
		iftdssIDs[11] = JRandig.FMP_WINDDIRGRID;
		iftdssIDs[12] = JRandig.FMP_WINDSPEEDGRID;
		iftdssIDs[13] = JRandig.FMP_SOLARRADIATION;
		iftdssIDs[14] = JRandig.FMP_FUELMOISTURE1;
		iftdssIDs[15] = JRandig.FMP_FUELMOISTURE10;
		iftdssIDs[16] = JRandig.FMP_FUELMOISTURE100;
		iftdssIDs[17] = JRandig.FMP_FUELMOISTURE1000;
		iftdssIDs[18] = JRandig.RANDIG_BURN_PROBABILITY;
		iftdssIDs[19] = JRandig.RANDIG_FLP_CLASS_0_2;
		iftdssIDs[20] = JRandig.RANDIG_FLP_CLASS_2_4;
		iftdssIDs[21] = JRandig.RANDIG_FLP_CLASS_4_6;
		iftdssIDs[22] = JRandig.RANDIG_FLP_CLASS_6_8;
		iftdssIDs[23] = JRandig.RANDIG_FLP_CLASS_8_12;
		iftdssIDs[24] = JRandig.RANDIG_FLP_CLASS_12_PLUS;
		iftdssIDs[25] = JRandig.RANDIG_CONDITIONAL_FLAMELENGTH;
		try
		{
			if(args.length < 2)
			{
				System.out.println("JRandigTest requires two arguments:\n"
						+ "inputsFilePath outputPath\n"
						+ "where outputPath is complete path plus base filename for the output, e.g. C:\\output\\test\n");
				return;
			}
			JRandigTest test = new JRandigTest();
			test.inputFilePath = args[0];
			test.outputPath = args[1];

			JRandigTestThread testThread = new JRandigTestThread();
			testThread.inputFilePath = args[0];
			testThread.start();
			Thread.sleep(4000);	
			double progress = 0.0;//testThread.randig.getProgress();
			double burnProportion = 0.0;
			while(progress < 1.0)
			{
				Thread.sleep(1000);	
				progress = testThread.randig.getProgress();
				burnProportion = testThread.randig.getProportionBurned();
				System.out.println("Randig Progress: "+ progress + " Burn Proportion: " + burnProportion);
				if(burnProportion > 0.01)
				{
					testThread.randig.cancelRandig();
					Thread.sleep(3000);
					break;
				}
			}
			Thread.sleep(1000);	
			//write the outputs
			//testThread.randig.writeRandigOutputsGeoTiff(test.outputPath + "_JRandigOutputs.tif");
			//testThread.randig.writeFlamMapOutputsGeoTiff(test.outputPath + "_JFlamMapOutputs.tif");
			testThread.randig.writeFireSizeList(test.outputPath + "_JFireSizeList.csv");
			testThread.randig.writeOutputLayerASCII(JRandig.FMP_FLAMELENGTH, test.outputPath + "_JFlamelength.asc");
			testThread.randig.writeOutputLayersGeotiff(iftdssIDs, test.outputPath + "_JRandigOutputs.tif");
			testThread.randig.writePerimetersShapefile(test.outputPath + "_JRandigPerimeters.shp");
			testThread.randig.writeEmbersCsv(test.outputPath + "_JRandigEmbers.csv");
			testThread.randig.writeEmbersShapefile(test.outputPath + "_JRandigEmbers.shp");
			testThread.randig.writeWindVectorKML(test.outputPath + "_JRandigWindVectors.kml", 180.0);
			testThread.randig.writeTimingsFile(test.outputPath + "_JTimings.txt");
			System.out.println("KML resolution: " + testThread.randig.getWindVectorKMLResolution() + " meters");
			System.out.println("Randig Complete");
			System.out.println("Number fires requested: " + testThread.randig.getNumFiresToDo());
			System.out.println("Number fires completed: " + testThread.randig.getNumFiresComplete());
			System.out.println("Number MTT failures: " + testThread.randig.getNumMttFailures());
			System.out.println("Randig Burn Proportion: " + testThread.randig.getProportionBurned());
			System.exit(0);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("JRandigTest complete");
		}
	}
}
