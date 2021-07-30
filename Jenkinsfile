// 将以下示例 复制到您的仓库中并命名为 Jenkinsfile
// Jenkinsfile (Declarative Pipeline)
pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        stage('build') {
            steps {
                echo 'Hello World'
                sh 'mvn --version'
            }
        }
    }
}
