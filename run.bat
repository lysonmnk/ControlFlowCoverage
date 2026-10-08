@echo off
REM Compile dan jalankan semua test (butuh JDK 11+ dengan javac di PATH)
cd /d "%~dp0"
set OUT=%TEMP%\ppmpl_w5s3
if exist "%OUT%" rmdir /s /q "%OUT%"
mkdir "%OUT%\k1" "%OUT%\k2"

echo ################ KODE 1 - HitungKomisi ################
javac -d "%OUT%\k1" kode1\*.java || goto :err
java -cp "%OUT%\k1" HitungKomisiTest || goto :err

echo.
echo ################ KODE 2 - ProsesAngkaJava ################
javac -d "%OUT%\k2" kode2\*.java || goto :err
java -cp "%OUT%\k2" ProsesAngkaJavaTest || goto :err
echo.
echo --- main() ProsesAngkaJava ---
java -cp "%OUT%\k2" ProsesAngkaJava
goto :eof

:err
echo Terjadi kesalahan. Pastikan JDK terpasang (perintah javac tersedia).
exit /b 1
