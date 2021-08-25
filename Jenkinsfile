pipeline {

  // Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  // Opciones espec�ficas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 		disableConcurrentBuilds()
  }

  // Secci�n que define las herramientas "preinstaladas" en Jenkins
  tools {
    jdk 'JDK8_Centos' // Versi�n preinstalada en la Configuraci�n del Master
  }
  
  /* 
   VERSIONES DISPONIBLES
	- JDK8_Mac
	- JDK6_Centos
	- JDK7_Centos
	- JDK8_Centos
	- JDK10_Centos
	- JDK11_Centos
	- JDK13_Centos
	- JDK14_Centos
  */

  // Aqu� comienzan los "etapas" del Pipeline
  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
        checkout([
			$class: 'GitSCM', 
			branches: [[name: '*/master']], 
			doGenerateSubmoduleConfigurations: false, 
			extensions: [], 
			gitTool: 'Default', 
			submoduleCfg: [], 
			userRemoteConfigs: [[
				credentialsId: 'GitHub_harvin.rengifo', 
				url:'https://github.com/harvin-ceiba/gestion-licitaciones'
			]]
		])
      }
    }
    
    stage('Compile & Unit Tests') {
      steps{
        echo "------------>Compile & Unit Tests<------------"
        sh 'chmod +x ./microservicio/gradlew'
		sh './microservicio/gradlew --b ./microservicio/build.gradle test'
      }
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>An�lisis de c�digo est�tico<------------'
        withSonarQubeEnv('Sonar') {
			sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
        }
      }
    }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
        // Construir sin tarea test que se ejecut� previamente
        sh './microservicio/gradlew --b ./microservicio/build.gradle build -x test'
      }
    }  
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
      junit 'build/test-results/test/*.xml' // Ruta de los archivos.XML
    }
    failure {
      echo 'This will run only if failed'
      // mail (to: 'harvin.rengifo@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}", body: "Something is wrong with ${env.BUILD_URL}")
    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}
