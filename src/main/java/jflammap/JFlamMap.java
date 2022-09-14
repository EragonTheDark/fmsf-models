package jflammap;

public class JFlamMap
{
	//Landscape layers and access ID's
	public static final int LCP_ELEVATION = 0;
	public static final int LCP_SLOPE = 1;
	public static final int LCP_ASPECT = 2;
	public static final int LCP_FUELS = 3;
	public static final int LCP_CANOPY_COVER = 4;
	public static final int LCP_HEIGHT = 5;
	public static final int LCP_BASE_HEIGHT = 6;
	public static final int LCP_BULK_DENSITY = 7;
	public static final int LCP_DUFF = 8;
	public static final int LCP_WOODY = 9;
	
	//output layers and access ID's
	public static final int FMP_FLAMELENGTH = 0;
	public static final int FMP_SPREADRATE = 1;
	public static final int FMP_INTENSITY = 2;
	public static final int FMP_HEATAREA = 3;
	public static final int FMP_CROWNSTATE = 4;
	public static final int FMP_SOLARRADIATION = 5;
	public static final int FMP_FUELMOISTURE1 = 6;
	public static final int FMP_FUELMOISTURE10 = 7;
	public static final int FMP_MIDFLAME = 8;
	public static final int FMP_HORIZRATE = 9;
	public static final int FMP_MAXSPREADDIR = 10;
	public static final int FMP_ELLIPSEDIM_A= 11;
	public static final int FMP_ELLIPSEDIM_B= 12;
	public static final int FMP_ELLIPSEDIM_C= 13;
	public static final int FMP_MAXSPOT= 14;
	public static final int FMP_FUELMOISTURE100 = 15;
	public static final int FMP_FUELMOISTURE1000 = 16;
	public static final int FMP_CROWNFRACTIONBURNED = 17;
	public static final int FMP_TORCHING_INDEX = 18;
	public static final int FMP_CROWNING_INDEX = 19;
	public static final int FMP_MAXSPOT_DIR= 20;
	public static final int FMP_MAXSPOT_DX = 21;
	public static final int FMP_WINDDIRGRID = 22;
	public static final int FMP_WINDSPEEDGRID = 23;
	

	//used to hold the C++ CFlamMap object pointer
	private long flammapObj;

	// create native object
	private native long create();

	// destroy native object
	private native void destroy(long p);

	//native CFlamMap routines

	//inputs
	private native int setlandscapefile(long p, String lcpfilename);

	private native int setanalysisarea(long p, double tEast, double tWest, double tNorth, double tSouth);

	private native double getanalysiseast(long p);

	private native double getanalysiswest(long p);

	private native double getanalysisnorth(long p);

	private native double getanalysissouth(long p);

	private native int resamplelandscape(long p, double newRes);

	private native int loadflammaptextsettingsfile(long p, String flammapfilename);

	private native String getflammapinputserrormessage(long p, int errornumber);

	//process control
	private native int launchflammap(long p);

	private native int canlaunchflammap(long p);

	private native int cancelflammap(long p);

	private native double getflammapprogress(long p);

	//outputs
	private native double getlayervaluebycell(long p, int layer, int col, int row);

	private native double getlayervaluebycoords(long p, int layer, double east, double north);

	private native int writeoutputlayer(long p, int layer, String name);

	private native int writewindvectorkml(long p, String name, double resolution);

	private native double getwindvectorkmlresolution(long p);

	private native int setnumprocessors(long p, int numprocessors);

	private native int setstartprocessor(long p, int procnum);

	private native String geterrormessage(long p, int errornumber);
	
	private native int writeoutputlayergeotiff(long p, int layer, String name);

	private native int writealloutputlayersgeotiff(long p, String name);

	private native int writeoutputlayersgeotiff(long p, int[] layerIDs,  String name);

	static
	{
		try
		{
			System.loadLibrary("concrt140");
			System.loadLibrary("vcruntime140");
			System.loadLibrary("msvcp140");
			System.loadLibrary("vcruntime140");
			System.loadLibrary("vcruntime140_1");
			System.loadLibrary("gdal304");
			System.loadLibrary("WindNinja2");
			System.loadLibrary("FuelCondition");
			System.loadLibrary("FlamMap");
			System.loadLibrary("JFlamMapLib");

		}
		catch (UnsatisfiedLinkError e)
		{
			System.err.println(e);
		}
	}

	//constructor
	public JFlamMap()
	{
		flammapObj = create();
	}

