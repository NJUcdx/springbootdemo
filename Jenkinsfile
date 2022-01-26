#!groovy
pipeline{
    agent any
    //定义仓库地址
    parameters {
        string(name: 'REPOSITORY', defaultValue: 'git@github.com:NJUcdx/springbootdemo.git', description: 'github address')
        string(name: 'project', defaultValue: 'springbootdemo', description: 'project name')
        string(name: 'image_name', defaultValue: 'springbootdemo', description: 'image name')
    }

    stages {

        stage('获取代码'){
            steps {
                sh 'pwd'
                echo "从 git:${params.REPOSITORY} 拉取代码"
                //清空当前目录
                deleteDir()
                //拉取代码
                git "${params.REPOSITORY}"
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
                        sh 'docker stop ${params.project}'
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
                        sh 'docker run -v /etc/localtime:/etc/localtime:ro --name ${params.project} -d -p 8082:8082 ${params.image_name}'
                    } catch(ex) {
                        sh 'docker start ${params.project}'
                    }
                }
            }
        }

    }
}
