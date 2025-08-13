[toc]

# 2024 个人 IDE 的代码文件模版

适用于 JetBrains 全家桶的配置
不局限于编辑器, 以下按照文件来进行分类

## HTML File

```html
<!DOCTYPE html>
<!---------------------------------------------------------
@software: ${PRODUCT_NAME}
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
---------------------------------------------------------->
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>#[[$Title$]]#</title>
</head>
<body>
#[[$END$]]#
</body>
</html>
```

## CSS File

```css
/***************************************************
@software: ${PRODUCT_NAME}
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
***************************************************/
```

## Less File

```less
/***************************************************
@software: ${PRODUCT_NAME}
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
***************************************************/
```

## PostCSS

```postcss
/***************************************************
@software: ${PRODUCT_NAME}
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
***************************************************/
```

## Sass File

```sass
// @software: ${PRODUCT_NAME}
// @author: Lionel Johnson
// @contact: https://fairy.host
// @organization: https://github.com/FairylandFuture
// @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00

```

## SCSS File

```scss
/***************************************************
@software: ${PRODUCT_NAME}
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
***************************************************/
```

## Stylus File

```stylus
/***************************************************
@software: ${PRODUCT_NAME}
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
***************************************************/
```

## Kubernetes Pod

```yaml
# @software: ${PRODUCT_NAME}
# @author: Lionel Johnson
# @contact: https://fairy.host
# @organization: https://github.com/FairylandFuture
# @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00

---
apiVersion: v1
kind: Pod
metadata:
  name: #[[$Title$]]#
  labels:
    app: #[[$Title$]]#
spec:
  containers:
    - name: #[[$Title$]]#
      image: #[[$Image$]]#
      imagePullPolicy: IfNotPresent
  restartPolicy: Always
  #[[$END$]]#
```

## Kubernetes Deployment

```yaml
# @software: ${PRODUCT_NAME}
# @author: Lionel Johnson
# @contact: https://fairy.host
# @organization: https://github.com/FairylandFuture
# @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00

---
apiVersion: apps/v1
kind: Deployment
metadata:
  name: #[[$Title$]]#
  labels:
    app: #[[$Title$]]#
spec:
  replicas: 1
  selector:
    matchLabels:
      app: #[[$Title$]]#
  template:
    metadata:
      name: #[[$Title$]]#
      labels:
        app: #[[$Title$]]#
    spec:
      containers:
        - name: #[[$Title$]]#
          image: #[[$Image$]]#
          imagePullPolicy: IfNotPresent
      restartPolicy: Always
      #[[$END$]]#
```

## Kubernetes ConfigMap

```yaml
# @software: ${PRODUCT_NAME}
# @author: Lionel Johnson
# @contact: https://fairy.host
# @organization: https://github.com/FairylandFuture
# @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00

---
kind: ConfigMap
metadata:
  name: #[[$Title$]]#
data:
  key: "#[[$Value$]]#"
  #[[$END$]]#
```

## Kubernetes Service

```yaml
# @software: ${PRODUCT_NAME}
# @author: Lionel Johnson
# @contact: https://fairy.host
# @organization: https://github.com/FairylandFuture
# @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00

---
apiVersion: v1
kind: Service
metadata:
  name: #[[$Title$]]#
spec:
  selector:
    app: #[[$Title$]]#
  ports:
    - protocol: TCP
      port: 80
      targetPort: 8080
  type: NodePort
  #[[$END$]]#
```

## Kubernetess Ingress

```yaml
# @software: ${PRODUCT_NAME}
# @author: Lionel Johnson
# @contact: https://fairy.host
# @organization: https://github.com/FairylandFuture
# @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00

---
apiVersion: networking.k8s.io/v1
kind: Ingress
metadata:
  name: #[[$Title$]]#
  annotations:
    nginx.ingress.kubernetes.io/rewrite-target: /
spec:
  ingressClassName: nginx
  rules:
    - http:
        paths:
          - path: /api
            pathType: Prefix
            backend:
              service:
                name: #[[$ServiceTitle$]]#
                port:
                  number: 80
                #[[$END$]]#
```

