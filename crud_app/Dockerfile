FROM openjdk:11.0.7-jre-slim
EXPOSE 8380
ARG JAR_FILE=impl/target/*.jar
COPY ${JAR_FILE} organization-profile.jar
ENTRYPOINT ["java","-jar","organization-profile.jar"]