FROM openjdk
MAINTAINER lyf712 "674619459@qq.com"
WORKDIR /usr/local/
ENV PORT=80

ADD target/*.jar /usr/local/consumer.jar

ENTRYPOINT ["sh","-c","java -jar consumer.jar"]

EXPOSE $PORT

