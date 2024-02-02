set USERNAME="AUTUser@flightmgmt.com"
set PASSWORD="Ziofa2023!"
set TARGET_URL="https://10.60.213.235:8443/prweb/PRServlet/app/FlightManagementSolTest/"
set SELENIUM_GRID_URL="http://192.168.1.203:5555/wd/hub"

mvn test -q -Dbrowser="chrome" -DTargetURL=%TARGET_URL% -DSeleniumGridURL=%SELENIUM_GRID_URL% -Dusername=%USERNAME% -Dpassword=%PASSWORD%