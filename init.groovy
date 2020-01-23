#!groovy

import jenkins.model.*
import hudson.security.*;
import hudson.util.*;
import jenkins.install.*;

def instance = Jenkins.getInstance()

def hudsonRealm = new HudsonPrivateSecurityRealm(false)

hudsonRealm.createAccount("admin","admin")

instance.setInstallState(InstallState.INITIAL_SETUP_COMPLETED)
instance.setSecurityRealm(hudsonRealm)

instance.save()

println "User admin created"