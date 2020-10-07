#!/usr/bin/env groovy

  stage('deploy'){
        echo  pwd()
        sshagent(['deploy_user']) {
    sh "scp  -o StrictHostKeyChecking=no target/RegApp2-0.0.1-SNAPSHOT.war ec2-user@13.233.244.215:/opt/apache-tomcat-8.5.58/webapps"
}

       
    }
