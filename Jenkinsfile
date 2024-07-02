#!/usr/bin/env groovy

@library('Jenkins-Shared-Library')

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
                    // gv.buildImage()
                    buildJar()
                }
            }
        }
        stage(" Build image ") {
            steps {
                script {
                    echo "building the docker image..."
                    // gv.buildImage()
                    buildImage()
                }
            }
        }
        stage(" Push image to Nexus ") {
            steps {
                script {
                    echo "Push image to Nexus"
                    gv.PushImage()
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
