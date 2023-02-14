FROM maven:3.8.5-openjdk-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/*.jar ./mscard.jar
ENTRYPOINT java -jar /app/mscard.jar
CMD  ["docker", "push", "carlosbarbosafilho/ms-cards:0.0.1"]