source /etc/profile
echo "开始构建"
mvn clean package
cp target/springbootdemo-0.0.1-SNAPSHOT.war .
docker rm -f springbootdemo
docker image rm springbootdemo
docker build -f Dockerfile -t springbootdemo .
docker run --name springbootdemo -d -p 8089:8089 springbootdemo