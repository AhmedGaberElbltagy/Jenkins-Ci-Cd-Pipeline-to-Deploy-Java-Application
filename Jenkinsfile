def gv
pipeline {
    agent any
    tools{
        maven 'Maven'
    }
    stages {
        stage("initialize") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage(" test App") {
            steps {
                script {
                    echo "building jar"
                    sh 'mvn test'
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                    sh 'mvn --version'
                    sh 'mvn package'
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image"
                    //gv.buildImage()
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
