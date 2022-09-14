package jfspro;

public class JFSPro 
{
	//outputs available in GeoTIFF
	public static final int FSPRO_BURN_PROBABILITY = 90;	
	public static final int FSPRO_AVERAGE_FLAMELENGTH = 91;	
	public static final int FSPRO_AVERAGE_ARRIVAL_TIME = 92;	
	public static final int FSPRO_SUPPRESION_BURN_PROBABILTY = 93;	
	public static final int FSPRO_IGNITION = 94;
	
	//used to hold the C++ CFSProManager object pointer
	private long fsproObj;

	// create native object
	private native long create();

	// destroy native object
	private native void destroy(long p);

	//native CFSPro routines
	private native int setlandscapefile(long p, String lcpfilename);

	private native int loadfsproinputsfile(long p, String fsprofilename);

	private native int launchfspro(long p);

	private native int cancelfspro(long p);

	private native int getnumfirestodo(long p);

	private native int getnumfirescomplete(long p);

	private native double getfinalfiresize(long p, long firenum);
	
	private native String geterrormessage(long p, int errornumber);

	private native int writeprobabilitygrid(long p, String outputFileName);

	private native int writeaverageflamelengthgrid(long p, String outputFileName);

	private native int writeaveragetimegrid(long p, String outputfilename);

	private native int writeignitiongrid(long p, String outputfilename);

	private native int writearrivaldaydistribution(long p, String outputfilenamenoextension);//No extension!!!!!!!!

	private native int writedailyacres(long p, String outputfilename);
	
	private native int writeeventcoverage(long p, String outputfilename);

	private native int writesuppressionprobabilitygrid(long p, String outputFileName);

	private native int writefireperimeters(long p, String outputFileName);

	private native int writecontainsummary(long p, String outputFileName);

	private native int writedaytypes(long p, String outputFileName);

	private native int writefirestreams(long p, String outputFileName);

	private native int writetimings(long p, String outputFileName);

	private native double getcontaingreaterthan50percent(long p);
	
	private native double getcontainaveragemaxprob(long p);

	private native int getnumwinddirs(long p);

	private native int getnumwindspeeds(long p);

	private native int getwinddir(long p, int windDirClass);

	private native int getwindspeed(long p, int windSpeedClass);
	
	private native double getfiredailyacres(long p, int fire, int day);
	
	private native int getfireerc(long p, int fire, int day);
	
	private native int getfireercclass(long p, int fire, int day);

	private native int getfirewindspeed(long p, int fire, int day);

	private native int getfirewinddir(long p, int fire, int day);

	private native int getnumburndays(long p);
	
	private native int writeoutputlayersgeotiff(long p, int[] layerIDs,  String name);

	static
	{
		try
		{//FlamMap block of dependent DLLs
			System.loadLibrary("concrt140");
			System.loadLibrary("msvcp140");
			System.loadLibrary("vcruntime140");
			System.loadLibrary("vcruntime140_1");
			System.loadLibrary("gdal304");
			System.loadLibrary("vcomp140");
			System.loadLibrary("WindNinja2");
			System.loadLibrary("FUELCONDITION");
			System.loadLibrary("FlamMap");
			System.loadLibrary("NodeSpreadST");
			System.loadLibrary("FSProServer");
			System.loadLibrary("FSProManager");
			System.loadLibrary("FSPro");
			System.loadLibrary("JFSProLib");
		}
		catch (UnsatisfiedLinkError e)
		{
			System.err.println(e);
		}
	}
	
	public JFSPro()
	{
		fsproObj = create();
	}
	
	public void destroy()
	{
		if (fsproObj != 0)
		{
			destroy(fsproObj);
			fsproObj = 0;
		}
	}

