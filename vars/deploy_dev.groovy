#!/usr/bin/env groovy
def executeBuild(){
node {
    try{
    stage('SCM'){
    git 'https://github.com/ashwinihegde555/Maven_DB.git'
    }
    } catch(Exception e){
    throw e;
    }
    try{
    stage('Clean'){
        withMaven {
            sh "mvn clean"
        }
    }
    }catch(Exception e){
    throw e;
    }
    try{
      stage('Install'){
        withMaven {
            sh "mvn install"
        }
    }
    }catch(Exception e){
    throw e;
    }
    try{
       
    stage('Build'){
       withMaven {
         
     sh "mvn package"
    }
    }
    }catch(Exception e){
        throw e;
    }

    stage('deploy'){
       echo  pwd()
         sshagent(['deploy_user']) {
       sh "scp  -o StrictHostKeyChecking=no target/RegApp2-0.0.1-SNAPSHOT.war ec2-user@13.233.244.215:/opt/apache-tomcat-8.5.58/webapps"
         }  
    }
}
}
return this;

  
