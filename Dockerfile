# 该镜像需要依赖的基础镜像
FROM java:8
# 将targer目录下的jar包复制到docker容器/home/springboot目录下面目录下面
ADD ./target/springbootdemo-0.0.1-SNAPSHOT.war /home/springboot/springbootdemo.war
# 声明服务运行在8080端口
EXPOSE 8088
# 执行命令
CMD ["java","-jar","/home/springboot/springboot-dockerfile.war"]