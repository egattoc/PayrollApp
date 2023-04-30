#!/bin/bash

echo "running mysqldb"
docker run -d -e MYSQL_ROOT_PASSWORD=secret -e MYSQL_DATABASE=payrolldb --name mysqldb -p 3307:3306 mysql:8.0
cd payrolldemo/
echo "building the payroll application"
docker build --tag=payroll-server:latest .
echo "running the payroll application"
docker run -p 8887:8000 payroll-server:latest