


// def buildJar() {
//     sh 'mvn package'
// } 

// def buildImage() {
//     withCredentials([usernamePassword(credentialsId: 'DockerHub_Credientials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
//         sh 'docker build -t ahmedelbltagy/java-maven-app:1.1 .'
//         sh "echo $PASS | docker login -u $USER --password-stdin"
//         sh 'docker push ahmedelbltagy/java-maven-app:1.1'
//     }
// } 
// def buildImage() {
//         sh 'docker build -t java-maven-app .'
        
//     }

def PushImage(){
    withCredentials([usernamePassword(credentialsId: 'Nexus_Credientials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "echo $PASS | docker login -u $USER --password-stdin 192.168.206.129:8083"
        sh 'docker tag java-maven-app 192.168.206.129:8081/repository/java-maven-app'
        sh 'docker push 192.168.206.129:8083/repository/java-maven-app'
    }
}


def deployApp() {
    echo 'deploying the application...'
} 

return this