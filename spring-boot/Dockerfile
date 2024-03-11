# 从基础通用镜像（JDK环境）进行构建
FROM openjdk:12-alpine
# 维护开发者
MAINTAINER lyf712
# 配置环境变量--来源java -jar启动（关键掌握java的启动指令）
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS="" \
    PROFILES="default"
# 改写--
ADD /target/*.jar /test.jar
# 执行命令
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /test.jar --spring.profiles.active=$PROFILES"]
# 暴露端口
EXPOSE 8080
