package jflammap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import jflammap.JFlamMapTestThread;


public class JFlamMapTest {
	//You must provide three arguments to this program!
	// landscapePath, inputFilePath, outputPath
	

	public String landScapePath;
	public String inputFilePath;
	public String outputPath;
	
	public static void main(String[] args) 
	{  
		try
		{
			if(args.length < 3)
			{
				System.out.println("JFlamMapTest requires three arguments:\n"
						+ "landscapePath, inputsFilePath, outputPath\n"
						+ "where outputPath is complete path plus base filename for the output, e.g. C:\\output\\test\n");
				return;
			}
			JFlamMapTest test = new JFlamMapTest();
			test.landScapePath = args[0];
			test.inputFilePath = args[1];
			test.outputPath = args[2];
			
			JFlamMapTestThread testThread = new JFlamMapTestThread();
			testThread.landScapePath = test.landScapePath;
			testThread.inputFilePath = test.inputFilePath;
			testThread.start();
			
			Thread.sleep(1000);	
			double progress = testThread.flamMap.getFlamMapProgress();// + testThread2.flamMap.getFlamMapProgress();
			while(progress < 1.0){
				Thread.sleep(1000);	
				progress = testThread.flamMap.getFlamMapProgress();// + testThread2.flamMap.getFlamMapProgress();
				System.out.println("FlamMap Progress: " + progress);
			}
			//ok we're done, get the outputs
			int err;
			int iftdssIDs[] = new int[18];
			iftdssIDs[0] = JFlamMap.FMP_FLAMELENGTH;
			iftdssIDs[1] = JFlamMap.FMP_SPREADRATE;
			iftdssIDs[2] = JFlamMap.FMP_INTENSITY;
			iftdssIDs[3] = JFlamMap.FMP_HEATAREA;
			iftdssIDs[4] = JFlamMap.FMP_CROWNSTATE;
			iftdssIDs[5] = JFlamMap.FMP_MIDFLAME;
			iftdssIDs[6] = JFlamMap.FMP_HORIZRATE;
			iftdssIDs[7] = JFlamMap.FMP_MAXSPREADDIR;
			iftdssIDs[8] = JFlamMap.FMP_MAXSPOT_DIR;
			iftdssIDs[9] = JFlamMap.FMP_MAXSPOT_DX;
			iftdssIDs[10] = JFlamMap.FMP_CROWNFRACTIONBURNED;
			iftdssIDs[11] = JFlamMap.FMP_WINDDIRGRID;
			iftdssIDs[12] = JFlamMap.FMP_WINDSPEEDGRID;
			iftdssIDs[13] = JFlamMap.FMP_SOLARRADIATION;
			iftdssIDs[14] = JFlamMap.FMP_FUELMOISTURE1;
			iftdssIDs[15] = JFlamMap.FMP_FUELMOISTURE10;
			iftdssIDs[16] = JFlamMap.FMP_FUELMOISTURE100;
			iftdssIDs[17] = JFlamMap.FMP_FUELMOISTURE1000;
			testThread.flamMap.writeOutputLayer(JFlamMap.FMP_FLAMELENGTH, test.outputPath + "_J_FLAMELENGTH.asc");
			testThread.flamMap.writeOutputLayer(JFlamMap.FMP_SPREADRATE, test.outputPath + "_J_SPREADRATE.asc");
			testThread.flamMap.writeOutputLayer(JFlamMap.FMP_INTENSITY, test.outputPath + "_J_INTENSITY.asc");
			testThread.flamMap.writeOutputLayer(JFlamMap.FMP_HEATAREA, test.outputPath + "_J_HEATAREA.asc");
			testThread.flamMap.writeOutputLayer(JFlamMap.FMP_CROWNSTATE, test.outputPath + "_J_CROWNSTATE.asc");
			testThread.flamMap.writeOutputLayer(JFlamMap.FMP_MIDFLAME, test.outputPath + "_J_MIDFLAME.asc");
			testThread.flamMap.writeOutputLayer(JFlamMap.FMP_HORIZRATE, test.outputPath + "_J_HORIZRATE.asc");
			testThread.flamMap.writeOutputLayer(JFlamMap.FMP_MAXSPREADDIR, test.outputPath + "_J_MAXSPREADDIR.asc");
			testThread.flamMap.writeOutputLayer(JFlamMap.FMP_MAXSPOT_DIR, test.outputPath + "_J_MAXSPOT_DIR.asc");
			testThread.flamMap.writeOutputLayer(JFlamMap.FMP_MAXSPOT_DX, test.outputPath + "_J_MAXSPOT_DX.asc");
			//fuel conditioning output
			testThread.flamMap.writeOutputLayer(JFlamMap.FMP_SOLARRADIATION, test.outputPath + "_J_SOLARRADIATION.asc");
			testThread.flamMap.writeOutputLayer(JFlamMap.FMP_FUELMOISTURE1, test.outputPath + "_J_FUELMOISTURE1.asc");
			testThread.flamMap.writeOutputLayer(JFlamMap.FMP_FUELMOISTURE10, test.outputPath + "_J_FUELMOISTURE10.asc");
			testThread.flamMap.writeOutputLayer(JFlamMap.FMP_FUELMOISTURE100, test.outputPath + "_J_FUELMOISTURE100.asc");
			testThread.flamMap.writeOutputLayer(JFlamMap.FMP_FUELMOISTURE100, test.outputPath + "_J_FUELMOISTURE1000.asc");
			//windninja output
			testThread.flamMap.writeOutputLayer(JFlamMap.FMP_WINDDIRGRID, test.outputPath + "_J_WINDDIRGRID.asc");
			testThread.flamMap.writeOutputLayer(JFlamMap.FMP_WINDSPEEDGRID, test.outputPath + "_J_WINDSPEEDGRID.asc");
			//kml output
			err = testThread.flamMap.writeWindVectorKML(test.outputPath + "_J_WINDVECTORS.kml", 180.0);
			if(err != 1)
			{
				System.out.println("FlamMap Error: "
						+ testThread.flamMap.getErrorMessage(err) + " for " + test.outputPath + "_J_WINDVECTORS.kml");
			}
			System.out.println("FlamMap WindVectorKML Resolution: " + testThread.flamMap.getWindVectorKMLResolution());
			testThread.flamMap.writeOutputLayerGeotiff(JFlamMap.FMP_FLAMELENGTH, test.outputPath + "_J_FLAMELENGTH.tif");
			testThread.flamMap.writeOutputLayerGeotiff(JFlamMap.FMP_SPREADRATE, test.outputPath + "_J_SPREADRATE.tif");
			testThread.flamMap.writeOutputLayerGeotiff(JFlamMap.FMP_INTENSITY, test.outputPath + "_J_INTENSITY.tif");
			testThread.flamMap.writeOutputLayerGeotiff(JFlamMap.FMP_HEATAREA, test.outputPath + "_J_HEATAREA.tif");
			testThread.flamMap.writeOutputLayerGeotiff(JFlamMap.FMP_CROWNSTATE, test.outputPath + "_J_CROWNSTATE.tif");
			testThread.flamMap.writeOutputLayerGeotiff(JFlamMap.FMP_MIDFLAME, test.outputPath + "_J_MIDFLAME.tif");
			testThread.flamMap.writeOutputLayerGeotiff(JFlamMap.FMP_HORIZRATE, test.outputPath + "_J_HORIZRATE.tif");
			testThread.flamMap.writeOutputLayerGeotiff(JFlamMap.FMP_MAXSPREADDIR, test.outputPath + "_J_MAXSPREADDIR.tif");
			testThread.flamMap.writeOutputLayerGeotiff(JFlamMap.FMP_MAXSPOT_DIR, test.outputPath + "_J_MAXSPOT_DIR.tif");
			testThread.flamMap.writeOutputLayerGeotiff(JFlamMap.FMP_MAXSPOT_DX, test.outputPath + "_J_MAXSPOT_DX.tif");
			testThread.flamMap.writeOutputLayerGeotiff(JFlamMap.FMP_CROWNFRACTIONBURNED, test.outputPath + "_J_CROWNFACTIONBURNED.tif");
			//fuel conditioning output
			testThread.flamMap.writeOutputLayerGeotiff(JFlamMap.FMP_SOLARRADIATION, test.outputPath + "_J_SOLARRADIATION.tif");
			testThread.flamMap.writeOutputLayerGeotiff(JFlamMap.FMP_FUELMOISTURE1, test.outputPath + "_J_FUELMOISTURE1.tif");
			testThread.flamMap.writeOutputLayerGeotiff(JFlamMap.FMP_FUELMOISTURE10, test.outputPath + "_J_FUELMOISTURE10.tif");
			testThread.flamMap.writeOutputLayerGeotiff(JFlamMap.FMP_FUELMOISTURE100, test.outputPath + "_J_FUELMOISTURE100.tif");
			testThread.flamMap.writeOutputLayerGeotiff(JFlamMap.FMP_FUELMOISTURE1000, test.outputPath + "_J_FUELMOISTURE1000.tif");
			//windninja output
			testThread.flamMap.writeOutputLayerGeotiff(JFlamMap.FMP_WINDDIRGRID, test.outputPath + "_J_WINDDIRGRID.tif");
			testThread.flamMap.writeOutputLayerGeotiff(JFlamMap.FMP_WINDSPEEDGRID, test.outputPath + "_J_WINDSPEEDGRID.tif");
			//everything in a GeoTIFF
			testThread.flamMap.writeAllOutputLayersGeotiff(test.outputPath + "_J_FlamMapALL.tif");
			testThread.flamMap.writeOutputLayersGeotiff(iftdssIDs, test.outputPath + "_J_FlamMapALLbyIds.tif");
		
		} catch (Exception e){
			e.printStackTrace();
		}finally
		{
			System.out.println("JFlamMapTest complete");
		}
	}

	

}
