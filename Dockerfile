FROM openjdk:21
WORKDIR /app
COPY ./build/libs/*.jar app.jar
EXPOSE 8090
ENV TZ Asia/Seoul
ENTRYPOINT ["sh", "-c", "java -jar -Dspring.profiles.active=dev /app.jar"]