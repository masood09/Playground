#!groovy

node('master') {
    stage('Checkout') {
        checkout scm
    }

    stage('Run tests') {
      withMaven(maven: 'Maven 3.5.2') {
          dir('hello-world') {
            sh 'mvn clean test -Dwebdriver.type=remote -Dwebdriver.url=http://192.168.2.12:4444/wd/hub -Dwebdriver.cap.browserName=chrome'
          }
      }
    }
}
