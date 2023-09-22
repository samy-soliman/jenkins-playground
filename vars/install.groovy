def call()  {
  pipeline {
    stages {
        stage('Install Nginx') {
            steps {
                script {
                  sh 'apt-get update'
                  sh 'apt-get install -y nginx'
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
  
