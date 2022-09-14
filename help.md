```
https://github.com/StefanScherer/dockerfiles-windows
https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17.0.4.1+1/OpenJDK17U-jdk_x64_windows_hotspot_17.0.4.1_1.msi
```

https://stackoverflow.com/a/44785784

docker build -f Dockerfile.flammap -t flammap:v2 .

docker run --rm -v C:\Users\Administrator\Documents\fmsf-models\landscape\j222b1afde57c42ccb3c71cfdb5d330f6:C:\Users\Administrator\Documents\landscape -v C:\Users\Administrator\Documents\fmsf-models\input:C:\Users\Administrator\Documents\input -v C:\Users\Administrator\Documents\fmsf-models\output:C:\Users\Administrator\Documents\output flammap:v2
