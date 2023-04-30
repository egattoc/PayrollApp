FROM openjdk:21-ea-20-oraclelinux8
COPY target/payrolldemo-0.0.1-SNAPSHOT.jar message-server-1.0.0.jar
ENTRYPOINT ["java","-jar","/message-server-1.0.0.jar"]