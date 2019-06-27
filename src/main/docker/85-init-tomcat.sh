#!/bin/bash

echo "Tomcat init start"

# the key is ignored, the value should contain the "-D" flag if it's a property
function setJavaOption {
    JAVA_OPTS="$JAVA_OPTS $2"
}

function setJavaOptions {
    IFS=$'\n'
    for i in `env`
    do
	if [[ $i == JAVA_OPTS_* ]]
	    then
	    key=`echo $i | cut -d '=' -f 1 | cut -d '_' -f 3-`
	    value=`echo $i | cut -d '=' -f 2-`
	    setJavaOption $key $value
	fi
    done
}

TOMCAT_CONTEXT_FILE=${CATALINA_HOME}'/conf/context.xml'
TOMCAT_CONFIG_FILE=${CATALINA_HOME}'/bin/setenv.sh'

# Tomcat-related properties
# for backwards compatibility, we keep the old options as well
setJavaOption 'TOMCAT_PORT' '-DTOMCAT_PORT='${TOMCAT_PORT:-8080}
setJavaOption 'TOMCAT_PORT_SSL' '-DTOMCAT_PORT_SSL='${TOMCAT_PORT_SSL:-8443}
setJavaOption 'TOMCAT_AJP_PORT' '-DTOMCAT_AJP_PORT='${TOMCAT_AJP_PORT:-8009}
setJavaOption 'TOMCAT_SERVER_PORT' '-DTOMCAT_SERVER_PORT='${TOMCAT_SERVER_PORT:-8005}
BC_TOMCAT_MAX_HTTP_HEADER_SIZE=${TOMCAT_MAX_HTTP_HEADER_SIZE:-$MAX_HTTP_HEADER_SIZE}
setJavaOption 'TOMCAT_MAX_HTTP_HEADER_SIZE' '-DTOMCAT_MAX_HTTP_HEADER_SIZE='${BC_TOMCAT_MAX_HTTP_HEADER_SIZE:-32768}
BC_TOMCAT_MAX_THREADS=${TOMCAT_MAX_THREADS:-$MAX_THREADS}
setJavaOption 'TOMCAT_MAX_THREADS' '-DTOMCAT_MAX_THREADS='${BC_TOMCAT_MAX_THREADS:-200}


sed -i "s|\(<Context>\)|\1\n<Manager pathname=\"\" />|" ${TOMCAT_CONTEXT_FILE} || exit 1 # No persistent sessions after restart

echo "JAVA_OPTS=\"$JAVA_OPTS\"" >$TOMCAT_CONFIG_FILE
echo "export JAVA_OPTS" >> $TOMCAT_CONFIG_FILE

echo "Tomcat init done"