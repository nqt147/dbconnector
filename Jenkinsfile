pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        echo 'hello'
      }
    }

    stage('run') {
      steps {
        echo 'run'
        sh '''PROJECT_NAME=$(basename $(dirname $JOB_NAME))
RELEASE_DIR=/smartpay/releases/apps
GIT_BRANCH_LOCAL=$(echo $GIT_BRANCH | sed -e "s|origin/||g")
echo $GIT_BRANCH_LOCAL
VERSION=$(echo $GIT_BRANCH | sed -e "s|origin/release/v||g")
echo $VERSION
echo $PROJECT_NAME > VERSION.md
echo $GIT_BRANCH_LOCAL >> VERSION.md
git show >> VERSION.md'''
      }
    }

  }
}