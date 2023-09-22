def call()  {
  pipeline {
    agent {
      label 'worker1'
    }
    stages {
        stage('Install Nginx') {
            steps {
                script {
                  sh 'apt update'
                  sh 'apt install -y nginx'
                  echo 'installed nginx'
                }
            }
        }
        
        stage('Start Nginx') {
            steps {
                script {
                  sh 'service nginx start'
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
  
