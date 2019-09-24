FROM tomcat:8.5.39-jre8

# define the fully qualified artifact of the site
ARG site=site-forms-demo-1.0.0-SNAPSHOT

COPY target/${site}/ /usr/local/tomcat/webapps/site-forms-demo

COPY db.properties /usr/local/tomcat/webapps/site-forms-demo/WEB-INF/conf/db.properties
