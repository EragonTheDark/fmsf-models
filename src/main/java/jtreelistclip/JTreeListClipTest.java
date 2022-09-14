package jtreelistclip;

public class JTreeListClipTest {
	public String nationalTreeListPath;
	public String outputPath;
	
	public double lonMin = -123.800394;
	public double lonMax = -123.599852;
	public double latMin = 41.749749;
	public double latMax = 41.850496;
	
	public static void main(String[] args)
	{
		
		try
		{
			if(args.length < 6)
			{
				System.out.println("JTreeListClipTest requires six arguments:\n"
						+ "nationalTreeListFilePath, minLat, minLon, maxLat, maxLon, outputPath\n"
						+ "\twhere nationalTreeListFilePath is the complete path to the national tree list GeoTIFF\n"
						+ "\tminLat is minimum Latitude\n"
						+ "\tminLon is minimum Longitude\n"
						+ "\tmaxLat is maximum Latitude\n"
						+ "\tmaxLon is maximum Longitude\n"
						+ "\toutputPath is complete path to the output GeoTIFF, e.g. C:\\output\\test.tif\n");
				return;
			}
			JTreeListClipTest test = new JTreeListClipTest();
			test.nationalTreeListPath = args[0];
			test.latMin = Double.valueOf(args[1]);
			test.lonMin = Double.valueOf(args[2]);
			test.latMax = Double.valueOf(args[3]);
			test.lonMax = Double.valueOf(args[4]);
			test.outputPath = args[5];
			JTreeListClip  testClip = new JTreeListClip();
			int status = testClip.setNationalLayerPath(test.nationalTreeListPath);
			if(status != testClip.TL_ERROR_NONE)
			{
				System.out.println("setNationalLayerPath returned error code: " + status);
				System.out.println(testClip.getErrorMessage(status));
				return;
			}
			status = testClip.setLatLonExtent(test.latMin, test.lonMin, test.latMax, test.lonMax);
			if(status != testClip.TL_ERROR_NONE)
			{
				System.out.println("setExtent returned error code: " + status);
				System.out.println(testClip.getErrorMessage(status));
				return;
			}
			status = testClip.createOutputFile(test.outputPath);
			if(status != testClip.TL_ERROR_NONE)
			{
				System.out.println("createOutputFile returned error code: " + status);
				System.out.println(testClip.getErrorMessage(status));
				return;
			}
			//output the result GeoTIFF information
			//double res = testClip.getOutputResolution();
			System.out.println("getOutputResolution() returned: " + testClip.getOutputResolution());
			System.out.println("getOutputNumRows() returned: " + testClip.getOutputNumRows());
			System.out.println("getOutputNumCols() returned: " + testClip.getOutputNumCols());
			System.out.println("getOutputLowerLeftX() returned: " + testClip.getOutputLowerLeftX());
			System.out.println("getOutputLowerLeftY() returned: " + testClip.getOutputLowerLeftY());
			System.out.println("getOutputLowerRightX() returned: " + testClip.getOutputLowerRightX());
			System.out.println("getOutputLowerRightY() returned: " + testClip.getOutputLowerRightY());
			
			System.out.println("getOutputUpperLeftX() returned: " + testClip.getOutputUpperLeftX());
			System.out.println("getOutputUpperLeftY() returned: " + testClip.getOutputUpperLeftY());
			System.out.println("getOutputUpperRightX() returned: " + testClip.getOutputUpperRightX());
			System.out.println("getOutputUpperRightY() returned: " + testClip.getOutputUpperRightY());

			System.out.println("getOutputProjection() returned:");
			String prjStr = testClip.getOutputProjection();
			System.out.println(prjStr);
		
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("JTreeListClipTest complete");
		}
	}
}
