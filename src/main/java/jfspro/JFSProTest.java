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
 * TODO To change the template for this generated type comment go to Window - Preferences - Java -
 * Code Style - Code Templates
 */
public class JFSProTest
{

	public String landScapePath;// = "G:\\WFDSS\\2009\\29873\\29873.lcp";
	public String inputFilePath;// = "G:\\WFDSS\\2009\\29873\\29873.input";
	public String outputPath;// = "G:\\WFDSS\\2009\\29873\\J_29873_";

	public static void main(String[] args)
	{
		try
		{
			if(args.length < 3)
			{
				System.out.println("JFSProTest requires three arguments:\n"
						+ "landscapePath, inputsFilePath, outputPath\n"
						+ "where outputPath is complete path plus base filename for the output, e.g. C:\\output\\test\n");
				return;
			}
			JFSProTest test = new JFSProTest();
			test.landScapePath = args[0];
			test.inputFilePath = args[1];
			test.outputPath = args[2];

			JFSProTestThread testThread = new JFSProTestThread();
			testThread.landScapePath = test.landScapePath;
			testThread.inputFilePath = test.inputFilePath;
			testThread.outputPath = test.outputPath;
			
			testThread.start();
			int nToDo = 1, nComplete = 0;
			while (true)
			{
				if (testThread.fsPro != null)
				{
					Thread.sleep(1000);
					//System.out.println("starting");
					nToDo = testThread.fsPro.getNumFiresToDo();
					nComplete = testThread.fsPro.getNumFiresComplete();
					
					while (nToDo > nComplete)
					{
						System.out.println("Running fspro: "
							+ nComplete + " of " + nToDo);
						Thread.sleep(1000);
						nToDo = testThread.fsPro.getNumFiresToDo();
						nComplete = testThread.fsPro.getNumFiresComplete();
					/*BufferedReader cancelFile = new BufferedReader(new FileReader("cancel.txt"));
						String line = cancelFile.readLine();
						if (line != null)
						{
							testThread.fsPro.cancelFspro();
							System.out.println("Thread canceled");
							if(testThread.returnCode != -1)
							{
								System.exit(0);
							}
						}*/
						
					}
				}
				Thread.sleep(100);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
