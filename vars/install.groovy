def call()  {
  pipeline {
    agent {
      label 'worker1'
    }
    stages {
        stage('Install Nginx') {
            steps {
                script {
                  sh 'sudo apt-get update'
                  sh 'sudo apt-get install -y nginx'
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
  
