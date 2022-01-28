pwd
echo "开始构建"
//构建镜像
mvn clean package
mvn org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=true -DskipTests=false sonar:sonar -Dproject.settings=sonar-project.properties
cp target/springbootdemo-0.0.1-SNAPSHOT.war .
docker rm -f ${project}
docker image rm ${image_name}
docker build -f Dockerfile -t springbootdemo .