package jfarsite;


public class JFarsite 
{
	public static final int FARSITE_ARRIVAL_TIME = 0;
	public static final int FARSITE_CROWNSTATE = 1;
	public static final int FARSITE_FLAME_LENGTH = 2;
	public static final int FARSITE_HEAT_PER_UNIT_AREA = 3;
	public static final int FARSITE_IGNITION = 4;
	public static final int FARSITE_INTENSITY = 5;
	public static final int FARSITE_REACTION_INTENSITY = 6;
	public static final int FARSITE_SPREAD_DIRECTION = 7;
	public static final int FARSITE_SPREAD_RATE = 8;
	
	//used to hold the C++ CFarsite object pointer
	private long farsiteObj;

	// create native object
	private native long create();

	// destroy native object
	private native void destroy(long p);

	//native CFlamMap routines

	//inputs
	private native int setlandscapefile(long p, String lcpfilename);

	private native int loadfarsitetextsettingsfile(long p, String farsitefilename);

	private native String getfarsiteinputserrormessage(long p, int errornumber);

	private native int setignition(long p, String ignitionfilename);

	private native int setbarrier(long p, String barrierfilename);

	//process control
	private native int launchfarsite(long p);

	private native int canlaunchfarsite(long p);

	private native int cancelfarsite(long p);

	private native double getfarsiteprogress(long p);
	
	//output functions

	private native int writearrivaltimegrid(long p, String name);
	
	private native int writeintensitygrid(long p, String name);
	
	private native int writeflamelengthgrid(long p, String name);
	
	private native int writespreadrategrid(long p, String name);
	
	private native int writespreaddirectiongrid(long p, String name);
	
	private native int writeheatperunitareagrid(long p, String name);
	
	private native int writereactionintensitygrid(long p, String name);
	
	private native int writecrownfiregrid(long p, String name);
	
	private native int writeperimetersshapefile(long p, String name);

	private native int writetimingsfile(long p, String name);
	
	private native int getnumignitioncells(long p);
	
	private native int getnumedgehits(long p);
	
	private native int writeoutputlayersgeotiff(long p, int[] layerIDs,  String name);

	private native int writeignitiongrid(long p, String name);
	
	private native int writespotfirecsv(long p, String name);
	
	private native int writespotfireshapefile(long p, String name);
	
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
			System.loadLibrary("FARSITE");
			System.loadLibrary("JFarsiteLib");
		}
		catch (UnsatisfiedLinkError e)
		{
			System.err.println(e);
		}
	}
	
	//constructor
	public JFarsite()
	{
		farsiteObj = create();
	}

	//destroy native object if it exists
	public synchronized void destroy()
	{
		if (farsiteObj != 0)
		{
			destroy(farsiteObj);
			farsiteObj = 0;
		}
	}

	//wrappers for native CFarsite routines
	//inputs
	public synchronized int setLandscapeFile(String lcpFileName)
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("setLandscapeFile called with NULL object");
		}
		return setlandscapefile(farsiteObj, lcpFileName);
	}

	public synchronized int loadFarsiteTextSettingsFile(String mttfilename)
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("loadFarsiteTextSettingsFile called with NULL object");
		}
		return loadfarsitetextsettingsfile(farsiteObj, mttfilename);
	}


	public String getFarsiteInputsErrorMessage(int errornumber)
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("getFarsiteInputsErrorMessage called with NULL object");
		}
		return getfarsiteinputserrormessage(farsiteObj, errornumber);
	}

	public synchronized int setIgnition(String ignitionfilename)
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("setIgnition called with NULL object");
		}
		return setignition(farsiteObj, ignitionfilename);
	}

	public synchronized int setBarrier(String barrierfilename)
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("setBarrier called with NULL object");
		}
		return setbarrier(farsiteObj, barrierfilename);
	}

	//process control
	public int launchFarsite()
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("launchFarsite called with NULL object");
		}
		return launchfarsite(farsiteObj);
	}

	public int canLaunchFarsite()
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("canLaunchFarsite called with NULL object");
		}
		return canlaunchfarsite(farsiteObj);
	}

	public int cancelFarsite()
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("cancelFarsite called with NULL object");
		}
		return cancelfarsite(farsiteObj);
	}

	public double getFarsiteProgress()
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("getFarsiteProgress called with NULL object");
		}
		return getfarsiteprogress(farsiteObj);
	}

	//output functions
	public int writeArrivalTimeGrid(String name)
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("writeArrivalTimeGrid called with NULL object");
		}
		return writearrivaltimegrid(farsiteObj, name);
	}

	public int writeIntensityGrid(String name)
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("writeIntensityGrid called with NULL object");
		}
		return writeintensitygrid(farsiteObj, name);
	}

	public int writeFlameLengthGrid(String name)
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("writeFlameLengthGrid called with NULL object");
		}
		return writeflamelengthgrid(farsiteObj, name);
	}

	public int writeSpreadRateGrid(String name)
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("writeSpreadRateGrid called with NULL object");
		}
		return writespreadrategrid(farsiteObj, name);
	}

	public int writeSpreadDirectionGrid(String name)
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("writeSpreadDirectionGrid called with NULL object");
		}
		return writespreaddirectiongrid(farsiteObj, name);
	}

	public int writeHeatPerUnitAreaGrid(String name)
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("writeHeatPerUnitAreaGrid called with NULL object");
		}
		return writeheatperunitareagrid(farsiteObj, name);
	}

	public int writeReactionIntensityGrid(String name)
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("writeReactionIntensityGrid called with NULL object");
		}
		return writereactionintensitygrid(farsiteObj, name);
	}

	public int writeCrownFireGrid(String name)
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("writeCrownFireGrid called with NULL object");
		}
		return writecrownfiregrid(farsiteObj, name);
	}

	public int writeIgnitionGrid(String name)
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("writeIgnitionGrid called with NULL object");
		}
		return writeignitiongrid(farsiteObj, name);
	}

	public int writePerimetersShapeFile(String name)
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("writePerimetersShapeFile called with NULL object");
		}
		return writeperimetersshapefile(farsiteObj, name);
	}

	public int writeTimingsFile(String name)
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("writeTimingsFile called with NULL object");
		}
		return writetimingsfile(farsiteObj, name);
	}
	
	public int getNumIgnitionCells()
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("getNumIgnitionCells called with NULL object");
		}
		return getnumignitioncells(farsiteObj);
	}

	public int getEdgeHits()
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("getEdgeHits called with NULL object");
		}
		return getnumedgehits(farsiteObj);
	}

	public int writeOutputLayersGeotiff(int[] layerIDs, String name)
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("writeOutputLayersGeotiff called with NULL object");
		}
		return writeoutputlayersgeotiff(farsiteObj, layerIDs, name);
	}
	
	public int writeSpotFireCSV(String name)
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("writeSpotFireCSV called with NULL object");
		}
		return writespotfirecsv(farsiteObj, name);
	}
	
	public int writeSpotFireShapefile(String name)
	{
		if (farsiteObj == 0)
		{
			throw new IllegalStateException("writeSpotFireShapefile called with NULL object");
		}
		return writespotfireshapefile(farsiteObj, name);
	}
	
	// destroy native object if it's still around
	// when finalize called from garbage collection
	public void finalize()
	{
		destroy();
	}

}
