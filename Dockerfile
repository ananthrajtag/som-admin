From openjdk:8
copy ./target/som-admin.war som-admin.war
CMD ["java", "-jar", "som-admin.war" ]
