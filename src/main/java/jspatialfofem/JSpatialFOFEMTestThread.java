package jspatialfofem;

public class JSpatialFOFEMTestThread  extends Thread
{
	String inputFilePath = "";
	String outputPath = "";

	JSpatialFOFEM spatialFOFEM = null;
	public int returnCode = -1;
	public void run() 
	{
		spatialFOFEM = new JSpatialFOFEM();
		String path = inputFilePath;
		
		//load the inputs
		returnCode = spatialFOFEM.loadInputsFile(path);
		System.out.println("JSpatialFOFEM.loadInputsFile returned " + returnCode + " for " + path);
		if (returnCode != 1)
		{
			System.out.println("Error occurred loading the SpatialFOFEM input file - "
				+ returnCode + " returned for " + path);
			System.out.println("Error message - "
					+ spatialFOFEM.getErrorMessage(returnCode));
			return;
		}
		
		//run the simulation
		returnCode = spatialFOFEM.runSpatialFofem();
		if(returnCode != 1)
		{
			System.out.println("Error occurred running SpatialFOFEM - "
					+ returnCode + " - " + spatialFOFEM.getErrorMessage(returnCode));
				return;
		}
		
		//write the outputs
		System.out.println("SpatialFOFEM complete, writing outputs...");
		returnCode = spatialFOFEM.writeAllOutputLayersGeoTIFF(outputPath + "_AllOutputs.tif");
		if(returnCode != 1)
		{
			System.out.println("Error occurred in writeAllOutputLayersGeoTIFF - "
					+ returnCode + " - " + spatialFOFEM.getErrorMessage(returnCode));
		}
		returnCode = spatialFOFEM.writeStatisticsCSV(outputPath + "_Statistics.csv");
		if(returnCode != 1)
		{
			System.out.println("Error occurred in writeStatisticsCSV - "
					+ returnCode + " - " + spatialFOFEM.getErrorMessage(returnCode));
		}
		returnCode = spatialFOFEM.writeWarningsCSV(outputPath + "_Warnings.csv");
		if(returnCode != 1)
		{
			System.out.println("Error occurredin  writeWarningsCSV - "
					+ returnCode + " - " + spatialFOFEM.getErrorMessage(returnCode));
		}
		//demonstrate write writeOutputLayersGeoTIFF
		int layerIDs[] = new int[1];
		layerIDs[0] = JSpatialFOFEM.JSF_FLAMING_CO2;
		
		returnCode = spatialFOFEM.writeOutputLayersGeoTIFF(layerIDs, outputPath + "JSF_FLAMING_CO2.tif");
		if(returnCode != 1)
		{
			System.out.println("Error occurred in writeOutputLayersGeoTIFF - "
					+ returnCode + " - " + spatialFOFEM.getErrorMessage(returnCode));
		}
		System.out.println("JSpatialFOFEM Emmission and Consumption outputs (if any) written to " + outputPath);
	
		//attempt to write Mortality outputs
		returnCode = spatialFOFEM.writeMortalitySummaryCSV(outputPath + "_Mortality.csv");
		if(returnCode != 1)
		{
			System.out.println("Error occurred in writeMortalitySummaryCSV - "
					+ returnCode + " - " + spatialFOFEM.getErrorMessage(returnCode));
		}
		else
			System.out.println("JSpatialFOFEM Mortality Summary written to " + outputPath + "_Mortality.csv");
		//warning! This can produce a lot of files!!!!!
		returnCode = spatialFOFEM.writeAllMortalityGeoTIFFs(outputPath + "_");
		if(returnCode != 1)
		{
			System.out.println("Error occurred in writeMortalitySummaryCSV - "
					+ returnCode + " - " + spatialFOFEM.getErrorMessage(returnCode));
		}
		else
			System.out.println("JSpatialFOFEM Mortality GeoTIFFoutputs written to " + outputPath);
	}
}
