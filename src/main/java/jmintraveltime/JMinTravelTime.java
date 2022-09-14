package jmintraveltime;

public class JMinTravelTime
{
	
	//flammap output layers and access ID's
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
	
	public static final int MTT_ARRIVAL_TIME = 50;
	public static final int MTT_SPREAD_RATE = 51;
	public static final int MTT_INFLUENCE = 52;
	public static final int MTT_INTENSITY = 53;
	public static final int MTT_FLAME_LENGTH = 54;
	public static final int MTT_IGNITION = 55;
	
	//used to hold the C++ CMinTravelTime object pointer
	private long mttObj;

	// create native object
	private native long create();

	// destroy native object
	private native void destroy(long p);

	//native CMinTravelTime routines

	//inputs
	private native int setlandscapefile(long p, String lcpfilename);

	private native int loadmtttextsettingsfile(long p, String mttfilename);

	private native String getmttinputserrormessage(long p, int errornumber);

	private native double setresolution(long p, double res);
	
	private native int setignition(long p, String ignitionfilename);

	private native int setbarrier(long p, String barrierfilename);

	private native long setmaxsimtime(long p, long minutes);

	private native long setpathinterval(long p, long interval);

	private native int setnumprocessors(long p, int numprocessors);

	private native int setstartprocessor(long p, int procnum);

	//process control
	private native int launchmtt(long p);

	private native int canlaunchmtt(long p);

	private native int cancelmtt(long p);

	private native double getmttprogress(long p);

	//outputs
	private native int writerosgrid(long p, String name);
	private native int writearrivaltimegrid(long p, String name);
	private native int writeflimapgrid(long p, String name);
	private native int writeinfluencegrid(long p, String name);
	private native int writeflammapoutputlayerascii(long p, int layer, String name);
	private native int writeflowpathsshapefile(long p, String name);
	private native int writemajorpathsshapefile(long p, String name);
	private native int writewindvectorkml(long p, String name, double resolution);
	private native double getwindvectorkmlresolution(long p);
	private native String geterrormessage(long p, int errornumber);

