FROM gradle:jdk21-jammy as build
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle $APP_HOME
RUN gradle dependencies --no-daemon
COPY . .
RUN gradle clean bootJar --no-daemon

FROM openjdk:21
ENV ARTIFACT_NAME=tourismo-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=build $APP_HOME/build/libs/$ARTIFACT_NAME .
EXPOSE 8080
ENTRYPOINT exec java -jar ${ARTIFACT_NAME}