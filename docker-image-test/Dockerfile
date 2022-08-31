# 基础镜像使用java
FROM java:8

#作者
MAINTAINER CJC

#将jar包添加到容器中并更名为: hello-docker-image.jar
ADD docker-image-test-0.0.1-SNAPSHOT.jar hello-docker-image.jar

#运行jar包
RUN bash -c 'touch hello-docker-image.jar'
ENTRYPOINT ["java","-jar","hello-docker-image.jar"]

#暴露端口
EXPOSE 8080