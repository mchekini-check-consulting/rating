FROM openjdk:17-jdk-slim as build

WORKDIR /opt/ratings

COPY mvnw .
RUN chmod +x mvnw
COPY .mvn .mvn
COPY pom.xml .
RUN ./mvnw dependency:resolve
COPY src src
RUN ./mvnw package -DskipTests


FROM openjdk:17-jdk-slim

EXPOSE 8080

WORKDIR /opt/ratings

COPY --from=build /opt/ratings/target/ratings-*.jar ratings.jar

CMD [ "java", "-Xmn256m", "-Xmx768m", "-jar", "ratings.jar" ]