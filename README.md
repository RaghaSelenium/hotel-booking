# hotel-booking

hotel-booking is a test automation project to automate   http://hotel-test.equalexperts.io/. 

## Getting Started

These instructions will get you a copy of the project up and running on your local Ubuntu machine for development and testing purposes.


### Tools and Technologies

Java 1.8
Apache Maven 3.0.5
Selenium WebDriver
Cucumber

### Prerequisites

Below things are prerequisites for this project


 java 1.8 
 https://www.java.com/en/download/help/linux_x64_install.xml
 
 Maven 
 https://maven.apache.org/install.html
 
 Chrome version in ubuntu must be >= 65.0.3325.0 
 
 
  
### Running the tests:
 
 Chrome is the default browser, and the installed 
 
 Note: Currently this project runs only on chrome browser (The chromeDriver inside the project works only for ubuntu 64 bit)
 
#### Running the tests from terminal:


 Go to your project directory from terminal and hit following commands

 mvn test (runs on default chrome)
 
 mvn test "-Dbrowser=chrome" (to use any other browser)
 
 mvn test -Dcucumber.options="classpath:features/homePage.feature" to run specific feature.
 
### Test reports:

 html test reports can be found under target/cucumer-html-reports
 
 open index.html file in a browser to view the reports.
 
