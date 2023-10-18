# Components App Backend Deployment Guide

This README provides instructions for deploying and running the `components-app.war` using WildFly.

## Prerequisites

1. **Java 11**: Ensure you have Java 11 installed and set as the default. You can check by running:
    ```bash
    java -version
    ```

2. **WildFly**: Download and extract the appropriate version of WildFly (compatible with Java 11 and Jakarta EE 8, e.g., WildFly 19 or later) from the [official WildFly website](https://wildfly.org/downloads/).
Note:
We don’t plan to support Jakarta EE 8 in standard WildFly. The WildFly 26.1 releases will be the last that support EE 8.
## Deployment Steps

1. **Deploy the `.war` file to WildFly**:

   - Place the `components-app.war` into the `standalone/deployments/` directory of your WildFly installation.
   
2. **Start WildFly**:

   Navigate to the `bin` directory of your WildFly installation. Depending on your OS, execute the appropriate script:

   - For Linux/macOS:
   
     ```bash
     chmod +x standalone.sh
     ./standalone.sh
     ```

   - For Windows:
   
     ```bash
     standalone.bat
     ```

   This will start WildFly and it will automatically deploy the `components-app.war`.

3. **Verify the Application**:

   Once the application is up, it should be accessible at: `http://localhost:8080/components-app/`.

   You can use the following `cURL` command to ensure the application is responding:

    ```bash
    curl -I http://localhost:8080/components-app/
    ```

   A response with `HTTP/1.1 200 OK` indicates the application is running correctly.
In my case:
```
MacBook-Pro-2:bin macbook$ curl -I http://localhost:8080/components-app/
HTTP/1.1 200 
Set-Cookie: JSESSIONID=69E671DD49873577E17A0B7881483A95; Path=/components-app; HttpOnly
Content-Type: text/html;charset=ISO-8859-1
Transfer-Encoding: chunked
Date: Tue, 17 Oct 2023 22:10:10 GMT
```

Also:
```shell
curl -X GET http://localhost:8080/components-app/api/components

curl -X POST -H "Content-Type: application/json" -d '{"name": "New Component", "description": "Description of the component"}' http://localhost:8080/components-app/api/components

```