#!groovy
pipeline{
    agent any
    //定义仓库地址
    parameters {
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


        stage('构建镜像'){
            steps {
                echo "开始构建"
                //构建镜像
                sh 'mvn package -Dmaven.test.skip=true -Ptest docker:build'
            }
        }

        stage('停止原有服务'){
            steps{
                script {
                    try {
                        echo "停止服务"
                        sh 'docker stop ${project}'
                    } catch(ex) {

                    }
                }
            }
        }

        stage("启动服务"){
            steps {
                script {
                    try {
                        echo "启动服务"
                        // -v /etc/localtime:/etc/localtime:ro 同步时间
                        sh 'docker run -v /etc/localtime:/etc/localtime:ro --name ${project} -d -p 8082:8082 ${image_name}'
                    } catch(ex) {
                        sh 'docker start ${project}'
                    }
                }
            }
        }

    }
}