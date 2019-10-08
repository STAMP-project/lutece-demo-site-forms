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
//        sh 'camp generate -d . --coverage'
      }
    }
    stage('camp realize') {
      steps {
        sh 'camp realize -d .'
        zip zipFile: 'testconf.zip', archive: true, dir: 'out', glob: '**/*.yml'
        zip zipFile: 'dockerfiles.zip', archive: true, dir: 'out', glob: '**/Dockerfile'
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
