# final_exam_TAE_academy

## Run project
Each feature (web/mobile) can be executed from its own runner class, located at ```src > test > java > org > finalExam > runners```

## Considerations

### Versions
* Version 7.2.0 of **Appium** is being used since the last one is not compatible with MobileElement [(source)](https://github.com/appium/java-client/blob/master/docs/v7-to-v8-migration-guide.md#mobileelement), thus, a major refactoring would be needed in the base project.
* Version 3.141.59 of **Selenium** is being used since the last one is not compatible with the implemented Appium version [(source)](https://github.com/appium/java-client/issues/1273#issuecomment-559773917).
* Version 6.14.3 of **TestNG** was selected since the last one is not compatible with Java 8 (which is the one installed in the computer where the project was built).

### Execution
* Different scenarios are used in each feature, in order to validate a single functionality/aspect in each of them.
* The second tag in all scenarios is unique; thus, it can be used in the runner class in order to execute a certain scenario.
* Data for web tests can be found and modified in the file named **web_data.json**, located at ```src > test > java > resources```.
* Web tests with the tag ```@logInProcedure``` might fail if, while logging in, the website requests a code for doing so (this code is sent to the registered email). It is recommended, either, retry the test, or to create a new account with all the information in the **web_data.json** file (using a different email).
