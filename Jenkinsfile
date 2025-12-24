pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                // 确保 Jenkins 能够拉取代码
                sh 'git config --global http.sslBackend "openssl"'
                checkout scm
            }
        }
        //
        stage('Test Webhook Trigger') {
            steps {
                echo "GitHub webhook triggered this build successfully!"
                sh 'echo "Current commit: $(git rev-parse HEAD)"'
                sh 'ls -al' // 打印工作目录内容以确认代码已拉取
            }
        }
    }
}
