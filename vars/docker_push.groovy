def call(String Project, String ImageTag, String dockerHubHser){
  withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
      sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
  }
  sh "sudo docker push ${dockerHubUser}/${Project}:${ImageTag}"
}
