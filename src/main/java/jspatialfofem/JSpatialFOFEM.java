package jspatialfofem;

public class JSpatialFOFEM {
//outputs identifiers for GeoTIFF results
	//	ID's must match those used by C++ SpatialFOFEM class, input file switch to request the output follows ID in the comment
	//EMISSIONS
	public static final int JSF_FLAMING_CO2 = 0;			//"FOFEM_FLAMING_CO2"
	public static final int JSF_SMOLDERING_CO2 = 1;			//"FOFEM_SMOLDERING_CO2"
	public static final int JSF_TOTAL_CO2 = 2;				//"FOFEM_TOTAL_CO2"
	public static final int JSF_FLAMING_CO = 3;				//"FOFEM_FLAMING_CO"
	public static final int JSF_SMOLDERING_CO = 4;			//"FOFEM_SMOLDERING_CO"
	public static final int JSF_TOTAL_CO = 5;				//"FOFEM_TOTAL_CO"
	public static final int JSF_FLAMING_CH4 = 6;			//"FOFEM_FLAMING_CH4"
	public static final int JSF_SMOLDERING_CH4 = 7;			//"FOFEM_SMOLDERING_CH4"
	public static final int JSF_TOTAL_CH4 = 8;				//"FOFEM_TOTAL_CH4"
	public static final int JSF_FLAMING_NOX = 9;			//"FOFEM_FLAMING_NOX"
	public static final int JSF_SMOLDERING_NOX = 10;		//"FOFEM_SMOLDERING_NOX"
	public static final int JSF_TOTAL_NOX = 11;				//"FOFEM_TOTAL_NOX"
	public static final int JSF_FLAMING_SO2 = 12;			//"FOFEM_FLAMING_SO2"
	public static final int JSF_SMOLDERING_SO2 = 13;		//"FOFEM_SMOLDERING_SO2"
	public static final int JSF_TOTAL_SO2 = 14;				//"FOFEM_TOTAL_SO2"
	public static final int JSF_FLAMING_PM25 = 15;			//"FOFEM_FLAMING_PM25"
	public static final int JSF_SMOLDERING_PM25 = 16;		//"FOFEM_SMOLDERING_PM25"
	public static final int JSF_TOTAL_PM25 = 17;			//"FOFEM_TOTAL_PM25"
	public static final int JSF_FLAMING_PM10 = 18;			//"FOFEM_FLAMING_PM10"
	public static final int JSF_SMOLDERING_PM10 = 19;		//"FOFEM_SMOLDERING_PM10"
	public static final int JSF_TOTAL_PM10 = 20;			//"FOFEM_TOTAL_PM10"
	//FUELS
	public static final int JSF_PRE_TOTAL = 21;				//"FOFEM_TOTAL_FUEL_PREBURN"
	public static final int JSF_POST_TOTAL = 22;			//"FOFEM_TOTAL_FUEL_POSTBURN"
	public static final int JSF_CONSUMED_TOTAL = 23;		//"FOFEM_TOTAL_FUEL_CONSUMED"
	public static final int JSF_PR_TOTAL = 24;				//"FOFEM_TOTAL_FUEL_PERCENT_REDUCED"
	public static final int JSF_PRE_1HOUR = 25;				//"FOFEM_1_HOUR_PREBURN"
	public static final int JSF_POST_1HOUR = 26;			//"FOFEM_1_HOUR_POSTBURN"
	public static final int JSF_CONSUMED_1HOUR = 27;		//"FOFEM_1_HOUR_CONSUMED"
	public static final int JSF_PR_1HOUR = 28;				//"FOFEM_1_HOUR_PERCENT_REDUCED"
	public static final int JSF_PRE_10HOUR = 29;			//"FOFEM_10_HOUR_PREBURN"
	public static final int JSF_POST_10HOUR = 30;			//"FOFEM_10_HOUR_POSTBURN"
	public static final int JSF_CONSUMED_10HOUR = 31;		//"FOFEM_10_HOUR_CONSUMED"
	public static final int JSF_PR_10HOUR = 32;				//"FOFEM_10_HOUR_PERCENT_REDUCED"
	public static final int JSF_PRE_100HOUR = 33;			//"FOFEM_100_HOUR_PREBURN"
	public static final int JSF_POST_100HOUR = 34;			//"FOFEM_100_HOUR_POSTBURN"
	public static final int JSF_CONSUMED_100HOUR = 35;		//"FOFEM_100_HOUR_CONSUMED"
	public static final int JSF_PR_100HOUR = 36;			//"FOFEM_10_HOUR_PERCENT_REDUCED"
	public static final int JSF_PRE_S3 = 37;				//"FOFEM_SOUND_3_6_PREBURN"
	public static final int JSF_POST_S3 = 38;				//"FOFEM_SOUND_3_6_POSTBURN"
	public static final int JSF_CONSUMED_S3 = 39;			//"FOFEM_SOUND_3_6_CONSUMED"
	public static final int JSF_PR_S3 = 40;					//"FOFEM_SOUND_3_6_PERCENT_REDUCED"
	public static final int JSF_PRE_S6 = 41;				//"FOFEM_SOUND_6_9_PREBURN"
	public static final int JSF_POST_S6 = 42;				//"FOFEM_SOUND_6_9_POSTBURN"
	public static final int JSF_CONSUMED_S6 = 43;			//"FOFEM_SOUND_6_9_CONSUMED"
	public static final int JSF_PR_S6 = 44;					//"FOFEM_SOUND_6_9_PERCENT_REDUCED"
	public static final int JSF_PRE_S9 = 45;				//"FOFEM_SOUND_9_20_PREBURN"
	public static final int JSF_POST_S9 = 46;				//"FOFEM_SOUND_9_20_POSTBURN"
	public static final int JSF_CONSUMED_S9 = 47;			//"FOFEM_SOUND_9_20_CONSUMED"
	public static final int JSF_PR_S9 = 48;					//"FOFEM_SOUND_9_20_PERCENT_REDUCED"
	public static final int JSF_PRE_S20 = 49;				//"FOFEM_SOUND_20_PLUS_PREBURN"
	public static final int JSF_POST_S20 = 50;				//"FOFEM_SOUND_20_PLUS_POSTBURN"
	public static final int JSF_CONSUMED_S20 = 51;			//"FOFEM_SOUND_20_PLUS_CONSUMED"
	public static final int JSF_PR_S20 = 52;				//"FOFEM_SOUND_20_PLUS_PERCENT_REDUCED"
	public static final int JSF_PRE_R3 = 53;				//"FOFEM_ROTTEN_3_6_PREBURN"
	public static final int JSF_POST_R3 = 54;				//"FOFEM_ROTTEN_3_6_POSTBURN"
	public static final int JSF_CONSUMED_R3 = 55;			//"FOFEM_ROTTEN_3_6_CONSUMED"
	public static final int JSF_PR_R3 = 56;					//"FOFEM_ROTTEN_3_6_PERCENT_REDUCED"
	public static final int JSF_PRE_R6 = 57;				//"FOFEM_ROTTEN_6_9_PREBURN"
	public static final int JSF_POST_R6 = 58;				//"FOFEM_ROTTEN_6_9_POSTBURN"
	public static final int JSF_CONSUMED_R6 = 59;			//"FOFEM_ROTTEN_6_9_CONSUMED"
	public static final int JSF_PR_R6 = 60;					//"FOFEM_ROTTEN_6_9_PERCENT_REDUCED"
	public static final int JSF_PRE_R9 = 61;				//"FOFEM_ROTTEN_9_20_PREBURN"
	public static final int JSF_POST_R9 = 62;				//"FOFEM_ROTTEN_9_20_POSTBURN"
	public static final int JSF_CONSUMED_R9 = 63;			//"FOFEM_ROTTEN_9_20_CONSUMED"
	public static final int JSF_PR_R9 = 64;					//"FOFEM_ROTTEN_9_20_PERCENT_REDUCED"
	public static final int JSF_PRE_R20 = 65;				//"FOFEM_ROTTEN_20_PLUS_PREBURN"
	public static final int JSF_POST_R20 = 66;				//"FOFEM_ROTTEN_20_PLUS_POSTBURN"
	public static final int JSF_CONSUMED_R20 = 67;			//"FOFEM_ROTTEN_20_PLUS_CONSUMED"
	public static final int JSF_PR_R20 = 68;				//"FOFEM_ROTTEN_20_PLUS_PERCENT_REDUCED"
	public static final int JSF_PRE_DUFF = 69;				//"FOFEM_DUFF_PREBURN"
	public static final int JSF_POST_DUFF = 70;				//"FOFEM_DUFF_POSTBURN"
	public static final int JSF_CONSUMED_DUFF = 71;			//"FOFEM_DUFF_CONSUMED"
	public static final int JSF_PR_DUFF = 72;				//"FOFEM_DUFF_PERCENT_REDUCED"
	public static final int JSF_PRE_LITTER = 73;			//"FOFEM_LITTER_PREBURN"
	public static final int JSF_POST_LITTER = 74;			//"FOFEM_LITTER_POSTBURN"
	public static final int JSF_CONSUMED_LITTER = 75;		//"FOFEM_LITTER_CONSUMED"
	public static final int JSF_PR_LITTER = 76;				//"FOFEM_LITTER_PERCENT_REDUCED"
	public static final int JSF_PRE_HERB = 77;				//"FOFEM_HERB_PREBURN"
	public static final int JSF_POST_HERB = 78;				//"FOFEM_HERB_POSTBURN"
	public static final int JSF_CONSUMED_HERB = 79;			//"FOFEM_HERB_CONSUMED"
	public static final int JSF_PR_HERB = 80;				//"FOFEM_HERB_PERCENT_REDUCED"
	public static final int JSF_PRE_SHRUB = 81;				//"FOFEM_SHRUB_PREBURN"
	public static final int JSF_POST_SHRUB = 82;			//"FOFEM_SHRUB_POSTBURN"
	public static final int JSF_CONSUMED_SHRUB = 83;		//"FOFEM_SHRUB_CONSUMED"
	public static final int JSF_PR_SHRUB = 84;				//"FOFEM_SHRUB_PERCENT_REDUCED"
	public static final int JSF_PRE_FOL = 85;				//"FOFEM_FOLIAGE_PREBURN"
	public static final int JSF_POST_FOL = 86;				//"FOFEM_FOLIAGE_POSTBURN"
	public static final int JSF_CONSUMED_FOL = 87;			//"FOFEM_FOLIAGE_CONSUMED"
	public static final int JSF_PR_FOL = 88;				//"FOFEM_FOLIAGE_PERCENT_REDUCED"
	public static final int JSF_PRE_BRA = 89;				//"FOFEM_BRANCH_PREBURN"
	public static final int JSF_POST_BRA = 90;				//"FOFEM_BRANCH_POSTBURN"
	public static final int JSF_CONSUMED_BRA = 91;			//"FOFEM_BRANCH_CONSUMED"
	public static final int JSF_PR_BRA = 92;				//"FOFEM_BRANCH_PERCENT_REDUCED"
	//CARBON		
	public static final int JSF_PRE_C_LITTER = 93;			//"FOFEM_LITTER_CARBON_PREBURN"
	public static final int JSF_POST_C_LITTER = 94;			//"FOFEM_LITTER_CARBON_POSTBURN"
	public static final int JSF_PRE_C_WOOD = 95;			//"FOFEM_WOOD_CARBON_PREBURN"
	public static final int JSF_POST_C_WOOD = 96;			//"FOFEM_WOOD_CARBON_POSTBURN"
	public static final int JSF_PRE_C_DUFF = 97;			//"FOFEM_DUFF_CARBON_PREBURN"
	public static final int JSF_POST_C_DUFF = 98;			//"FOFEM_DUFF_CARBON_POSTBURN"
	public static final int JSF_PRE_C_HERB = 99;			//"FOFEM_HERB_CARBON_PREBURN"
	public static final int JSF_POST_C_HERB = 100;			//"FOFEM_HERB_CARBON_POSTBURN"
	public static final int JSF_PRE_C_SHRUB = 101;			//"FOFEM_SHRUB_CARBON_PREBURN"
	public static final int JSF_POST_C_SHRUB = 102;			//"FOFEM_SHRUB_CARBON_POSTBURN"
	public static final int JSF_PRE_C_FOL = 103;			//"FOFEM_FOLIAGE_BRANCH_CARBON_PREBURN"
	public static final int JSF_POST_C_FOL = 104;			//"FOFEM_FOLIAGE_BRANCH_CARBON_POSTBURN"
	public static final int JSF_PRE_C_TOTAL = 105;			//"FOFEM_TOTAL_CARBON_PREBURN"
	public static final int JSF_POST_C_TOTAL = 106;			//"FOFEM_TOTAL_CARBON_POSTBURN"

