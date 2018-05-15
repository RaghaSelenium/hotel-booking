
hotel-booking is a selenium, Java and cucumber project to test http://hotel-test.equalexperts.io/. 

tools and technologies:
 java 1.8
 Selenium WebDriver
 Cucumber
 
 
Running the tests:
 
 Chrome is the default browser, and the installed Chrome version in ubuntu must be >= 65.0.3325.0
 
 Note: Currently this project runs only on chrome browser (The chromeDriver inside the project works only for ubuntu 64 bit)
 
Running the tests from terminal

 Go to your project directory from terminal and hit following commands

 mvn test (runs on default chrome)
 mvn test "-Dbrowser=chrome" (to use any other browser)
 mvn test -Dcucumber.options="classpath:features/homePage.feature" to run specific feature.
 
Test reports:
 html test reports can be found under target/cucumer-html-reports
 open index.html file in a browser to view the reports.
 
