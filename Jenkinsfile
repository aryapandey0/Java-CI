pipeline {

    agent any

    stages{
      stage('Checkout'){
        steps{
          git branch : 'main' , url : 'https://github.com/aryapandey0/Java-CI.git'
        }
      }
      stage('Build'){
            steps{
              bat 'mvn clean package'}
            }
            }
            }


  
