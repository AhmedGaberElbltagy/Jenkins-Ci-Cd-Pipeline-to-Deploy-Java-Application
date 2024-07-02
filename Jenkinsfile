#!/usr/bin/env groovy

@Library('Jenkins-Shared_library')
def gv

pipeline {
    agent any
    tools{
        maven 'Maven'
    }
    stages {
         stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage(" Build Jar ") {
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage(" Test App") {
            steps {
                script {
                   testApp()
                }
            }
        }
        stage(" Build Docker Image ") {
            steps {
                script {
                    echo "building the docker image..."
                    buildImage 'java-maven-app'
                }
            }
        }
        stage(" Push Docker Image to Nexus ") {
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
                    deploy()
                }
            }
        }
    }   
}
