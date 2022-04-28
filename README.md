# GeriMedicaBDDFramework 

This Repo provides the solution of Abn Amro assignment on Reference app

**Pre-requisites:**
In order to complete this assignment , I used
--

* macOS High Sierra
* Eclipse
* Maven
* GitHub account
* GitHub CI
* JDK 11

**Automation Tools:**
--
* Cucumber
* Maven
* TestNG
* Selenium
* Extent Report
* Github CI

**Feature :**  scenario covered 
--
Feature file comprises below scenario's

* Scenario: Verify VangoghMuseum collection page
* Scenario: VangoghMuseum collectie searched title verification
* Scenario Outline: VangoghMuseum search result verification


**Framework Structure :**
--
<img width="320" alt="image" src="https://user-images.githubusercontent.com/82476790/165727580-3d8fe39e-380c-4615-a925-8a49eef8876e.png">

* Feature Folder: comprises of feature file
* MyRunner package: comprises of runner using testNG
* basePage: comprises base class
* Listeners : comprises testNG listeners
* enum package: browser, waitStrategy 
* factories package : explicit wait
* Report package : logger & extent report classes
* utilities package : screenshot & property file classes
* gerimedicaDriver package: selenium WebDriver related class
* PageObject package: page locator classes
* StepDefination package : stepDef clas
* resource: comprises property file 

**Executing cucumber BDD selenium test ** 
maven & java should be setup in system to run from cmd/terminal (console) 

**ZIP file:** extract the project & navigate to project path and type below command in terminal/cmd

`mvn test`

**GitHUB:** Git clone & navigate to project path and type below command in terminal/cmd

`mvn test`

**Running from IDE** : such as eclipse, intellij or visual etc
* Test can be executed by running testNG xml file (open testNG file and right click and run as testNG.xml)
or 
* Test can be executed by selecting pom.xml and perform right click ->select run as --> maven test

<img width="580" alt="image" src="https://user-images.githubusercontent.com/82476790/165731321-556f8841-eb34-46d1-b906-84f15779128a.png">

`mvn test`
 
**Note:**  After test execution extent report is created and launched automatically in default brower with test results & cucumber report link is generated in terminal logs & also inside target->cucumber-html-reporter folder .
Passed & failed screenshot get captured and attaced in extent report and screenshot folder.

These selenium BDD cucumber test can be executed on any CI such as Jenkins, GitHUB/GitLAB, azure CI etc

