package jrandig;

public class JRandig
{
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

	public static final int RANDIG_BURN_PROBABILITY = 70;
	public static final int RANDIG_FLP_CLASS_0_2 = 71;
	public static final int RANDIG_FLP_CLASS_2_4 = 72;
	public static final int RANDIG_FLP_CLASS_4_6 = 73;
	public static final int RANDIG_FLP_CLASS_6_8 = 74;
	public static final int RANDIG_FLP_CLASS_8_12 = 75;
	public static final int RANDIG_FLP_CLASS_12_PLUS = 76;
	public static final int RANDIG_CONDITIONAL_FLAMELENGTH = 77;
	
	//used to hold the C++ CRandigLib object pointer
	private long randigObj;

	// create native object
	private native long create();

	// destroy native object
	private native void destroy(long p);

	//native CRandigLib routines

	private native int loadinputsfile(long p, String inputsfilename);

	private native String geterrormessage(long p, int errornumber);

	private native int launchrandig(long p);

	private native int cancelrandig(long p);

	private native double getprogress(long p);

	private native int getnumfirestodo(long p);

	private native int getnumfirescomplete(long p);

	private native int writefiresizelist(long p, String targetname);

	private native int writetimingsfile(long p, String targetname);

	private native int writeoutputlayersgeotiff(long p, int[] layerIDs,  String name);

	private native int writeoutputlayerascii(long p, int layer,  String name);
	
	private native int writeperimetersshapefile(long p, String name);

	private native int writeembersshapefile(long p, String name);

	private native int writeemberscsvfile(long p, String name);
	
	private native int writewindvectorkml(long p, String name, double resolution);

	private native double getwindvectorkmlresolution(long p);

	private native int getnummttfailures(long p);
	
	private native double getproportionburned(long p);

	static
	{
		try
		{
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
			System.loadLibrary("RandigLib");
			System.loadLibrary("JRandigLib");

		}
		catch (UnsatisfiedLinkError e)
		{
			System.err.println(e);
		}
	}

	//constructor
	public JRandig()
	{
		randigObj = create();
	}

	//destroy native object if it exists
	public synchronized void destroy()
	{
		if (randigObj != 0)
		{
			destroy(randigObj);
			randigObj = 0;
		}
	}

	//wrappers for native CRandig routines
	public synchronized int loadInputsFile(String inputsfilename)
	{
		if (randigObj == 0)
		{
			throw new IllegalStateException("loadInputsFile called with NULL object");
		}
		return loadinputsfile(randigObj, inputsfilename);
	}

	public String getErrorMessage(int errornumber)
	{
		if (randigObj == 0)
		{
			throw new IllegalStateException("getErrorMessage called with NULL object");
		}
		return geterrormessage(randigObj, errornumber);
	}

	public int launchRandig()
	{
		if (randigObj == 0)
		{
			throw new IllegalStateException("launchRandig called with NULL object");
		}
		return launchrandig(randigObj);
	}

	public int cancelRandig()
	{
		if (randigObj == 0)
		{
			throw new IllegalStateException("cancelRandig called with NULL object");
		}
		return cancelrandig(randigObj);
	}

	public double getProgress()
	{
		if (randigObj == 0)
		{
			throw new IllegalStateException("getProgress called with NULL object");
		}
		return getprogress(randigObj);
	}

	public int getNumFiresToDo()
	{
		if (randigObj == 0)
		{
			throw new IllegalStateException("getNumFiresToDo called with NULL object");
		}
		return getnumfirestodo(randigObj);
	}

	public int getNumFiresComplete()
	{
		if (randigObj == 0)
		{
			throw new IllegalStateException("getNumFiresComplete called with NULL object");
		}
		return getnumfirescomplete(randigObj);
	}

	public int writeFireSizeList(String targetName)
	{
		if (randigObj == 0)
		{
			throw new IllegalStateException("writeFireSizeList called with NULL object");
		}
		return writefiresizelist(randigObj, targetName);
	}

	public int writeTimingsFile(String targetName)
	{
		if (randigObj == 0)
		{
			throw new IllegalStateException("writeTimingsFile called with NULL object");
		}
		return writetimingsfile(randigObj, targetName);
	}

	public int writeOutputLayersGeotiff(int[] layerIDs, String name)
	{
		if (randigObj == 0)
		{
			throw new IllegalStateException("writeOutputLayersGeotiff called with NULL object");
		}
		return writeoutputlayersgeotiff(randigObj, layerIDs, name);
	}

	public int writeOutputLayerASCII(int layer, String name)
	{
		if (randigObj == 0)
		{
			throw new IllegalStateException("writeOutputLayerASCII called with NULL object");
		}
		return writeoutputlayerascii(randigObj, layer, name);
	}

	public int writePerimetersShapefile(String name)
	{
		if (randigObj == 0)
		{
			throw new IllegalStateException("writePerimetersShapefile called with NULL object");
		}
		return writeperimetersshapefile(randigObj, name);
	}
	
	public int writeEmbersShapefile(String name)
	{
		if (randigObj == 0)
		{
			throw new IllegalStateException("writeEmbersShapefile called with NULL object");
		}
		return writeembersshapefile(randigObj, name);
	}
	
	public int writeEmbersCsv(String name)
	{
		if (randigObj == 0)
		{
			throw new IllegalStateException("writeEmbersCsv called with NULL object");
		}
		return writeemberscsvfile(randigObj, name);
	}
	
	public int writeWindVectorKML(String name, double resolution)
	{
		if (randigObj == 0)
		{
			throw new IllegalStateException("writeWindVectorKML called with NULL object");
		}
		return writewindvectorkml(randigObj, name, resolution);
	}

	public double getWindVectorKMLResolution()
	{
		if (randigObj == 0)
		{
			throw new IllegalStateException("getWindVectorKMLResolution called with NULL object");
		}
		return getwindvectorkmlresolution(randigObj);
	}

	public int getNumMttFailures()
	{
		if (randigObj == 0)
		{
			throw new IllegalStateException("getNumMttFailures called with NULL object");
		}
		return getnummttfailures(randigObj);
	}
	
	public double getProportionBurned()
	{
		if (randigObj == 0)
		{
			throw new IllegalStateException("getProportionBurned called with NULL object");
		}
		return getproportionburned(randigObj);
	}
	// destroy native object if it's still around
	// when finalize called from garbage collection
	public void finalize()
	{
		destroy();
	}
}