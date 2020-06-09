pipeline {
   agent any

   tools {
      // Install the Maven version configured as "M3" and add it to the path.
      maven "M3"
   }
  stages {
      
       stage('Clone project') {
            
            steps {
                git credentialsId: '627763ac-2e37-4dc9-8ff9-346720fe632f', url: 'https://github.com/NoeliaCrucci/CursoAutomationCrowdar-WebFramework.git'
            }
        }

       
       stage('Run Maven on a Unix agent') {
            
            steps {

              sh "mvn clean package test"
            }
        }
   }
}