		//duff depth added 2020/06/04
	public static final int JSF_PRE_DUFF_DEPTH = 107;				//"FOFEM_DUFF_DEPTH_PREBURN"
	public static final int JSF_POST_DUFFF_DEPTH = 108;				//"FOFEM_DUFF_DEPTH_POSTBURN"
	public static final int JSF_CONSUMED_DUFFF_DEPTH = 109;			//"FOFEM_DUFF_DEPTH_CONSUMED"
	public static final int JSF_PR_DUFFF_DEPTH = 110;				//"FOFEM_DUFF_DEPTH_PERCENT_REDUCED"
	//MSE added 2020/06/18
	public static final int JSF_MINERAL_SOIL_EXPOSED = 111;

	public static final int JSF_OUTPUTS_END = 112;			//INDICATOR OF EXCEEDED OUTPUT IDS, this may change if expanded emission outputs are added
	
	
	//implementation
	private long spatialFofemObj;
	
	// create native object
	private native long create();

	// destroy native object
	private native void destroy(long p);
	
	//native CSpatialFOFEM routines
	private native int loadinputsfile(long p, String inputsfilename);
	
	private native int runspatialfofem(long p);
	
	private native int writeoutputlayersgeotiff(long p, int[] layerIDs,  String filename);
	
	private native int writealloutputlayersgeotiff(long p, String filename);

