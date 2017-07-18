#MYSQL images info:
https://hub.docker.com/_/mysql/

#Run MYSQL command:
docker run --detach --name devDB -e MYSQL_ROOT_PASSWORD=jitn1litw --publish 6603:3306 -d mysql:mysql

#Run MYSQL client command
docker run -it --link local-mysql:mysql --rm mysql sh -c 'exec mysql -h"$MYSQL_PORT_3306_TCP_ADDR" -P"$MYSQL_PORT_3306_TCP_PORT" -uroot -p"$MYSQL_ENV_MYSQL_ROOT_PASSWORD"'


#Link command:
docker run --name local-mysql --link some-mysql:mysql -d application-that-uses-mysql

#database dumps
docker exec local-mysql sh -c 'exec mysqldump --databases products_dev -uroot -p"$MYSQL_ROOT_PASSWORD"' > /data/db/db_dumps/products_dev.sql