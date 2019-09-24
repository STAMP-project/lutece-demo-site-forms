pipeline {

  agent any
  stages {

    stage('build') {
      steps {
       sh '''cd template/lutece
          mvn lutece:site-assembly'''
      }
    }

    stage('camp generate') {
      steps {
        sh 'camp generate -d . --all'
      }
    }
    stage('camp realize') {
      steps {
        sh 'camp realize -d .'
        zip zipFile: 'conf.zip', archive: true, dir: 'out'
      }
    }
    stage('execute tests') {
      steps {
        sh 'camp execute'
	junit 'out/**/TEST*.xml'
      }
    }
  }

}
