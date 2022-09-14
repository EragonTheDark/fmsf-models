package jspatialfofem;


public class JSpatialFOFEMTest {
	public String inputFilePath;
	public String outputPath;

	public static void main(String[] args)
	{
		try
		{
			if(args.length < 2)
			{
				System.out.println("JSpatialFOFEMTest requires two arguments:\n"
						+ "inputsFilePath, outputPath\n"
						+ "where outputPath is complete path plus base filename for the output, e.g. C:\\output\\test\n");
				return;
			}
			JSpatialFOFEMTest test = new JSpatialFOFEMTest();
			test.inputFilePath = args[0];
			test.outputPath = args[1];

			JSpatialFOFEMTestThread testThread = new JSpatialFOFEMTestThread();
			testThread.inputFilePath = test.inputFilePath;
			testThread.outputPath = test.outputPath;
			
			testThread.start();
			double fProgress = 0.0;
			while (testThread.isAlive() == true)
			{
				if (testThread.spatialFOFEM != null)
				{
					fProgress = testThread.spatialFOFEM.getProgress();
					System.out.println("JSpatialFOFEM Progress: " + fProgress);
				}
				Thread.sleep(1000);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("JSpatialFOFEMTest complete");
		}
	}
}