## Kubernetes CronJob

```yaml
# @software: ${PRODUCT_NAME}
# @author: Lionel Johnson
# @contact: https://fairy.host
# @organization: https://github.com/FairylandFuture
# @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00

---
apiVersion: batch/v1
kind: CronJob
metadata:
  name: #[[$Title$]]#
spec:
  schedule: "* * * * *" #	Run every minute
  jobTemplate:
    spec:
      template:
        spec:
          containers:
            - name: #[[$Title$]]#
              image: busybox:latest
              imagePullPolicy: IfNotPresent
              command:
                - /bin/sh
                - -c
                - date; echo Hello!
          restartPolicy: OnFailure
```

## JavaScript File

```javascript
/****************************************************
 * @software: ${PRODUCT_NAME}
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
 ***************************************************/
```

## TypeScript File

```typescript
/****************************************************
 * @software: ${PRODUCT_NAME}
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
 ***************************************************/
```

## JSX File

```typescript jsx
/****************************************************
 * @software: ${PRODUCT_NAME}
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
 ***************************************************/
```

## TypeScript JSX File

```typescript jsx
/****************************************************
 * @software: ${PRODUCT_NAME}
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
 ***************************************************/
```

## Python Script

```python
# coding: UTF-8
"""
@software: ${PRODUCT_NAME}
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
"""

```

## Python Stub

```python
# coding: UTF-8
"""
@software: ${PRODUCT_NAME}
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
"""

```

## Python Unit Test

```python
# coding: UTF-8
"""
@software: ${PRODUCT_NAME}
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
"""

import unittest

class MyTestCase(unittest.TestCase):
    def test_something(self):
        self.assertEqual(True, False)  # add assertion here

if __name__ == '__main__':
    unittest.main()

```

## Python Setup Script

```python
# coding: UTF-8
"""
@software: ${PRODUCT_NAME}
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
"""

$Import

setup(
    name='$Package_name',
    version='$Version',
    packages=$PackageList,$PackageDirs
    url='$URL',
    license='$License',
    author='$Author',
    author_email='$Author_Email',
    description='$Description'
)

```

## Python Flask Main

```python
# coding: UTF-8
"""
@software: ${PRODUCT_NAME}
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
"""

from flask import Flask
app = Flask(__name__)

@app.route('/')
def hello_world():  # put application's code here
    return 'Hello World!'

if __name__ == '__main__':
    app.run()

```

## BashSupport Pro Bash

```bash
#!#[[$SHEBANG$]]#
# @software: ${PRODUCT_NAME}
# @author: Lionel Johnson
# @contact: https://fairy.host
# @organization: https://github.com/FairylandFuture
# @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00

# Terminal output color
RESET_COLOR="\e[0m"
RED_COLOR="\e[31m"
GREEN_COLOR="\e[32m"

main() {
  #[[$END$]]#
}

main
```

## BashSupport Pro POSIX

```bash
#!/bin/sh
# @software: ${PRODUCT_NAME}
# @author: Lionel Johnson
# @contact: https://fairy.host
# @organization: https://github.com/FairylandFuture
# @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00

# Terminal output color
RESET_COLOR="\e[0m"
RED_COLOR="\e[31m"
GREEN_COLOR="\e[32m"

main() {
  #[[$END$]]#
}

main
```

## BashSupport Pro Google Style Guide

```bash
#!/bin/bash
# @software: ${PRODUCT_NAME}
# @author: Lionel Johnson
# @contact: https://fairy.host
# @organization: https://github.com/FairylandFuture
# @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00


# #[[$DESCRIPTION$]]#
#[[$COPYRIGHT_OPTIONAL$]]#

function main() {
    :#[[$END$]]#
}

main "$@"
```

## BashSupport Pro bats-core

```bash
#!/usr/bin/env bats
# @software: ${PRODUCT_NAME}
# @author: Lionel Johnson
# @contact: https://fairy.host
# @organization: https://github.com/FairylandFuture
# @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00

setup() {
    # #[[$BATS_SETUP_COMMENT$]]#
    echo "setup" >&3
}

teardown() {
    # #[[$BATS_TEARDOWN_COMMENT$]]#
    echo "teardown" >&3
}

@test "#[[$test_name$]]#" {
    true#[[$END$]]#
}
```

