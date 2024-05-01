FROM openjdk:17-jdk-alpine
COPY target/gastroman.jar gastroman.jar
RUN mkdir "/logdir"
ENTRYPOINT ["java","-jar","gastroman.jar"]