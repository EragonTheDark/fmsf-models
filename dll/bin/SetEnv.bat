@echo off

set FMSF_BIN=%~dp0
set FMSF_BIN=%FMSF_BIN:\\=\%

@echo FMSF_BIN set to %FMSF_BIN%

SET "PATH=%FMSF_BIN%;%PATH%"
@echo Path set to %PATH%
SET "GDAL_DATA=%FMSF_BIN%gdal-data"
@echo GDAL_DATA set to %GDAL_DATA%
SET "PROJ_LIB=%FMSF_BIN%proj7\SHARE"
@echo PROJ_LIB set to %PROJ_LIB%
