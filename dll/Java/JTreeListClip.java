package jtreelistclip;

public class JTreeListClip {
//defined return codes
	public final int TL_ERROR_NONE = 0;
	public final int TL_ERROR_NATIONAL_FILE_OPEN_ERROR = 1;
	public final int TL_ERROR_PROJECTION_INVALID = 2;
	public final int TL_ERROR_BAD_EXTENT = 3;
	public final int TL_ERROR_COORDINATE_TRANSFORMATION = 4;
	public final int TL_ERROR_CREATE_OUTPUT_FILE = 5;
	public final int TL_ERROR_GEOTRANSFORM = 6;
	
	//implementation
	private long treeListClipObj;
	
	// create native object
	private native long create();

	// destroy native object
	private native void destroy(long p);
	
	//native CTreeListClip routines
	private native int setnationallayerpath(long p, String filename);
	
	private native int setlatlonextent(long p, double minLat, double minLon, double maxLat, double maxLon);
	
	private native int createoutputfile(long p, String filename);

	private native String geterrormessage(long p, int errornumber);
	
	private native double getoutputresolution(long p);
	
	private native int getoutputnumrows(long p);
	
	private native int getoutputnumcols(long p);
	
	private native double getoutputlowerleftx(long p);
	
	private native double getoutputlowerlefty(long p);
	
	private native double getoutputlowerrightx(long p);
	
	private native double getoutputlowerrighty(long p);
	
	private native double getoutputupperleftx(long p);
	
	private native double getoutputupperlefty(long p);
	
	private native double getoutputupperrightx(long p);
	
	private native double getoutputupperrighty(long p);
	
	private native String getoutputprojection(long p);

	static
	{
		try
		{
			System.loadLibrary("concrt140");
			System.loadLibrary("msvcp140");
			System.loadLibrary("vcruntime140");
			System.loadLibrary("vcruntime140_1");
			System.loadLibrary("gdal304");
			System.loadLibrary("TREELISTCLIP");
			System.loadLibrary("JTreeListClipLib");
		}
		catch (UnsatisfiedLinkError e)
		{
			System.err.println(e);
		}
	}

	//exposed Java functions
	public JTreeListClip()
	{
		treeListClipObj = create();
	}
	
	public void destroy()
	{
		if(treeListClipObj != 0)
		{
			destroy(treeListClipObj);
			treeListClipObj = 0;
		}
	}
	
	public int setNationalLayerPath(String filename)
	{
		if(treeListClipObj == 0)
		{
			throw new IllegalStateException("setNationalLayerPath called with NULL object");
		}
		return setnationallayerpath(treeListClipObj, filename);
	}
	
	public int setLatLonExtent(double minLat, double minLon, double maxLat, double maxLon)
	{
		if(treeListClipObj == 0)
		{
			throw new IllegalStateException("setExtent called with NULL object");
		}
		return setlatlonextent(treeListClipObj, minLat, minLon, maxLat, maxLon);
	}
	
	public int createOutputFile(String filename)
	{
		if(treeListClipObj == 0)
		{
			throw new IllegalStateException("createOutputFile called with NULL object");
		}
		return createoutputfile(treeListClipObj, filename);
	}
	
	public String getErrorMessage(int errornumber)
	{
		if(treeListClipObj == 0)
		{
			throw new IllegalStateException("getErrorMessage called with NULL object");
		}
		return geterrormessage(treeListClipObj, errornumber);
	}

	public double getOutputResolution()
	{
		if(treeListClipObj == 0)
		{
			throw new IllegalStateException("getOutputResolution called with NULL object");
		}
		return getoutputresolution(treeListClipObj);
	}
	
	public double getOutputNumRows()
	{
		if(treeListClipObj == 0)
		{
			throw new IllegalStateException("getOutputNumRows called with NULL object");
		}
		return getoutputnumrows(treeListClipObj);
	}
	
	public double getOutputNumCols()
	{
		if(treeListClipObj == 0)
		{
			throw new IllegalStateException("getOutputNumCols called with NULL object");
		}
		return getoutputnumcols(treeListClipObj);
	}
	
	public double getOutputLowerLeftX()
	{
		if(treeListClipObj == 0)
		{
			throw new IllegalStateException("getOutputLowerLeftX called with NULL object");
		}
		return getoutputlowerleftx(treeListClipObj);
	}
	
	public double getOutputLowerLeftY()
	{
		if(treeListClipObj == 0)
		{
			throw new IllegalStateException("getOutputLowerLeftY called with NULL object");
		}
		return getoutputlowerlefty(treeListClipObj);
	}
	
	public double getOutputLowerRightX()
	{
		if(treeListClipObj == 0)
		{
			throw new IllegalStateException("getOutputLowerRightX called with NULL object");
		}
		return getoutputlowerrightx(treeListClipObj);
	}
	
	public double getOutputLowerRightY()
	{
		if(treeListClipObj == 0)
		{
			throw new IllegalStateException("getOutputLowerRightY called with NULL object");
		}
		return getoutputlowerrighty(treeListClipObj);
	}
	
	public double getOutputUpperLeftX()
	{
		if(treeListClipObj == 0)
		{
			throw new IllegalStateException("getOutputUpperLeftX called with NULL object");
		}
		return getoutputupperleftx(treeListClipObj);
	}
	
	public double getOutputUpperLeftY()
	{
		if(treeListClipObj == 0)
		{
			throw new IllegalStateException("getOutputUpperLeftY called with NULL object");
		}
		return getoutputupperlefty(treeListClipObj);
	}
	
	public double getOutputUpperRightX()
	{
		if(treeListClipObj == 0)
		{
			throw new IllegalStateException("getOutputUpperRightX called with NULL object");
		}
		return getoutputupperrightx(treeListClipObj);
	}
	
	public double getOutputUpperRightY()
	{
		if(treeListClipObj == 0)
		{
			throw new IllegalStateException("getOutputUpperRightY called with NULL object");
		}
		return getoutputupperrighty(treeListClipObj);
	}
	
	public String getOutputProjection()
	{
		if(treeListClipObj == 0)
		{
			throw new IllegalStateException("getoutputprojection called with NULL object");
		}
		return getoutputprojection(treeListClipObj);
	}
	// destroy native object if it's still around
	// when finalize called from garbage collection
	public void finalize()
	{
		destroy();
	}

}
