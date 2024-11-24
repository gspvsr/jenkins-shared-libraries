def call(String Project, String ImageTag, String dockerHubUser) {
    withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
        // Login to Docker Hub using --password-stdin for secure password handling
        sh "echo ${dockerHubPass} | docker login -u ${dockerHubUser} --password-stdin"
    }
    // Push the Docker image
    sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
}
