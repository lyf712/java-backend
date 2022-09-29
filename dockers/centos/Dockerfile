# 制作centos 带有vim编辑器的镜像文件
FROM centos
# 环境变量
ENV WORK_DIR /usr/local
# 工作环境
WORKDIR $WORK_DIR
CMD cd /etc/yum.repos.d/
CMD sed -i 's/mirrorlist/#mirrorlist/g' /etc/yum.repos.d/CentOS-*
CMD sed -i 's|#baseurl=http://mirror.centos.org|baseurl=http://vault.centos.org|g' /etc/yum.repos.d/CentOS-*
CMD yum makecache
CMD yum update -y
CMD yum -y install vim
CMD yum -y net-tools.x86_64
CMD echo "make centos of vim success ok"