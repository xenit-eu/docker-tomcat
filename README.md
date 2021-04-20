# Apache Tomcat Docker Images

Docker Image of Apache Tomcat maintained by XeniT.

Apache Tomcat is an open source web server and servlet container, by the Apache Software Foundation.

## Supported tags

* `alfresco-7.0-ubuntu`, `alfresco-6.2-ubuntu`, `alfresco-6.1-ubuntu`, `alfresco-6.0-ubuntu`, `8.5.59-jdk-11u9-bionic`, `8.5-jdk-11u9-bionic`, `8-jdk-11u9-bionic`, `8.5.59-bionic`, `8.5-bionic`, `8-bionic`
* `alfresco-5.2-ubuntu`, `alfresco-5.1-ubuntu`, `alfresco-5.0-ubuntu`, `7.0.106-jdk-8u272-bionic`, `7.0-jdk-8u272-bionic`, `7-jdk-8u272-bionic`, `7.0.106-bionic`, `7.0-bionic`, `7-bionic`
* `alfresco-4.2-ubuntu`, `7.0.106-jdk-7u211-trusty`, `7.0-jdk-7u211-trusty`, `7-jdk-7u211-trusty`
* `alfresco-4.2-centos`, `7.0.106-jdk-7u261-centos-7`, `7.0-jdk-7u261-centos-7`, `7-jdk-7u261-centos-7`

Additional tags are provided:
* tags containing a `-SNAPSHOT` postfix are development artifacts (from the master branch). Do not use them in a production environment.
* tags without any postfix are release artifacts

## Environment variables

There are several environment variables available to tweak the behaviour. While none of the variables are required, 
they may significantly aid you in using these images. The variables are read by an init script which further sets 
JAVA_OPTS variables to be used in tomcat's templated configuration file server.xml.

Environment variables:

| Variable                    |  Default                        | Java variable |
| --------------------------- | ------------------------------- | ---------------------------- |
| TOMCAT_PORT                 |  8080                           | -DTOMCAT_PORT                |
| TOMCAT_PORT_SSL             |  8443                           | -DTOMCAT_PORT_SSL            |
| TOMCAT_AJP_PORT             |  8009                           | -DTOMCAT_AJP_PORT            |
| TOMCAT_SERVER_PORT          |  8005                           | -DTOMCAT_SERVER_PORT         |
| TOMCAT_MAX_HTTP_HEADER_SIZE |  32768                          | -DTOMCAT_MAX_HTTP_HEADER_SIZE  or -DMAX_HTTP_HEADER_SIZE |
| TOMCAT_MAX_THREADS          |  200                            | -DTOMCAT_MAX_THREADS or -DMAX_THREADS |
| TOMCAT_ACCESSLOG_ROTATE     |  true                           | -DTOMCAT_ACCESSLOG_ROTATE    |
| TOMCAT_ACCESSLOG_MAXDAYS    |  -1                             | -DTOMCAT_ACCESSLOG_MAXDAYS   |
| TOMCAT_LOGGING_MAXDAYS      |  5                              | -DTOMCAT_LOGGING_MAXDAYS   |
| TOMCAT_RELAXED_QUERY_CHARS  |  ""                             | -DTOMCAT_RELAXED_QUERY_CHARS |
| TOMCAT_RELAXED_PATH_CHARS   |  ""                             | -DTOMCAT_RELAXED_PATH_CHARS  |


## Quick reference

**Where to get help:**

Channel [#docker](https://xenitengineering.slack.com/app_redirect?channel=docker) on Slack

**Maintained by:**

Toon Geens <toon.geens@xenit.eu>

**Supported Architectures:**

* linux-x64

**Supported Docker versions:**

* down to 1.10 (on a best-effort basis)

## Image variants

The `tomcat` image comes in a few flavors, where the variants use the following tag-structure:

```
tomcat:<version>[-<java>[-<os>]]
```

* **version**: the Tomcat version
* **java**: the Java distribution and version, for example `jdk-8` or `jdk-8u272-bionic`
* **os**: the Operating System, for example `bionic` or `centos-7`

### Tomcat versions

In general, the latest update (minor version) of the last few major Tomcat releases are maintained:

* `8.5` - _Tomcat 8.5_ is thought as a replacement for _Tomcat 8.0_. _Tomcat 8.0_ is [end of life](http://tomcat.apache.org/tomcat-80-eol.html) and is not supported.
* `7.0`

### Base images

All the available Tomcat images are built on top of the `docker.io/xenit/openjdk` images.

## Contributions

### How to build

Builds are produced by [GitHub Actions](https://github.com/xenit-eu/docker-tomcat/actions) driving Gradle from a
GitHub workflow file.

To build a local version of the _tomcat_ images:

```
./gradlew buildDockerImage
```

