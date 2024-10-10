export USERNAME="AUTUser@flightmgmt.com"
export PASSWORD="Merda2024!"
export TARGET_URL="https://lab-03254-bos.lab-internal.pega.com/prweb/app/FlightManagementSolTest/"
export SELENIUM_GRID_URL="http://localhost:4444/wd/hub"

mvn test -q -Dbrowser="chrome" -DTargetURL=$TARGET_URL -DSeleniumGridURL=$SELENIUM_GRID_URL  -Dusername=%USERNAME% -Dpassword=%PASSWORD%
