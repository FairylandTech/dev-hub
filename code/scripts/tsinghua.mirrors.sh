#!/bin/bash

echo 'Update Tsinghua.mirrors'
sudo sed -e 's|^mirrorlist=|#mirrorlist=|g' -e 's|^#baseurl=http://mirror.centos.org|baseurl=https://mirrors.tuna.tsinghua.edu.cn|g' -i.bak /etc/yum.repos.d/CentOS-*.repo
yum clean all
yum makecache
echo 'Done!'
echo 'update yum'
yum update -y
echo 'Done!'''
