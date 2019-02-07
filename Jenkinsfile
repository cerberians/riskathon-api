pipeline {
    agent any
    environment {
        SHORT_COMMIT = sh(returnStdout: true, script: "git log -n 1 --pretty=format:'%h'").trim()
        BRANCH_NAME = sh(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD').trim()
        GIT_BRANCH = "origin/${env.BRANCH_NAME}"
    }
    stages {
        stage('Prepare') {
            steps {
                sh 'java -version'
                sh 'mvn --version'
                sh 'docker version'
                echo env.BRANCH_NAME
                echo env.GIT_BRANCH
                echo env.SHORT_COMMIT
            }
        }
        stage('Build and Test') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Deploy to development') {
            when {
                expression {
                    return env.GIT_BRANCH == 'origin/develop'
                }
            }
            steps {
                sh 'cp /var/riskathon/dev.env .env'
                sh 'cat .env'
                sh 'docker-compose down --remove-orphans'
                sh 'docker-compose up --remove-orphans --build --detach'
            }
        }
        stage('Deploy to production') {
            when {
                expression {
                    return env.GIT_BRANCH == 'origin/master'
                }
            }
            steps {
                sh 'cp /var/riskathon/prd.env .env'
                sh 'cat .env'
                sh 'docker-compose down --remove-orphans'
                sh 'docker-compose up --remove-orphans --build --detach'
            }
        }
    }
}