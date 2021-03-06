Set-Variable DB_NAME AMTDatabase
Set-Variable DB_TECHNICAL_USER AMTTechnicalUser
Set-Variable DB_TECHNICAL_USER_PASSWORD go
Set-Variable JDBC_CONNECTION_POOL_NAME AMTDatabase_pool
Set-Variable JDBC_JNDI_NAME "JDBC/AMTDatabase"
Set-Variable JAR_CONNECTOR "C:\Users\RigHitZ\Documents\Heig-VD\5semestre\AMT\workspaceAMT\labo4_JDBC"
Set-Variable DOMAIN_NAME domainAMT


cd "C:\Program Files\glassfish-4.1\glassfish\bin"

.\asadmin.bat stop-domain $DOMAIN_NAME
.\asadmin.bat delete-domain $DOMAIN_NAME

.\asadmin.bat create-domain --nopassword=true $DOMAIN_NAME


cp $JAR_CONNECTOR/mysql-connector-java-5.1.33-bin.jar ../domains/$DOMAIN_NAME/lib

.\asadmin.bat start-domain $DOMAIN_NAME


.\asadmin.bat create-jdbc-connection-pool --restype=javax.sql.XADataSource --datasourceclassname=com.mysql.jdbc.jdbc2.optional.MysqlXADataSource --property User="$DB_TECHNICAL_USER":Password="$DB_TECHNICAL_USER_PASSWORD":serverName=localhost:portNumber=3306:databaseName="$DB_NAME" "$JDBC_CONNECTION_POOL_NAME"
./asadmin.bat create-jdbc-resource --connectionpoolid $JDBC_CONNECTION_POOL_NAME $JDBC_JNDI_NAME