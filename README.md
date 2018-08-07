# hotel-booking

hotel-booking is a test automation project to automate   http://hotel-test.equalexperts.io/. 

## Getting Started

These instructions will get you a copy of the project up and running on your local Ubuntu machine for development and testing purposes.
Currently it supports chromeDriver for Mac and Linux.


### Tools and Technologies

Java 1.8

Apache Maven 3.0.5

Selenium WebDriver

Cucumber

### Prerequisites

Below technologies are prerequisites for this project


 java 1.8 
 https://www.java.com/en/download/help/linux_x64_install.xml
 
 Maven 
 https://maven.apache.org/install.html
 
 Chrome version in ubuntu must be >= 65.0.3325.0 
 
  
### Running the tests:
 
 Chrome is the default browser
 
 Note: Currently this project supports Firefox and chromedriver both for ubuntu 64 bit and Mac 64 bit
 

#### Running the tests from terminal:

 Go to your project directory from terminal and hit following commands

 mvn test (runs on default chrome)
 
 mvn test "-Dbrowser=chrome" (to use any other browser, currently it works with chrome and firefox for Ubuntu and Mac OS)
 
 mvn test -Dcucumber.options="classpath:features/homePage.feature" to run specific feature.
 
 #### Running the tests from IDE:
 
  Run the Runner class.

 
### Test reports:

 html test reports can be found under target/cucumer-html-reports
 
 open index.html file in a browser to view the html reports.
 
