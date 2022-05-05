FROM openjdk:11.0.7-jre-slim
EXPOSE 8360
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} organization-profile.jar
ENTRYPOINT ["java","-jar","organization-profile.jar"]