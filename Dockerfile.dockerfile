#Docker File
FROM openjdk:17


ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8086

CMD ["java", "-jar", "app.jar"]