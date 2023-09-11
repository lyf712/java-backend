FROM ubuntu:latest
MAINTAINER Lyf712 "674619459@qq.com"
USER root

RUN echo "just test"
RUN echo "install vim"
RUN apt-get update
# 区别CMD
RUN apt-get install vim -y

EXPOSE 22
EXPOSE 80
CMD /usr/sbin/sshd -D