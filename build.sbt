 node {
      def server = Artifactory.server 'myArtifactory'
      def rtMaven = Artifactory.newMavenBuild()
 

      stage 'Build'
          git url: 'https://github.com/antonbf/hello-world.git
  
     stage 'Artifactory configuration'
         rtMaven.tool = 'myMaven' //tool name from Jenkins configuration
         rtMaven.deployer releaseRepo:'libs-release-local', snapshotRepo:'libs-snapshot-local', server: server
         rtMaven.resolver releaseRepo:'libs-release', snapshotRepo:'libs-snapshot', server: server
         def buildInfo = Artifactory.newBuildInfo()
 
     stage 'Exec Maven'
         rtMaven.run pom: 'maven-example/pom.xml', goals: 'clean install', buildInfo: buildInfo
