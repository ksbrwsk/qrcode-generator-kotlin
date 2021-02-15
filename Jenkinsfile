node {
    stage 'Clone the project'
    git 'https://github.com/ksbrwsk/qrcode-generator-kotlin.git'

    stage("Compilation and Analysis") {
      parallel 'Compilation': {
        sh "./mvnw clean install -DskipTests"
      }
    }

    stage("Tests and Deployment") {
      parallel 'Unit tests': {
        stage("Running unit tests") {
          sh "./mvnw test"
        }
      }
    }

}