	private native int writestatisticscsv(long p, String filename);

	private native int writewarningcsv(long p, String filename);
	
	private native double getprogress(long p);
	
	private native int cancelspatialfofem(long p);
	
	private native String geterrormessage(long p, int errornumber);
	
	private native String getoutputlayername(long p, int outputlayernumber);

	private native int getmaxoutputid(long p);
	
	private native int writemortalitysummarycsv(long p, String filename);

	private native int writeallmortalitygeotiffs(long p, String basefilename);

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
			System.loadLibrary("fof_dll");
			System.loadLibrary("SpatialFOFEM");
			System.loadLibrary("JSpatialFOFEMLib");
		}
		catch (UnsatisfiedLinkError e)
		{
			System.err.println(e);
		}
	}
	
	//exposed Java functions
	public JSpatialFOFEM()
	{
		spatialFofemObj = create();
	}
	
	public void destroy()
	{
		if(spatialFofemObj != 0)
		{
			destroy(spatialFofemObj);
			spatialFofemObj = 0;
		}
	}
	
	//wrappers for the native SpatialFOFEM routines
	public int loadInputsFile(String filename)
	{
		if(spatialFofemObj == 0)
		{
			throw new IllegalStateException("loadInputsFile called with NULL object");
		}
		return loadinputsfile(spatialFofemObj, filename);
	}
	
	public int runSpatialFofem()
	{
		if(spatialFofemObj == 0)
		{
			throw new IllegalStateException("runSpatialFofem called with NULL object");
		}
		return runspatialfofem(spatialFofemObj);
	}
	
	public int writeOutputLayersGeoTIFF(int[] layerIDs, String filename)
	{
		if(spatialFofemObj == 0)
		{
			throw new IllegalStateException("writeOutputLayersGeoTIFF called with NULL object");
		}
		return writeoutputlayersgeotiff(spatialFofemObj, layerIDs, filename);
	}
	
	public int writeAllOutputLayersGeoTIFF(String filename)
	{
		if(spatialFofemObj == 0)
		{
			throw new IllegalStateException("writeAllOutputLayersGeoTIFF called with NULL object");
		}
		return writealloutputlayersgeotiff(spatialFofemObj, filename);
	}
	
	public int writeStatisticsCSV(String filename)
	{
		if(spatialFofemObj == 0)
		{
			throw new IllegalStateException("writeStatisticsCSV called with NULL object");
		}
		return writestatisticscsv(spatialFofemObj, filename);
	}
	
	public int writeWarningsCSV(String filename)
	{
		if(spatialFofemObj == 0)
		{
			throw new IllegalStateException("writeWarningsCSV called with NULL object");
		}
		return writewarningcsv(spatialFofemObj, filename);
	}
	
	public double getProgress()
	{
		if(spatialFofemObj == 0)
		{
			throw new IllegalStateException("getProgress called with NULL object");
		}
		return getprogress(spatialFofemObj);
	}
	
	public int cancelSpatialFOFEM()
	{
		if(spatialFofemObj == 0)
		{
			throw new IllegalStateException("cancelSpatialFOFEM called with NULL object");
		}
		return cancelspatialfofem(spatialFofemObj);
	}
	
	public String getErrorMessage(int errornumber)
	{
		if(spatialFofemObj == 0)
		{
			throw new IllegalStateException("getErrorMessage called with NULL object");
		}
		return geterrormessage(spatialFofemObj, errornumber);
	}
	
	public String getOutputLayerName(int outputLayerNumber)
	{
		if(spatialFofemObj == 0)
		{
			throw new IllegalStateException("getOutputLayerName called with NULL object");
		}
		return getoutputlayername(spatialFofemObj, outputLayerNumber);
	}
	
	public int getMaxOutputID()
	{
		return getmaxoutputid(spatialFofemObj);
	}

	public int writeMortalitySummaryCSV(String filename)
	{
		if(spatialFofemObj == 0)
		{
			throw new IllegalStateException("writeMortalitySummaryCSV called with NULL object");
		}
		return writemortalitysummarycsv(spatialFofemObj, filename);
	}

	public int writeAllMortalityGeoTIFFs(String baseFilename)
	{
		if(spatialFofemObj == 0)
		{
			throw new IllegalStateException("writeAllMortalityGeoTIFFs called with NULL object");
		}
		return writeallmortalitygeotiffs(spatialFofemObj, baseFilename);
	}


	// destroy native object if it's still around
	// when finalize called from garbage collection
	public void finalize()
	{
		destroy();
	}

}
