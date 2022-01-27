#!groovy
pipeline{
    agent any
    //定义仓库地址
    environment {
            REPOSITORY = "git@github.com:NJUcdx/springbootdemo.git"
            project = "springbootdemo" //项目名称
            image_name = "springbootdemo" //镜像名称
    }
    
    stages {

        stage('获取代码'){
            steps {
                echo "从 git:${REPOSITORY} 拉取代码"
                //清空当前目录
                deleteDir()
                //拉取代码
                git "${REPOSITORY}"
            }
        }

        stage('Code Analysis') {
            steps{
                container("maven") {
                    withSonarQubeEnv('sonarqube') {
                        sh "mvn sonar:sonar -Dproject.settings=sonar-project.properties"
                    }
                }
            }
        }


        stage('构建镜像'){
            steps {
                script{
                    echo "开始构建"
                    //构建镜像
                    sh 'mvn clean package'
                    sh 'cp target/springbootdemo-0.0.1-SNAPSHOT.war .'
                    sh 'docker rm -f ${project}'
                    sh 'docker image rm ${image_name}'
                    sh 'docker build -f Dockerfile -t springbootdemo .'
                }

            }
        }

        stage("启动服务"){
            steps {
                script {
                    echo "启动服务"
                    // -v /etc/localtime:/etc/localtime:ro 同步时间
                    sh 'docker run --name ${project} -d -p 8088:8088 ${image_name}'
//                     sh 'docker start ${project}'
                }
            }
        }

    }
}
