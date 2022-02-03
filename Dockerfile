FROM maven:3.6.3-jdk-8-slim AS build
MAINTAINER Osato Ojo
RUN mkdir -p /tax-calculator
WORKDIR /tax-calculator
COPY pom.xml /tax-calculator
COPY src /tax-calculator/src
RUN mvn -B clean package --file pom.xml
RUN #mvn -B clean package -Dmaven.test.skip=true --file pom.xml

FROM openjdk:8-jdk-alpine
ADD target/tax-calculator.jar tax-calculator.jar
EXPOSE 9031
ENTRYPOINT ["java", "-jar", "tax-calculator.jar"]