## Ansible Playbook File

```yaml
# @software: ${PRODUCT_NAME}
# @author: Lionel Johnson
# @contact: https://fairy.host
# @organization: https://github.com/FairylandFuture
# @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
```

## SQL File

```mysql
/*****************************************************
 * @software: ${PRODUCT_NAME}
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
 *****************************************************/

```

## Nginx Config File

```nginx
# @software: ${PRODUCT_NAME}
# @author: Lionel Johnson
# @contact: https://fairy.host
# @organization: https://github.com/FairylandFuture
# @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00

```

## README File

```markdown
# ${PROJECT_NAME}

> @software: ${PRODUCT_NAME}  
> @author: [Lionel Johnson](https://fairy.host)  
> @contact: [Blog](https://blog.fairy.host/) | [GitHub](https://github.com/FairylandTech) | [Telegram](https://t.me/FairylandFuture)  
> @organization: [GitHub·FairylandFuture](https://github.com/FairylandFuture)  
> @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00

[![Author](https://img.shields.io/badge/Author-Lionel_Johnson-orange)](https://t.me/FairylandFuture) [![github](https://img.shields.io/badge/Github-PrettiestFairy-green)](https://github.com/FairylandTech) [![GitBook](https://img.shields.io/badge/GitBook-Interesting-green)](https://interestingbooks.gitbook.io/) [![Editor](https://img.shields.io/badge/Editor-Typora-yellow)]() [![Language](https://img.shields.io/badge/Language-Markdown-orange)]() [![Version](https://img.shields.io/badge/Version-Release-blue)]() [![Docs](https://img.shields.io/badge/Docs-Passing-brightgreen)]() [![Type](https://img.shields.io/badge/Type-Documents-blue)]() [![wakatime](https://wakatime.com/badge/user/fa851759-c657-4b1e-8bcb-3ec3a693a2cd.svg)](https://wakatime.com/@fa851759-c657-4b1e-8bcb-3ec3a693a2cd) [![Sign](https://img.shields.io/badge/%E7%AD%89%E6%88%91%E4%BB%A3%E7%A0%81%E7%BC%96%E6%88%90-%E5%A8%B6%E4%BD%A0%E4%B8%BA%E5%A6%BB%E5%8F%AF%E5%A5%BD-red)](https://github.com/FairylandTech)

---

Development Environment
**Please Higher than the version below**

[![DEV](https://img.shields.io/badge/Env-Win/Mac/Linux-%230078D4?logo=windows11&logoColor=%230078D4)]() [![VCS](https://img.shields.io/badge/VCS-GitHub-%23181717?logo=github&logoColor=%23181717)](https://github.com/FairylandTech) [![Anaconda](https://img.shields.io/badge/Anaconda-latest-%2344A833?logo=anaconda&logoColor=%2344A833)](https://www.anaconda.com/download#downloads) [![Python](https://img.shields.io/badge/Python-3.11.x-%233776AB?logo=python&logoColor=%233776AB)](https://www.python.org/downloads/release/python-3913/) [![Pip](https://img.shields.io/badge/PIP-24.x.x-%233775A9?logo=pypi&logoColor=%233775A9)](https://pypi.org/) ![MySQL](https://img.shields.io/badge/MySQL-8.0.35-%234479A1?logo=mysql&logoColor=%234479A1) [![GO](https://img.shields.io/badge/Go-1.20.6-%2300ADD8?logo=go&logoColor=%2300ADD8)](https://go.dev/dl/) ![NodeJS](https://img.shields.io/badge/Node-18.19-%23339933?logo=nodedotjs&logoColor=%23339933) ![Npm](https://img.shields.io/badge/Npm-10.x.x-%23CB3837?logo=npm&logoColor=%23CB3837) ![Pnpm](https://img.shields.io/badge/Pnpm-8.7.6-%23F69220?logo=pnpm&logoColor=%23F69220) ![Yarn](https://img.shields.io/badge/Yarn-1.22.19-%232C8EBB?logo=yarn&logoColor=%232C8EBB) ![Maven](https://img.shields.io/badge/Maven-3.9.1-%23C71A36?logo=apachemaven&logoColor=%23C71A36) ![Perl](https://img.shields.io/badge/Perl-8.3.0-%2339457E?logo=perl&logoColor=%2339457E) [![jetbrains](https://img.shields.io/badge/Jetbrains_IDE-Release-%2347f38a?logo=jetbrains&logoColor=%2347f38a)](https://www.jetbrains.com/) [![Deployment](https://img.shields.io/badge/Deployment-Docker-%232496ED?logo=docker&logoColor=%232496ED)](https://www.docker.com/) [![Deployment](https://img.shields.io/badge/Deployment-Kubernetes-%23326CE5?logo=kubernetes&logoColor=%23326CE5)](https://kubernetes.io/)

---

```

