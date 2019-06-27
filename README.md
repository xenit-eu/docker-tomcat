# Apache Tomcat Docker Images

This repository contains Apache Tomcat images from XeniT.

Apache Tomcat (or simply Tomcat) is an open source web server and servlet container developed
by the Apache Software Foundation.

## Supported tags

* [7.0.94-jdk-7u221-centos-7, 7.0-jdk-7u221-centos-7, 7-jdk-7u221-centos-7]
* [alfresco-4.2-ubuntu, 7.0.94-jdk-7u211-trusty, 7.0-jdk-7u211-trusty, 7-jdk-7u211-trusty]
* [alfresco-5.0-ubuntu, alfresco-5.1-ubuntu, 7.0.94-jdk-8u212-trusty, 7.0-jdk-8u212-trusty, 7-jdk-8u212-trusty]
* [alfresco-5.2-ubuntu, 7.0.94-jdk-8u212-xenial, 7.0-jdk-8u212-xenial, 7-jdk-8u212-xenial, 7.0.94-xenial, 7.0-xenial, 7-xenial]
* [alfresco-6.0-ubuntu, alfresco-6.1-ubuntu, 8.5.42-jdk-11u3-bionic, 8.5-jdk-11u3-bionic, 8-jdk-11u3-bionic, 8.5.42-bionic, 8.5-bionic, 8-bionic]


## Quick reference

**Where to get help:**

Channel [#docker](https://xenitengineering.slack.com/app_redirect?channel=docker) on Slack

**Maintained by:**

Toon Geens <toon.geens@xenit.eu>, Roxana Angheluta <roxana.angheluta@xenit.eu>

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
* **java**: the Java distribution and version, for example `jdk-8` or `jdk-8u212-trusty`
* **os**: the Operating System, for example `xenial` or `centos-7`

### Tomcat versions

In general, the latest update (minor version) of the last few major Tomcat releases are maintained:

* `8.5` - _Tomcat 8.5_ is thought as a replacement for _Tomcat 8.0_. _Tomcat 8.0_ is [end of life](http://tomcat.apache.org/tomcat-80-eol.html) and is not supported.
* `7.0`

### Base images

All the available Tomcat images are built on top of the `xeniteu/openjdk` images.

## Contributions

### How to build

Release builds are produced by [Travis](https://travis-ci.org/xenit-eu/) driving Gradle from a `.travis.yml` file.

To build a local version of the _tomcat_ image:

```
./gradlew buildDockerImage
```

Note that locally build image-tags will be prefixed with `local-`, so they can be clearly distinguished from official
builds created and published from [Travis](https://travis-ci.org/xenit-eu/).