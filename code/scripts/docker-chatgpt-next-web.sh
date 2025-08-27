#!/bin/bash
# @ File: docker_gpt
# @ Editor: PyCharm
# @ Author: Ace (From Chengdu.China)
# @ HomePage: https://github.com/AceProfessional
# @ OS: Windows 11 Professional Workstation 22H2
# @ CreatedTime: 2023-05-16


docker run -d -p 90:3000 -e OPENAI_API_KEY="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" --name chat yidadaa/chatgpt-next-web:latest
