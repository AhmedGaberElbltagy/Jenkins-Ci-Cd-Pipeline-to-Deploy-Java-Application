#!/usr/bin/env groovy

@Library('Jenkins-Shared_library')
def gv

pipeline {
    agent any
    tools{
        maven 'Maven'
    }
    stages {
   
        stage(" Test App") {
            steps {
                script {
                    testApp()
                }
            }
        }
        stage(" Build Jar ") {
            steps {
                script {
                    echo " Building The Application... "
                    buildJar()
                }
            }
        }
        stage(" Build image ") {
            steps {
                script {
                    echo "building the docker image..."
                    buildImage 'java-maven-app'
                }
            }
        }
        stage(" Push image to Nexus ") {
            steps {
                script {
                    dockerLogin()
                    pushImage 'java-maven-app'
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying"
                    
                }
            }
        }
    }   
}
