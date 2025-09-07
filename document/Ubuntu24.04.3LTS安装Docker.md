# Ubuntu24.04.3LTS安装Docker

> @software: Typora  
> @author: [Lionel Johnson](https://fairy.host)  
> @contact: [Blog](https://blog.fairy.host/) | [GitHub](https://github.com/FairylandTech) | [Telegram](https://t.me/FairylandFuture)  
> @organization: [GitHub·FairylandFuture](https://github.com/FairylandFuture)  
> @datetime: 2025-09-07 12:42:24 UTC+08:00

[![Author](https://img.shields.io/badge/Author-Lionel_Johnson-orange)](https://t.me/FairylandFuture) [![github](https://img.shields.io/badge/Github-FairylandTech-green)](https://github.com/FairylandTech) [![GitBook](https://img.shields.io/badge/GitBook-Interesting-green)](https://interestingbooks.gitbook.io/) [![Editor](https://img.shields.io/badge/Editor-Typora-yellow)]() [![Language](https://img.shields.io/badge/Language-Markdown-orange)]() [![Version](https://img.shields.io/badge/Version-Release-blue)]() [![Docs](https://img.shields.io/badge/Docs-Passing-brightgreen)]() [![Type](https://img.shields.io/badge/Type-Documents-blue)]() [![wakatime](https://wakatime.com/badge/user/fa851759-c657-4b1e-8bcb-3ec3a693a2cd.svg)](https://wakatime.com/@fa851759-c657-4b1e-8bcb-3ec3a693a2cd) [![Sign](https://img.shields.io/badge/%E7%AD%89%E6%88%91%E4%BB%A3%E7%A0%81%E7%BC%96%E6%88%90-%E5%A8%B6%E4%BD%A0%E4%B8%BA%E5%A6%BB%E5%8F%AF%E5%A5%BD-red)](https://github.com/FairylandTech)

---

## 1. 卸载旧版本

```bash
for pkg in docker.io docker-doc docker-compose docker-compose-v2 podman-docker containerd runc; do sudo apt-get remove $pkg; done
```

## 2. 添加Docker仓库源

```bash
# Add Docker's official GPG key:
sudo apt-get update
sudo apt-get install ca-certificates curl
sudo install -m 0755 -d /etc/apt/keyrings
sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
sudo chmod a+r /etc/apt/keyrings/docker.asc

# Add the repository to Apt sources:
echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.asc] https://download.docker.com/linux/ubuntu \
  $(. /etc/os-release && echo "${UBUNTU_CODENAME:-$VERSION_CODENAME}") stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
sudo apt-get update
```

## 3. 安装Docker

```bash
sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
```

## 4. 普通用户加入到Docker用户组

查看是否有Docker用户组，一般的安装的时候Docker会自动创建

```bash
cat /etc/group | grep -i docker
```

如果没有输出，则需要手动创建

```bash
sudo groupadd docker
```

当前用户加入到Docker用户组

```bash
sudo usermod -aG docker $USER
```

重新登录生效或者执行命令

```bash
newgrp docker
```

## 5. 配置Docker

### 5.1 daeman.json

字段解析：

- `data-root`: 指定Docker的根目录，所有镜像、容器、卷等数据都将存储在此处。
- `storage-driver`: Docker 使用的存储驱动。`overlay2` 是当前推荐的驱动。
- `log-driver` 和 `log-opts`: 配置容器的默认日志驱动及相关选项。例如，可以设置日志文件的最大尺寸和数量，以防止日志文件无限增长。
- `ipv6`: 禁用ipv6网络。
- `tls`: 开启 TLS。
- `tlscert`: 服务器证书的路径。
- `tlskey`: 服务器私钥的路径。
- `tlscacert`: CA 证书的路径。
- `tlsverify`: **强制要求**客户端必须提供由可信 CA 签名的证书进行身份验证。这是保护 API 的关键。

```json
{
  "data-root": "/home/fairy/data/docker/",
  "storage-driver": "overlay2",
  "log-driver": "json-file",
  "log-opts": {
    "max-size": "10m",
    "max-file": "3"
  },
  "ipv6": false,
  "tls": true,
  "tlscert": "/etc/docker/tls/server-cert.pem",
  "tlskey": "/etc/docker/tls/server-key.pem",
  "tlscacert": "/etc/docker/tls/ca-cert.pem",
  "tlsverify": true
}
```

#### 生成TLS证书

查看服务器主机名称：

```bash
#!/bin/bash
# @software: PyCharm
# @author: Lionel Johnson
# @contact: https://fairy.host
# @organization: https://github.com/FairylandFuture
# @datetime: 2025-09-07 14:25:53 UTC+08:00

# 生成TLS和CA证书
# Version: 1.1: 已修复SANs问题

# 服务器主机名
SERVER="local.vm"
# 服务器IP地址
SERVER_IP="172.11.1.128"
# 密码
PASSWORD="iHsUQ7qYpmxjw5aA"
# 国家
COUNTRY="CN"
# 省份
STATE="四川省"
# 城市
CITY="成都市"
# 机构名称
ORGANIZATION="FairylandFuture Ltd."
# 机构单位
ORGANIZATIONAL_UNIT="IT Department"
# 邮箱
EMAIL="fairylandfuture@protonmail.com"

# 生成CA密钥
openssl genrsa -aes256 -passout pass:$PASSWORD -out ca-key.pem 2048

# 生成CA证书
openssl req -new -x509 -passin "pass:$PASSWORD" -days 3650 -key ca-key.pem -sha256 -out ca-cert.pem -subj "/C=$COUNTRY/ST=$STATE/L=$CITY/O=$ORGANIZATION/OU=$ORGANIZATIONAL_UNIT/CN=$SERVER/emailAddress=$EMAIL"

# 生成服务端密钥
openssl genrsa -out server-key.pem 2048

# 创建SAN配置文件
cat >server-extfile.cnf <<EOF
[req]
distinguished_name = req_distinguished_name
req_extensions = v3_req
prompt = no

[req_distinguished_name]
C = $COUNTRY
ST = $STATE
L = $CITY
O = $ORGANIZATION
OU = $ORGANIZATIONAL_UNIT
CN = $SERVER
emailAddress = $EMAIL

[v3_req]
subjectAltName = IP:0.0.0.0,@alt_names

[alt_names]
DNS.1 = $SERVER
IP.1 = $SERVER_IP
EOF

# 生成服务端证书签名的请求文件（包含SAN）
openssl req -new -key server-key.pem -out server-req.csr -config server-extfile.cnf

# 生成服务端证书（应用SAN扩展）
openssl x509 -req -days 3650 \
  -in server-req.csr \
  -CA ca-cert.pem \
  -CAkey ca-key.pem \
  -passin "pass:$PASSWORD" \
  -CAcreateserial \
  -out server-cert.pem \
  -extensions v3_req \
  -extfile server-extfile.cnf

# 生成客户端密钥
openssl genrsa -out client-key.pem 2048

# 生成客户端证书签名的请求文件
openssl req -subj '/CN=client' -new -key client-key.pem -out client-req.csr

# 生成客户端证书
sh -c 'echo "extendedKeyUsage=clientAuth" > client-extfile.cnf'
openssl x509 -req -days 3650 \
  -in client-req.csr \
  -CA ca-cert.pem \
  -CAkey ca-key.pem \
  -passin "pass:$PASSWORD" \
  -CAcreateserial \
  -out client-cert.pem \
  -extfile client-extfile.cnf

# 更改密钥权限
chmod 0400 ca-key.pem server-key.pem client-key.pem
# 更改证书权限
chmod 0444 ca-cert.pem server-cert.pem client-cert.pem
# 删除无用文件
rm -fv ca-cert.srl client-req.csr server-req.csr ./*.cnf

```

#### 复制到DockerTLS证书目录

```bash
sudo mkdir -p /etc/docker/tls
```

### 5.2 启用Bash的命令补全

安装`bash-completion`

```bash
sudo apt-get install bash-completion
```

生成并应用Docker补全脚本

```bash
docker completion bash | sudo tee /etc/bash_completion.d/docker > /dev/null
```

重新加载shell

```bash
source ~/.bashrc
```

### 5.3 配置 Docker API 访问

由`systemd`管理的`docker.service`位于`/usr/lib/systemd/system/docker.service`。可能位置不一样， 使用`systemctl status docker.service`可以查看

```bash
# 修改`Service.ExecStart`, 在后面追加
-H tcp://0.0.0.0:2376 -H unix:///var/run/docker.sock
```

docker.service样例：

```ini
[Unit]
Description=Docker Application Container Engine
Documentation=https://docs.docker.com
After=network-online.target nss-lookup.target docker.socket firewalld.service containerd.service time-set.target
Wants=network-online.target containerd.service
Requires=docker.socket
StartLimitBurst=3
StartLimitIntervalSec=60

[Service]
Type=notify
# the default is not to use systemd for cgroups because the delegate issues still
# exists and systemd currently does not support the cgroup feature set required
# for containers run by docker
ExecStart=/usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock -H tcp://0.0.0.0:2376 -H unix:///var/run/docker.sock
ExecReload=/bin/kill -s HUP $MAINPID
TimeoutStartSec=0
RestartSec=2
Restart=always

# Having non-zero Limit*s causes performance problems due to accounting overhead
# in the kernel. We recommend using cgroups to do container-local accounting.
LimitNPROC=infinity
LimitCORE=infinity

# Comment TasksMax if your systemd version does not support it.
# Only systemd 226 and above support this option.
TasksMax=infinity

# set delegate yes so that systemd does not reset the cgroups of docker containers
Delegate=yes

# kill only the docker process, not all processes in the cgroup
KillMode=process
OOMScoreAdjust=-500

[Install]
WantedBy=multi-user.target
```

