export USERNAME="AUTUser@flightmgmt.com"
export PASSWORD="Ziofa2023!"
export TARGET_URL=" http://192.168.1.203:8443/prweb/PRServlet/app/FlightManagementSolTest/"
export SELENIUM_GRID_URL="http://192.168.1.203:5555/wd/hub"

mvn test -q -Dbrowser="chrome" -DTargetURL=$TARGET_URL -DSeleniumGridURL=$SELENIUM_GRID_URL  -Dusername=%USERNAME% -Dpassword=%PASSWORD%
