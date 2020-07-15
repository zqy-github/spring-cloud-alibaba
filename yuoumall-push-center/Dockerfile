# 基础镜像使用java
FROM openjdk:8-jre-slim
# 作者
MAINTAINER zqy
# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /tmp
# 将jar包添加到容器中并更名为app.jar
ADD yuoumall-push-center-0.0.2-SNAPSHOT.jar app.jar
# 运行jar包
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]




#FROM ubuntu:16.04.6
#MAINTAINER zqy
#
## 基础镜像使用java
#ADD jdk-8u77-linux-x64.tar.gz /usr/local/java
#
#ENV JAVA_HOME /usr/local/java/jdk1.8.0_77
#ENV PATH $JAVA_HOME/bin:$PATH
#ENV CLASSPATH .:$JAVA_HOME/lib