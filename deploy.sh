#!/bin/bash/

# ---------------------------------------
# Define paths to deploy the .war archive
# ---------------------------------------
DEPLOY_PATH="C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps"
WAR_PATH="./target"
WAR_EXTENSION=".war"
CLEAN_INSTALL="mvn clean && mvn install"

# ---------------------------------------
# Check if file does exists
# ---------------------------------------
check_file() {
	if [[ -e ${WAR_PATH}/"$1"${WAR_EXTENSION} ]]; then
		return 0
	else
		return 1
	fi
}

# ---------------------------------------
# Logic implementation
# ---------------------------------------
if [[ $# -eq 0 ]]; then
	echo -e "\e[31mError: you have not specified the name of the .war file\e[0m"
	exit 1
elif !( check_file $1 ); then
	echo -e "\e[33mWarning: the file specified has not been found\e[0m"
	echo -e "Trying to generate it..."
	eval "${CLEAN_INSTALL}"
	if !( check_file $1 ); then
		echo -e "\e[31mError: the file specified has not been found\e[0m"
		exit -1
	fi
else
	eval "${CLEAN_INSTALL}"
fi

# ---------------------------------------
# All Ok
# ---------------------------------------
cp ${WAR_PATH}/$1${WAR_EXTENSION} "${DEPLOY_PATH}"

echo -e "\e[32m\nDEPLOYED SUCCESSFULLY"