	//destroy native object if it exists
	public synchronized void destroy()
	{
		if (flammapObj != 0)
		{
			destroy(flammapObj);
			flammapObj = 0;
		}
	}

	//wrappers for native CFlamMap routines
	//inputs
	public synchronized int setLandscapeFile(String lcpFileName)
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("setLandscapeFile called with NULL object");
		}
		return setlandscapefile(flammapObj, lcpFileName);
	}


	public synchronized  int setAnalysisArea(double tEast, double tWest, double tNorth, double tSouth)
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("setAnalysisArea called with NULL object");
		}
		return setanalysisarea(flammapObj, tEast, tWest, tNorth, tSouth);
	}

	public double getAnalysisEast()
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("getAnalysisEast called with NULL object");
		}
		return getanalysiseast(flammapObj);
	}


	public double getAnalysisWest()
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("getAnalysisWest called with NULL object");
		}
		return getanalysiswest(flammapObj);
	}


	public double getAnalysisNorth()
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("getAnalysisNorth called with NULL object");
		}
		return getanalysisnorth(flammapObj);
	}

	public double getAnalysisSouth()
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("getAnalysisSouth called with NULL object");
		}
		return getanalysissouth(flammapObj);
	}


	public synchronized  int resampleLandscape(double newRes)
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("resampleLandscape called with NULL object");
		}
		return resamplelandscape(flammapObj, newRes);
	}


	public synchronized int loadFlamMapTextSettingsFile(String flammapfilename)
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("loadFlamMapTextSettingsFile called with NULL object");
		}
		return loadflammaptextsettingsfile(flammapObj, flammapfilename);
	}


	public String getFlamMapInputsErrorMessage(int errornumber)
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("getFlamMapInputsErrorMessage called with NULL object");
		}
		return getflammapinputserrormessage(flammapObj, errornumber);
	}


	//process control
	public int launchFlamMap()
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("launchFlamMap called with NULL object");
		}
		return launchflammap(flammapObj);
	}

	public int canLaunchFlamMap()
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("canLaunchFlamMap called with NULL object");
		}
		return canlaunchflammap(flammapObj);
	}

	public int cancelFlamMap()
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("cancelFlamMap called with NULL object");
		}
		return cancelflammap(flammapObj);
	}

	public double getFlamMapProgress()
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("getFlamMapProgress called with NULL object");
		}
		return getflammapprogress(flammapObj);
	}

	//outputs
	public double getLayerValueByCell(int layer, int col, int row)
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("getLayerValueByCell called with NULL object");
		}
		return getlayervaluebycell(flammapObj, layer, col, row);
	}


	public double getLayerValueByCoords(int layer, double east, double north)
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("getLayerValueByCoords called with NULL object");
		}
		return getlayervaluebycoords(flammapObj, layer, east, north);
	}

	public int writeOutputLayer(int layer, String name)
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("writeOutputLayer called with NULL object");
		}
		return writeoutputlayer(flammapObj, layer, name);
	}

	public int writeWindVectorKML(String name, double resolution)
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("writeWindVectorKML called with NULL object");
		}
		return writewindvectorkml(flammapObj, name, resolution);
	}

	public double getWindVectorKMLResolution()
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("getWindVectorKMLResolution called with NULL object");
		}
		return getwindvectorkmlresolution(flammapObj);
	}

	public int setNumProcessors(int numProcessors)
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("setNumProcessors called with NULL object");
		}
		return setnumprocessors(flammapObj, numProcessors);
	}

	public int setStartProcessor(int procNum)//zero based processor number!
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("setStartProcessor called with NULL object");
		}
		return setstartprocessor(flammapObj, procNum);
	}

	public String getErrorMessage(int errornumber)
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("getErrorMessage called with NULL object");
		}
		return geterrormessage(flammapObj, errornumber);
	}

	public int writeOutputLayerGeotiff(int layer, String name)
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("writeOutputLayerGeotiff called with NULL object");
		}
		return writeoutputlayergeotiff(flammapObj, layer, name);
	}

	public int writeAllOutputLayersGeotiff(String name)
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("writeAllOutputLayersGeotiff called with NULL object");
		}
		return writealloutputlayersgeotiff(flammapObj, name);
	}

	public int writeOutputLayersGeotiff(int[] layerIDs, String name)
	{
		if (flammapObj == 0)
		{
			throw new IllegalStateException("writeOutputLayersGeotiff called with NULL object");
		}
		return writeoutputlayersgeotiff(flammapObj, layerIDs, name);
	}

	// destroy native object if it's still around
	// when finalize called from garbage collection
	public void finalize()
	{
		destroy();
	}

}