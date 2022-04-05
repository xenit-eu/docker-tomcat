# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)

## 2022-04

### Changed

* [2022-04-05] [PR #36](https://github.com/xenit-eu/docker-tomcat/pull/36) Update tomcat 8.5 & 9 to latest microversion to mitigate cve-2022-22965

## 2022-03

### Added

* [2022-03-30] [PR #32](https://github.com/xenit-eu/docker-tomcat/pull/31) Added alfresco-7.2-ubuntu tag

## 2022-02

### Added

* [2022-02-02] [PR #31](https://github.com/xenit-eu/docker-tomcat/pull/31) Added tomcat 9 build + alfresco-7.1-ubuntu tag

## 2021-04

### Changed

* [2021-12-10] [PR #29](https://github.com/xenit-eu/docker-tomcat/pull/29) Removed `centos` builds
* [2021-12-10] [PR #30](https://github.com/xenit-eu/docker-tomcat/pull/29) Use upstream images with unspecified jdk-minor version

## 2021-04

### Changed

* [2021-04-19] [PR #27](https://github.com/xenit-eu/docker-tomcat/pull/27) Support for application log deletion 	

## 2021-02

### Changed	
	
* [2021-02-22] [PR #23](https://github.com/xenit-eu/docker-tomcat/pull/23) Updated Java8 to jdk-8u275-b01
* [2021-02-01] [PR #20](https://github.com/xenit-eu/docker-tomcat/pull/20) Updated JDK to jdk-11.0.10

## 2020-12

### Changed

* [2020-12-05] [I-16](https://github.com/xenit-eu/docker-tomcat/issues/16) Move build from Travis to GitHub Actions

## 2020-10

### Changed

* [2020-10-28] [PR #14](https://github.com/xenit-eu/docker-tomcat/pull/14) Updated Tomcat to 7.0.106 / 8.5.59
* [2020-10-28] [PR #13](https://github.com/xenit-eu/docker-tomcat/pull/13) Updated JDK to jdk-11.0.9 and jdk-8u272 and for CentOS to jdk-7u261

## 2020-04

### Changed

* [2020-04-18] [PR #10](https://github.com/xenit-eu/docker-tomcat/pull/10) Updated JDK to [jdk-11.0.7](https://adoptopenjdk.net/release_notes.html?jvmVariant=hotspot#jdk11_0_7) and [jdk-8u252](https://adoptopenjdk.net/release_notes.html?jvmVariant=hotspot#jdk8u252)
* [2020-04-18] [PR #9](https://github.com/xenit-eu/docker-tomcat/pull/9) Updated Tomcat 8.5 to [8.5.54](http://tomcat.apache.org/tomcat-8.5-doc/changelog.html#Tomcat_8.5.54_(markt))

## 2020-03

### Changed

* [DOCKER-313] [PR #6](https://github.com/xenit-eu/docker-tomcat/pull/6) Updated Tomcat to 7.0.103 / 8.5.53 
* [DOCKER-297] [PR #4](https://github.com/xenit-eu/docker-tomcat/pull/4) Base JDK-8 ubuntu images on Bionic (18.04 LTS)
* [DOCKER-295] [PR #3](https://github.com/xenit-eu/docker-tomcat/pull/3) Make `relaxedQueryChars` and `relaxedPathChars` configurable
* [DOCKER-291] [PR #2](https://github.com/xenit-eu/docker-tomcat/pull/2) Updated Tomcat 8.5 to 8.5.49
* [DOCKER-123] [PR #1](https://github.com/xenit-eu/docker-tomcat/pull/1) Parametrize more variables in tomcat access valve: `maxDays` and `rotatable`