## Markdown

```markdown
# ${PROJECT_NAME}

> @software: ${PRODUCT_NAME}  
> @author: [Lionel Johnson](https://fairy.host)  
> @contact: [Blog](https://blog.fairy.host/) | [GitHub](https://github.com/FairylandTech) | [Telegram](https://t.me/FairylandFuture)  
> @organization: [GitHub·FairylandFuture](https://github.com/FairylandFuture)  
> @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00

[![Author](https://img.shields.io/badge/Author-Lionel_Johnson-orange)](https://t.me/FairylandFuture) [![github](https://img.shields.io/badge/Github-FairylandTech-green)](https://github.com/FairylandTech) [![GitBook](https://img.shields.io/badge/GitBook-Interesting-green)](https://interestingbooks.gitbook.io/) [![Editor](https://img.shields.io/badge/Editor-Typora-yellow)]() [![Language](https://img.shields.io/badge/Language-Markdown-orange)]() [![Version](https://img.shields.io/badge/Version-Release-blue)]() [![Docs](https://img.shields.io/badge/Docs-Passing-brightgreen)]() [![Type](https://img.shields.io/badge/Type-Documents-blue)]() [![wakatime](https://wakatime.com/badge/user/fa851759-c657-4b1e-8bcb-3ec3a693a2cd.svg)](https://wakatime.com/@fa851759-c657-4b1e-8bcb-3ec3a693a2cd) [![Sign](https://img.shields.io/badge/%E7%AD%89%E6%88%91%E4%BB%A3%E7%A0%81%E7%BC%96%E6%88%90-%E5%A8%B6%E4%BD%A0%E4%B8%BA%E5%A6%BB%E5%8F%AF%E5%A5%BD-red)](https://github.com/FairylandTech)

---

```

## Yaml File

```yaml
# @software: ${PRODUCT_NAME}
# @author: Lionel Johnson
# @contact: https://fairy.host
# @organization: https://github.com/FairylandFuture
# @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
---

```

## Java Class

```java
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")
/****************************************************
 * @software: ${PRODUCT_NAME}
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
 ***************************************************/

/**
 *@author Lionel Johnson
 */
public class ${NAME} {
}

```

## Java Interface

```java
/*****************************************************
 * @software: ${PRODUCT_NAME}
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
 *****************************************************/
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

/**
 *@author Lionel Johnson
 */
public interface ${NAME} {
}

```

## Java Enum

```java
/*****************************************************
 * @software: ${PRODUCT_NAME}
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
 *****************************************************/
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

/**
 *@author Lionel Johnson
 */
public enum ${NAME} {
}

```

## Java Record

```java
/*****************************************************
 * @software: ${PRODUCT_NAME}
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
 *****************************************************/
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

/**
 *@author Lionel Johnson
 */
public record ${NAME}() {
}

```

## Java AnnotationType

```java
/*****************************************************
 * @software: ${PRODUCT_NAME}
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}:${SECOND} UTC+08:00
 *****************************************************/
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

/**
 *@author Lionel Johnson
 */
public @interface ${NAME} {
}

```
