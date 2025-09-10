/****************************************************
 * @software: PyCharm
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-08 10:14:02 UTC+08:00
 ***************************************************/

function main(config) {
    const bilibiliChinaRuleList = [
        'DOMAIN-SUFFIX,bilibili.com,DIRECT',
        'DOMAIN-SUFFIX,bilivideo.com,DIRECT',
    ];

    config['rules'] = bilibiliChinaRuleList.concat(config['rules']);

    return config;
}
