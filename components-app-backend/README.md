# Components App Backend Deployment Guide

This README provides instructions for deploying and running the `components-app.war` using Apache Tomcat.

## Prerequisites

1. **Java 11**: Ensure you have Java 11 installed and set as the default. You can check by running:
    ```bash
    java -version
    ```

2. **Apache Tomcat**: Download and extract the latest version of Apache Tomcat (compatible with Java 11 and Jakarta EE 8, example Tomcat 9) from the [official Tomcat website](https://tomcat.apache.org/download-90.cgi).

## Deployment Steps

1. **Deploy the `.war` file to Tomcat**:

   - Place the `components-app.war` into the `webapps` directory of your Tomcat installation.
   
2. **Start Tomcat**:

   Navigate to the `bin` directory of your Tomcat installation. Depending on your OS, execute the appropriate script:

   - For Linux/macOS:
   
     ```bash
     chmod +x catalina.sh
     or
     ./catalina.sh start
     sh startup.sh
     ```

   - For Windows:
   
     ```bash
     startup.bat
     ```

   This will launch Tomcat and it will automatically deploy the `components-app.war`.

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