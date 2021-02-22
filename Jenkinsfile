pipeline{
    agent any
    stages{
        stage("build & SonarQube analysis") {
            steps {
              withSonarQubeEnv('sonarlocal') {
                bat 'mvn verify sonar:sonar'
              }
            }
            post{
                always{
                    echo "========always========"
                }
                success{
                    echo "========A executed successfully========"
                }
                failure{
                    echo "========A execution failed========"
                }
            }
        }
    }
    post{
        always{
            echo "========always========"
        }
        success{
            echo "========pipeline executed successfully ========"
        }
        failure{
            echo "========pipeline execution failed========"
        }
    }
}