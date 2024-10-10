export USERNAME="AUTUser@flightmgmt.com"
export PASSWORD="Merda2024!"
export TARGET_URL="https://lab-03254-bos.lab-internal.pega.com/prweb/app/FlightManagementSolTest/"

mvn test -q -Dbrowser="chrome" -DTargetURL=$TARGET_URL -Dusername=%USERNAME% -Dpassword=%PASSWORD%