	//wrappers for native CFSPro routines
	public int setLandscapeFile(String lcpFileName)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("setLandscapeFile called with NULL object");
		}
		return setlandscapefile(fsproObj, lcpFileName);
	}

	public int loadFsproSettingsFile(String fsproFileName)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("loadFsproSettingsFile called with NULL object");
		}
		return loadfsproinputsfile(fsproObj, fsproFileName);
	}

	public int launchFspro()
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("launchFspro called with NULL object");
		}
		return launchfspro(fsproObj);
	}


	public int cancelFspro()
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("cancelFspro called with NULL object");
		}
		return cancelfspro(fsproObj);
	}
	
	public String getFSProErrorMessage(int errornumber)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("getFSProInputsErrorMessage called with NULL object");
		}
		return geterrormessage(fsproObj, errornumber);
	}

	public int getNumFiresToDo()
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("getNumFiresToDo called with NULL object");
		}
		return getnumfirestodo(fsproObj);
	}

	public int getNumFiresComplete()
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("getNumFiresComplete called with NULL object");
		}
		return getnumfirescomplete(fsproObj);
	}

	public double getFinalFireSize(long firenum)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("getFinalFireSize called with NULL object");
		}
		return getfinalfiresize(fsproObj, firenum);
	}

	public synchronized int writeProbabilityGrid(String outputFileName)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("writeProbabilityGrid called with NULL object");
		}
		return writeprobabilitygrid(fsproObj, outputFileName);
	}

	public int writeIgnitionGrid(String outputfilename)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("writeAverageTimeGrid called with NULL object");
		}
		return writeignitiongrid(fsproObj, outputfilename);
	}

	public int writeAverageTimeGrid(String outputfilename)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("writeAverageTimeGrid called with NULL object");
		}
		return writeaveragetimegrid(fsproObj, outputfilename);
	}

	public int writeArrivalDayDistribution(String outputfilename)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("writeArrivalDayDistribution called with NULL object");
		}
		return writearrivaldaydistribution(fsproObj, outputfilename);
	}

	public int writeDailyAcres(String outputfilename)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("writeDailyAcres called with NULL object");
		}
		return writedailyacres(fsproObj, outputfilename);
	}

	public int writeEventCoverage(String outputfilename)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("writeEventCoverage called with NULL object");
		}
		return writeeventcoverage(fsproObj, outputfilename);
	}
	
	public synchronized int writeSuppressionProbabilityGrid(String outputFileName)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("writeSuppressionProbabilityGrid called with NULL object");
		}
		return writesuppressionprobabilitygrid(fsproObj, outputFileName);
	}

	public synchronized int writeFirePerimeters(String outputFileName)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("writeFirePerimeters called with NULL object");
		}
		return writefireperimeters(fsproObj, outputFileName);
	}

	public double getContainGreaterThan50Percent()
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("getContainGreaterThan50Percent called with NULL object");
		}
		return getcontaingreaterthan50percent(fsproObj);
	}

	public double getContainAverageMaxProb()
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("getContainAverageMaxProb called with NULL object");
		}
		return getcontainaveragemaxprob(fsproObj);
	}

	public int getNumWindDirs()
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("getNumWindDirs called with NULL object");
		}
		return getnumwinddirs(fsproObj);
	}

	public int getNumWindSpeeds()
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("getNumWindSpeeds called with NULL object");
		}
		return getnumwindspeeds(fsproObj);
	}
	
	public int getWindSpeed(int windSpeedClass)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("getWindSpeed called with NULL object");
		}
		return getwindspeed(fsproObj, windSpeedClass);
	}
	
	public int getWindDir(int windDirClass)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("getWindDir called with NULL object");
		}
		return getwinddir(fsproObj, windDirClass);
	}

	public double getFireDailyAcres(int fire, int day)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("getFireDailyAcres called with NULL object");
		}
		return getfiredailyacres(fsproObj, fire, day);
	}
	
	public int getFireERC(int fire, int day)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("getFireERC called with NULL object");
		}
		return getfireerc(fsproObj, fire, day);
	}

	public int getFireErcClass(int fire, int day)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("getFireErcClass called with NULL object");
		}
		return getfireercclass(fsproObj, fire, day);
	}
	
	public int getFireWindSpeed(int fire, int day)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("getFireWindSpeed called with NULL object");
		}
		return getfirewindspeed(fsproObj, fire, day);
	}
	
	public int getFireWindDir(int fire, int day)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("getFireWindDir called with NULL object");
		}
		return getfirewinddir(fsproObj, fire, day);
	}
	
	public int getNumBurndays()
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("getNumBurndays called with NULL object");
		}
		return getnumburndays(fsproObj);
	}
	
	public int writeContainSummary(String outputfilename)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("writeContainSummary called with NULL object");
		}
		return writecontainsummary(fsproObj, outputfilename);
	}
	
	public int writeDayTypes(String outputfilename)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("writeDayTypes called with NULL object");
		}
		return writedaytypes(fsproObj, outputfilename);
	}
	
	
	public int writeFireStreams(String outputfilename)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("writeFireStreams called with NULL object");
		}
		return writefirestreams(fsproObj, outputfilename);
	}
	
	public int writeTimings(String outputfilename)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("writeTimings called with NULL object");
		}
		return writetimings(fsproObj, outputfilename);
	}
	
	public int writeOutputLayersGeotiff(int[] layerIDs, String name)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("writeOutputLayersGeotiff called with NULL object");
		}
		return writeoutputlayersgeotiff(fsproObj, layerIDs, name);
	}

	public int writeAverageFlameLengthGrid(String outputfilename)
	{
		if (fsproObj == 0)
		{
			throw new IllegalStateException("writeAverageFlameLengthGrid called with NULL object");
		}
		return writeaverageflamelengthgrid(fsproObj, outputfilename);
	}


	// destroy native object if it's still around
	// when finalize called from garbage collection
	public void finalize()
	{
		destroy();
	}

}