	private native int writeoutputlayersgeotiff(long p, int[] layerIDs,  String name);
	private native int writeembersshapefile(long p, String name);
	private native int writeemberscsvfile(long p, String name);
	private native int writeflamelengthgrid(long p, String name);
	private native int writeignitiongrid(long p, String name);
	
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
			System.loadLibrary("FUELCONDITION");
			System.loadLibrary("FlamMap");
			System.loadLibrary("NodeSpread");
			System.loadLibrary("JMinTravelTimeLib");
		}
		catch (UnsatisfiedLinkError e)
		{
			System.err.println(e);
		}
	}

	//constructor
	public JMinTravelTime()
	{
		mttObj = create();
	}

	//destroy native object if it exists
	public synchronized void destroy()
	{
		if (mttObj != 0)
		{
			destroy(mttObj);
			mttObj = 0;
		}
	}

	//wrappers for native CMinTravelTime routines
	//inputs
	public synchronized int setLandscapeFile(String lcpFileName)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("setLandscapeFile called with NULL object");
		}
		return setlandscapefile(mttObj, lcpFileName);
	}

	public synchronized int loadMTTTextSettingsFile(String mttfilename)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("loadMTTTextSettingsFile called with NULL object");
		}
		return loadmtttextsettingsfile(mttObj, mttfilename);
	}


	public String getMTTInputsErrorMessage(int errornumber)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("getMTTInputsErrorMessage called with NULL object");
		}
		return getmttinputserrormessage(mttObj, errornumber);
	}

	public double setResolution(double res)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("setResolution called with NULL object");
		}
		return setresolution(mttObj, res);
	}

	public synchronized int setIgnition(String ignitionfilename)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("setIgnition called with NULL object");
		}
		return setignition(mttObj, ignitionfilename);
	}

	public synchronized int setBarrier(String barrierfilename)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("setBarrier called with NULL object");
		}
		return setbarrier(mttObj, barrierfilename);
	}

	public long setMaxSimTime(long minutes)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("setMaxSimTime called with NULL object");
		}
		return setmaxsimtime(mttObj, minutes);
	}

	public long setPathInterval(long interval)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("setPathInterval called with NULL object");
		}
		return setpathinterval(mttObj, interval);
	}

	public long setNumProcessors(int numprocessors)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("setNumProcessors called with NULL object");
		}
		return setnumprocessors(mttObj, numprocessors);
	}

	public int setStartProcessor(int procNum)//zero based processor number!
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("setStartProcessor called with NULL object");
		}
		return setstartprocessor(mttObj, procNum);
	}

	//process control
	public int launchMTT()
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("launchMTT called with NULL object");
		}
		return launchmtt(mttObj);
	}

	public int canLaunchMTT()
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("canLaunchMTT called with NULL object");
		}
		return canlaunchmtt(mttObj);
	}

	public int cancelMTT()
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("cancelMTT called with NULL object");
		}
		return cancelmtt(mttObj);
	}

	public double getMTTProgress()
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("getMTTProgress called with NULL object");
		}
		return getmttprogress(mttObj);
	}

	//outputs

	public int writeROSGrid(String name)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("writeROSGrid called with NULL object");
		}
		return writerosgrid(mttObj, name);
	}

	public int writeArrivalTimeGrid(String name)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("writeArrivalTimeGrid called with NULL object");
		}
		return writearrivaltimegrid(mttObj, name);
	}

	public int writeFliMapGrid(String name)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("writeFliMapGrid called with NULL object");
		}
		return writeflimapgrid(mttObj, name);
	}

	public int writeInfluenceGrid(String name)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("writeInfluenceGrid called with NULL object");
		}
		return writeinfluencegrid(mttObj, name);
	}

	public int writeFlamMapOutputLayerAscii(int layer, String name)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("writeFlamMapOutputLayerAscii called with NULL object");
		}
		return writeflammapoutputlayerascii(mttObj, layer, name);
	}

	public int writeFlowPathsShapeFile(String name)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("writeFlowPathsShapeFile called with NULL object");
		}
		return writeflowpathsshapefile(mttObj, name);
	}

	public int writeMajorPathsShapeFile(String name)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("writeMajorPathsShapeFile called with NULL object");
		}
		return writemajorpathsshapefile(mttObj, name);
	}

	public int writeWindVectorKML(String name, double resolution)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("writeWindVectorKML called with NULL object");
		}
		return writewindvectorkml(mttObj, name, resolution);
	}

	public double getWindVectorKMLResolution()
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("writeWindVectorKML called with NULL object");
		}
		return getwindvectorkmlresolution(mttObj);
	}

	public String getErrorMessage(int errornumber)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("getErrorMessage called with NULL object");
		}
		return geterrormessage(mttObj, errornumber);
	}

	public int writeOutputLayersGeotiff(int[] layerIDs, String name)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("writeOutputLayersGeotiff called with NULL object");
		}
		return writeoutputlayersgeotiff(mttObj, layerIDs, name);
	}

	public int writeEmbersShapeFile(String name)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("writeEmbersShapeFile called with NULL object");
		}
		return writeembersshapefile(mttObj, name);
	}
	
	public int writeEmbersCsvFile(String name)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("writeEmbersCsvFile called with NULL object");
		}
		return writeemberscsvfile(mttObj, name);
	}
	
	public int writeFlameLengthGrid(String name)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("writeFlameLengthGrid called with NULL object");
		}
		return writeflamelengthgrid(mttObj, name);
	}
	
	public int writeIgnitionGrid(String name)
	{
		if (mttObj == 0)
		{
			throw new IllegalStateException("writeIgnitionGrid called with NULL object");
		}
		return writeignitiongrid(mttObj, name);
	}
	// destroy native object if it's still around
	// when finalize called from garbage collection
	public void finalize()
	{
		destroy();
	}

}