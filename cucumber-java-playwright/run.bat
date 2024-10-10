set USERNAME="AUTUser@flightmgmt.com"
set PASSWORD="Merda2024!"
set TARGET_URL="https://lab-03254-bos.lab-internal.pega.com/prweb/app/FlightManagementSolTest/"
set SELENIUM_GRID_URL="http://localhost:5555/wd/hub"

mvn test -q -Dbrowser="chrome" -DTargetURL=%TARGET_URL% -DSeleniumGridURL=%SELENIUM_GRID_URL% -Dusername=%USERNAME% -Dpassword=%PASSWORD%