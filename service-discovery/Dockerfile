FROM maven:3.8.5-openjdk-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/*.jar ./service-discovery.jar
EXPOSE 8761
RUN pwd
RUN ls
ENTRYPOINT java -jar /app/service-discovery.jar