def call()  {
  pipeline {
    agent {
      label 'worker1'
    }
    stages {
        stage('Install Nginx') {
            steps {
                script {
                  sh 'whoami'
                  sh 'sudo apt update -y'
                  sh 'sudo apt install -y nginx'
                  echo 'installed nginx'
                }
            }
        }
        
        stage('Start Nginx') {
            steps {
                script {
                  sh 'sudo service nginx start'
                  echo 'started nginx'
                }
            }
        }
    }
    
    post {
        always {
            echo 'End nginx pipeline'
        }
    }
}

}
  
