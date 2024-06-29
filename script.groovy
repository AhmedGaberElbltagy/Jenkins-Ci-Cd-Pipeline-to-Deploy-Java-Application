def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'DockerHub_Credientials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t ahmedelbltagy/java-maven-app .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push ahmedelbltagy/java-maven-app:jma-1.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this