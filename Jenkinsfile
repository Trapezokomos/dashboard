pipeline {
    agent any

    environment {
        GRADLE_HOME = tool 'Gradle 6.8.3'
        JDK_HOME = tool name: 'JDK 11', type: 'JDK'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-repo.git'
            }
        }
        stage('Build and Test') {
            steps {
                sh '''
                    export JAVA_HOME=$JDK_HOME
                    export PATH=$JAVA_HOME/bin:$PATH
                    $GRADLE_HOME/bin/gradle clean build
                '''
            }
        }
        stage('Static Code Analysis') {
            steps {
                sh '''
                    export JAVA_HOME=$JDK_HOME
                    export PATH=$JAVA_HOME/bin:$PATH
                    $GRADLE_HOME/bin/gradle checkstyleMain checkstyleTest
                '''
            }
        }
        stage('Integration Tests') {
            steps {
                sh '''
                    export JAVA_HOME=$JDK_HOME
                    export PATH=$JAVA_HOME/bin:$PATH
                    $GRADLE_HOME/bin/gradle integrationTest
                '''
            }
        }
        stage('System Tests') {
            steps {
                sh '''
                    export JAVA_HOME=$JDK_HOME
                    export PATH=$JAVA_HOME/bin:$PATH
                    $GRADLE_HOME/bin/gradle systemTest
                '''
            }
        }
        stage('Build and Package') {
            steps {
                sh '''
                    export JAVA_HOME=$JDK_HOME
                    export PATH=$JAVA_HOME/bin:$PATH
                    $GRADLE_HOME/bin/gradle assemble
                '''
            }
        }
        stage('Deploy to Staging') {
            steps {
                sh './deploy.sh staging'
            }
        }
        stage('Manual Approval') {
            steps {
                input 'Deploy to Production?'
            }
        }
        stage('Deploy to Production') {
            when {
                branch 'main'
            }
            steps {
                sh './deploy.sh production'
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'build/libs/*.jar', allowEmptyArchive: true
            junit 'build/test-results/test/*.xml'
        }
    }
}
