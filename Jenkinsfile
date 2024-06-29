def gv
pipeline {
    agent any
    tools{
        maven 'Maven'
    }
    stages {
        stage(" Initialize ") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage(" Test App") {
            steps {
                script {
                    echo "testing the Application"
                    sh 'mvn test'
                }
            }
        }
        stage(" Build Jar ") {
            steps {
                script {
                    echo "building jar"
                    sh 'mvn --version'
                    sh 'mvn package'
                }
            }
        }
        stage(" Build image ") {
            steps {
                script {
                    echo " Building The Image"
                    gv.buildImage()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying"
                    //gv.deployApp()
                }
            }
        }
    }   
}
