/*plugins {
        id 'org.springframework.boot' version '2.6.12'
        id 'io.spring.dependency-management' version '1.0.14.RELEASE'
        id 'java'
        id "org.sonarqube" version "3.3"
        id 'jacoco'
        }

        group = 'notificacion-api-acl'
        version = '0.0.1-SNAPSHOT'
        sourceCompatibility = '1.8'

        apply plugin: 'jacoco'
        apply plugin: "org.sonarqube"

        configurations {
        compileOnly {
        extendsFrom annotationProcessor
        }
        }

        repositories {
        mavenCentral()
        }


        java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        }

        springBoot {
        buildInfo()
        }

        jacoco {
        toolVersion = "0.8.2"
        }

        test {
        systemProperty 'spring.profiles.active', 'test'
        useJUnitPlatform()
        finalizedBy jacocoTestReport // report is always generated after tests run
        }

        jacocoTestReport {
        dependsOn test // tests are required to run before generating the report
        reports {
        xml.enabled true
        csv.enabled false
        html.enabled true
        }
        }

        sonarqube {
        properties {
        property "sonar.sourceEncoding", "UTF-8"
        property "sonar.analysis.mode", "publish"
        property "sonar.issuesReport.html.enable", "true"
        property "sonar.scm.disabled", "true"
        }
        }

//create a single Jar with all dependencies
        task Install(type: Jar) {
        manifest {
        attributes 'Implementation-Title': 'ACLNotification',
        'Implementation-Version': version,
        'Main-Class': 'com.latam.pia.notifications.NotificacionApiAclApplication'
        }
        baseName = project.name
        from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
        with jar
        }

        jar {
        enabled = false
        }

        dependencies {
        implementation 'org.springframework.boot:spring-boot-starter-web'
        compileOnly 'org.projectlombok:lombok'
        annotationProcessor 'org.projectlombok:lombok'
        testImplementation 'org.springframework.boot:spring-boot-starter-test'
        implementation 'org.springframework.boot:spring-boot-starter-actuator:2.7.4'
        implementation 'org.springframework.boot:spring-boot-starter-mail:2.7.4'
        implementation 'org.springframework.retry:spring-retry:1.3.3'
        implementation 'org.springframework.boot:spring-boot-devtools:2.7.4'
        implementation 'org.apache.velocity:velocity:1.7'
        implementation 'org.apache.velocity:velocity-tools:2.0'
        implementation 'commons-validator:commons-validator:1.7'
        implementation 'commons-io:commons-io:2.11.0'
        implementation 'org.springdoc:springdoc-openapi-ui:1.6.14'
        implementation 'com.google.code.gson:gson:2.9.1'
        implementation 'com.fasterxml.jackson.core:jackson-databind:2.14.0-rc2'
        implementation 'org.springframework.boot:spring-boot-starter-validation:2.7.4'

        }

        tasks.named('test') {
        useJUnitPlatform()
        }

*/

