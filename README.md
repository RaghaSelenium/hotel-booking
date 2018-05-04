selenium-cucumber-java-maven
 selenium-cucumber : Automation Testing Using Java

 selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web. It enables you to write and execute automated acceptance/unit tests. It is cross-platform, open source and free. Automate your test cases with minimal coding. More Details

 Documentation:
 
 Installation
 Predefined steps
 Download a Framework
 Maven - https://github.com/selenium-cucumber/selenium-cucumber-java-maven-example
 Framework Architecture
 Project-Name
 	|
 	|_src/main/java
 	|	|_appUnderTest
 	|	|	|_calc.apk
 	|	|	|...
 	|	|_browserConfigs
 	|	|	|_saucelab_windows_chrome.properties
 	|	|	|_browserstack_windows_chrome.properties
 	|	|	|...
 	|	|_platformConfigs
 	|		|_saucelab.properties
 	|		|_browserstack.properties
 	|		|...
 	|_src/main/resources
 	|_src/test/java
 	|	|_env
 	|	|	|_DriverUtil.java
 	|	|	|_Hooks.java
 	|	|	|_RunCukeTest.java
 	|	|_userStepDefinitions
 	|	|	|_loginSteps.java
 	|	|	|_signUpSteps.java
 	|	|	|...
 	|_src/test/resources
 	|	|_features
 	|	|	|_login.feature
 	|	|	|_signUp.feature
 src/test/resources/features - all the cucumber features files (files .feature ext) goes here.
 src/test/java/userStepDefinition - you can define step defintion under this package for your feature steps.
 src/test/java/env - this package contains cucumber runner (RunCukeTest.java) where you can configure your glue code location (step defintions), define test result output format.(html, json, xml). Hooks where you can configure all before and after test settings Hooks.java, DriverUtil.java contains code for intializing driver instances for respective driver.
 src/main/java/platformConfigs - If you want to run your test on saucelab and browserstack platforms, you need to add its configuration such as username, access key here.
 src/main/java/browserConfig - When you run your test on remote browser/platform you have to provide capabilities and platform information here.
 src/main/java/appUnderTest - If you are testing mobile based application you can keep your app build here.
 Writing a test
 The cucumber features goes in the features library and should have the ".feature" extension.

 You can start out by looking at features/my_first.feature. You can extend this feature or make your own features using some of the predefined steps that comes with selenium-cucumber.

 Predefined steps
 By using predefined steps you can automate your test cases more quickly, more efficiently and without much coding.

 The predefined steps are located here

 Running test
 Go to your project directory from terminal and hit following commands

 mvn test (defualt will run on local firefox browser)
 mvn test "-Dbrowser=chrome" (to use any other browser)
 mvn test -Dcucumber.options="classpath:features/my_first.feature" to run specific feature.
 mvn test -Dcucumber.options="–-plugin html:target/result-html" to generate a HTML report.
 mvn test -Dcucumber.options="–-plugin json:target/result-json" to generate a JSON report.
 Running test On remote browser/platform
 To run test on saucelab, browserstack or any other remote browser you need to create browser config file under src/main/java/browserConfig

 To run on saucelab create config file with name preceding with saucelab

 saucelab_windows_chrome.properties
 saucelab_mac_firefox.properties
 mvn test "-Dconfig=saucelab_mac_firefox"
 To run on browserstack create config file with name preceding with browserstack

 browserstack_windows_chrome.properties
 browserstack_mac_firefox.properties
 mvn test "-Dconfig=browserstack_mac_firefox"
 Maven/Gradle Dependency
 See https://jitpack.io/#selenium-cucumber/selenium-cucumber-java .
