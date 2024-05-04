# Saucelabs Demo UI Automation - Selenium
##  ![#f03c15](https://via.placeholder.com/15/f03c15/f03c15.png) Overview
##### This project validates the Functional requirements of the Saucelabs Demo website, and is developed with the below technologies:-
###### Programming Language - Java(11)
###### Testing Library - Selenium(4.20.0)
###### Unit Test Library - TestNG(7.9.0)
###### Design Pattern - Page Object Modal(Page Factory)
###### Reporting - Extent Report
###### Build Management - Maven

##  ![#f03c15](https://via.placeholder.com/15/f03c15/f03c15.png) Project Structure
```bash
saucelabs-automation/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── listeners/
│   │   │   │   └── Listener.java
│   │   │   └── pages/
│   │   │   │   └── Login.java
│   │   │   └── utils/
│   │   │         └── Constants.java
│   │   │         └── DataProviders.java
│   │   │         └── Reports.java
│   │   │         └── TakeScreenshot.java
│   │   │ 
│   │   ├── resources/
│   │        └── config/
│   │        │   └── config.properties
│   │        │
│   │        └── testdata/
│   │            └── testdata.json
│   │   
│   │   
│   ├── test/
│        ├── java/
│        │      └── base/
│        │      │     └── Base.java
│        │      │
│        │      └──testcases/
│        │          └── Saucelabs.java
│        │
│        ├── resources/
│             └── regressionSuite.xml
│   
├── Reports/
├── Screenshots/
```

##  ![#f03c15](https://via.placeholder.com/15/f03c15/f03c15.png) Test Data Management
##### Test data is stored in a .json file and with the help for Jackson data-bind lib we are reading the json and providing it to test method with the help of testng data providers.

##  ![#f03c15](https://via.placeholder.com/15/f03c15/f03c15.png) Build Management
##### Maven was used in the project as Build and and Project management. All the librarys are downloaded from mvn repositiory.

##  ![#f03c15](https://via.placeholder.com/15/f03c15/f03c15.png) Usage
##### If you just want to understand the framework structure, it is there in the FrameworkStructure branch,run the below command to clone the framework
  ```bash
      git clone https://github.com/aman0795raj/Saucelab-Automation.git
 ```
  ######    Move to the Project folder
```bash
        cd Saucelab-Automation
```
###### Switch to the FrameworkStructure brach
```bash
git checkout FrameworkStructure
```

##### If you want to execute the end to end automation script, it is there in the main branch, run the below command:
```bash
git checkout main
cd Saucelab-Automation
mvn clean test -DBrowser=browserName -DSuite=suiteName
```
    
      
