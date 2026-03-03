# SOFE3980 - Lab 1 - CRn75766 - 100792709 - Abdul Aziz Syed

# Introduction
This lab was about learning how to create a Maven project with Java and learn about dependencies, documentation, project structure, and various kinds of unit testing in aJava by creating my own tests for certain functions and tests. The task is/was to build a Maven project of a simple binary calculator and test it and package into a JAR.

# Deliverables
1. A GitHub link includes the whole project folder (except the target folder) with the final version of the binary class and the test cases.
2. A report discussing the source and testing code of the design part.
3. Audible video of about 3 minutes showing the building and running phases of the project as well as the passed tests. Also, show the generated documentation for the functions you added in the design section.

Put the GitHub link and video link inside your report, and submit the report.

# Methods/Tests	Description
**add(Binary a, Binary b):** Adds two binary numbers and returns a new Binary object  
**or(Binary a, Binary b):** Bitwise OR between two binary numbers  
**and(Binary a, Binary b):** Bitwise AND between two binary numbers  
**multiply(Binary a, Binary b):**	Multiplies two binary values  

# Project Build
1. Install necessary Java and Maven versions and dependencies
2. use *git clone* to clone repository in terminal
3. run *mvn clean package* to build project and compile code
4. run *mvn test* to test methods for correctness: Expected Output = *BUILD SUCESS , Tests run: 17, Failures: 0, Errors: 0*
5. run *mvn site* to activate the website
6. navigate to your folders/files and go to address *target/site/index.html* or *build-jar-...* files
7. run binary calculator in terminal with command: *java -jar target/BinaryCalculator-1.0.0-jar-with-dependencies.jar*

# Video Link (Youtube)
****https://www.youtube.com/watch?v=AdhBPpCkFpk****

