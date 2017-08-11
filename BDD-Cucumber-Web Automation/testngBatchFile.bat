set projectLocation=C:\Users\harpreet2.singh\workspace\qa.automation
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause