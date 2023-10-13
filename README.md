# ASD-Project

## Getting Database connected (Using sqlite)
*1)
Download SQLite driver: [https://github.com/xerial/sqlite-jdbc/releases/tag/3.41.2.1](https://github.com/xerial/sqlite-jdbc/releases/tag/3.41.2.1)

*2)
Add the jar file to library. For intelij: [click here](https://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to-an-intellij-idea-project).
For netbeans: Import it into your project in Netbeans: simply right click "Libraries" folder in your project, then select "Add JAR".

*3)
Download and install DB Browser for SQLite: [https://sqlitebrowser.org/dl/](https://sqlitebrowser.org/dl/)

*4)
Open ASD_DB.db or ASD_DB_TEST.db for tests in db browser

## Downloads
Download Glassfish 7.0.3
https://projects.eclipse.org/projects/ee4j.glassfish/releases/7.0.3

Download db browser
https://sqlitebrowser.org/dl/

## Running application (I think, I'm not too sure)
*1)
Once repo is cloned or zip file it opened. Type mvn clean install in terminal

*2)
If using intelij you should be able to edit the glassfish configuration to run. Or type asadmin start-domain in console.

