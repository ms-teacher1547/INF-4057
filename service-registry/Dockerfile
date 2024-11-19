FROM openjdk:17
VOLUME /tmp
ADD target/service-registry.jar service-registry.jar
ENTRYPOINT [ "java","-jar","/service-registry.jar" ]