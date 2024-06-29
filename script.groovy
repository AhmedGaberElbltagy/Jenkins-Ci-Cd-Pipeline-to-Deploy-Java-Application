


def buildJar() {
    sh 'mvn package'
} 

def buildImage() {
    withCredentials([usernamePassword(credentialsId: 'DockerHub_Credientials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t ahmedelbltagy/java-maven-app .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push ahmedelbltagy/java-maven-app'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this