FROM eclipse-temurin:17-alpine
ADD ./build/libs/scheduler-0.0.1-SNAPSHOT.jar scheduler.jar
ENTRYPOINT ["java", "-jar", "scheduler.jar"]