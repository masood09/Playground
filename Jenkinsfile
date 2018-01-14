#!groovy

node('master') {
    stage('Checkout') {
        checkout scm
    }

    stage('Run tests') {
      withMaven(maven: 'Maven 3.5.2') {
          dir('hello-world') {
            sh 'mvn clean test -Dwebdriver.type=chrome -Dwebdriver.chrome.driver=../drivers/chromedriver'
          }
      }
    }
}
