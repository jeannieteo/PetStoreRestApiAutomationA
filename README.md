RestAssured TestNG API testing
<br />
APIS under test https://petstore.swagger.io/v2 <br />
<br />
Folder structure<br />
<br />
**--src----**</span><br />
&emsp;|**--main----**<br />
&emsp;|**--test----**<br />
    &emsp;&emsp;|**--resources-----** <br />
    &emsp;&emsp;&emsp;--log4j2.properties-----<br />
    &emsp;&emsp;&emsp;--route.properties-----<br />
    &emsp;&emsp;|**--java-----** <br />
    &emsp;&emsp;&emsp;|**--endpoints----** folder contains the paths of API<br />
     &emsp;&emsp;&emsp;&emsp;Routes.java<br />
     &emsp;&emsp;&emsp;&emsp;UserEndPoints.java<br />
     &emsp;&emsp;&emsp;&emsp;UserEndPointsA.java -alternate way to use routes.properties for the API urls instead of Routed.java<br />
    &emsp;&emsp;&emsp;|**--payloads----** folder contains pojos for model of API under test<br />
     &emsp;&emsp;&emsp;&emsp;User.java<br />
    &emsp;&emsp;&emsp;|**--testapi----** folder contains api tests<br />
     &emsp;&emsp;&emsp;&emsp;UserTest.java<br />
     &emsp;&emsp;&emsp;&emsp;dataUserTest.java<br />
    &emsp;&emsp;&emsp;|**--utilities----** folder contains utilities used<br />
     &emsp;&emsp;&emsp;&emsp;ExcelReader.java<br />
     &emsp;&emsp;&emsp;&emsp;ExtentReportManager.java<br />
pom.xml<br />
testng.xml<br />
