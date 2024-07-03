# Jenkins CI/CD Pipeline to Deploy Java Application

## Pipeline

![Pipeline](/images/Project-Diagram.png)

This project demonstrates a continuous integration and continuous delivery (CI/CD) pipeline for a Java application using Jenkins. The pipeline automates the build, test, artifact deployment, Docker image creation,

## Prerequisites

Before setting up the pipeline, ensure the following prerequisites are met:

- Jenkins server is set up and accessible.
- Docker is installed on the Jenkins server.

## Pipeline Overview

The Jenkins pipeline consists of several stages:

1. **Checkout**: This stage checks out the code from the GitHub repository.
2. **Build**: Maven builds the project.
3. **Unit Test**: Maven runs unit tests and collects test results.
4. **Store Artifact**: The built artifact (JAR file) is uploaded to the Nexus Repository.
6. **Build Docker Image**: Docker image for the application is built.

## How to Use

Follow these steps to use the CI/CD pipeline:

1. **Configure Jenkins**: Set up Jenkins with the required plugins and configurations.
2. **Configure Nexus Repository**: Set up Nexus Repository Manager and configure the repository.
3. **Set Jenkins Credentials**: Add credentials for GitHub, Nexus Repository to Jenkins.
5. **Create Jenkins Pipeline**: Create a new pipeline in Jenkins and paste the provided Jenkinsfile.
6. **Set up Webhook**: In your GitHub repository settings, navigate to "Webhooks" and add a new webhook pointing to your Jenkins server's URL. Configure the webhook to trigger on code push events. Ensure that the Jenkins GitHub plugin is installed and configured to receive webhook notifications.
7. **Run Pipeline**: Trigger the pipeline manually or set up a webhook for automatic triggering on code changes.

