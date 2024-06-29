


def buildJar() {
    sh 'mvn package'
} 

// def buildImage() {
//     withCredentials([usernamePassword(credentialsId: 'DockerHub_Credientials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
//         sh 'docker build -t ahmedelbltagy/java-maven-app:1.1 .'
//         sh "echo $PASS | docker login -u $USER --password-stdin"
//         sh 'docker push ahmedelbltagy/java-maven-app:1.1'
//     }
// } 
def buildImage() {
    withCredentials([usernamePassword(credentialsId: 'Nexus_Credientials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        // sh 'docker build -t 192.168.206.129:8083/java-maven-app .'
        sh 'docker build -t java-maven-app:1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin 192.168.206.129:8083"
        sh 'docker tag java-maven-app:1.0 192.168.206.129:8083/repository/java-maven-app'
        // sh 'docker push 192.168.206.129:8083/repository/java-maven-app:1.0'
    }
} 


def deployApp() {
    echo 'deploying the application...'
} 

return this