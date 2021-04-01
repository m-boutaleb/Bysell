#!/bin/bash/

# --------------------------------------------------------------------------
# Define paths to deploy the .bat start and stop files and start and stop functions
# --------------------------------------------------------------------------
export CATALINA_HOME="C:\Program Files\Apache Software Foundation\Tomcat 9.0" # To start the web server is necessary
APACHE_BIN_PATH="C:\Program Files\Apache Software Foundation\Tomcat 9.0\bin"
START="startup.bat"
STOP="shutdown.bat"

# Start procedure to initialize the server
start(){
	"$APACHE_BIN_PATH"/"${START}" 
}

# Stop procecedure to shutdown the listening port (8080)
stop(){
	"${APACHE_BIN_PATH}"/"${STOP}"
}

# --------------------------------------------------------------------------
# Define menu for the user choice
# --------------------------------------------------------------------------
print_menu(){
echo ""
cat <<MENU
MENU:
0: STARTUP SERVER
1: SHUTDOWN SERVER
MENU
}

# --------------------------------------------------------------------------
# Logic implementation of the user input
# --------------------------------------------------------------------------
while true; do
	print_menu
	read user_input
	if [[ user_input -eq 0 ]]; then
		start
		echo -e "\e[32mWEB SERVER STARTED SUCCESSFULLY\e[0m"
		break
	elif [[ user_input -eq 1 ]]; then
		stop
		echo -e "\e[32mWEB SERVER SHUTDOWN SUCCESSFULLY\e[0m"
		break
	else
		echo -e "\e[31mError: you have not specified the right code\e[0m"
	fi
done
