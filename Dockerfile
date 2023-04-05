FROM openjdk:17.0

COPY . . 

CMD ["./mvnw", "spring-boot:run"]