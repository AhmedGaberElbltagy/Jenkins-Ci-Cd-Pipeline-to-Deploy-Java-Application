#!/usr/bin/env groovy

@Library('Jenkins-Shared_library')
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
                    echo " Building The Application... "
                    buildJar()
                }
            }
        }
        stage(" Build image ") {
            steps {
                script {
                    echo "building the docker image..."
                    buildImage 'java-maven-app:1.1'
                }
            }
        }
        stage(" Push image to Nexus ") {
            steps {
                script {
                    echo "Push image to Nexus"
                    pushImagetoNexus 'java-maven-app:1.1'
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
