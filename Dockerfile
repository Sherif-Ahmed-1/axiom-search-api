# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
Expose 8080
# copy jar to image
COPY /target/axiom-search-api-0.0.1-SNAPSHOT.jar /app.jar 
# run application with this command line 
CMD ["java", "-jar", "-Dspring.profiles.active=default", "app.jar"]
