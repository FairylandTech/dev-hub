/****************************************************
 * @software: PyCharm
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-11 11:47:47 UTC+08:00
 ***************************************************/


export default class ConfigEntity {
    constructor(configData) {
        // --- 基本配置 ---
        this.port = configData.port || 7890;
        this.socksPort = configData.socksPort || 7891;
        this.allowLan = configData.allowLan || true;
        this.bindAddress = configData.bindAddress || "*";
        this.mode = configData.mode || 'rule';
        this.logLevel = configData.logLevel || 'info';
        this.ipv6 = configData.ipv6 || false;

        // --- Profile 配置 ---
        this.profile = configData.profile || {
            storeSelected: true,
            storeFakeIp: true,
            unifiedDelay: true,
            tcpConcurrent: false
        };

        // --- DNS 配置 ---
        this.dns = configData.dns || {
            enable: true,
            cacheAlgorithm: 'arc',
            listen: '0.0.0.0:1053',
        };

        // --- 核心列表 ---
        /** @type {Array<object>} */
        this.proxies = configData.proxies || [];

        /** @type {Array<object>} */
        this.proxyGroups = configData.proxyGroups || [];

        /** @type {object} */
        this.ruleProviders = configData.ruleProviders || {};

        /** @type {Array<string>} */
        this.rules = configData.rules || [];
    }

    toObject() {
        return {
            "port": this.port,
            "socks-port": this.socksPort,
            "allow-lan": this.allowLan,
            "bind-address": this.bindAddress,
            "mode": this.mode,
            "log-level": this.logLevel,
            "ipv6": this.ipv6,
            "profile": this.profile,
            "dns": this.dns,
            "proxies": this.proxies,
            "proxy-groups": this.proxyGroups,
            "rule-providers": this.ruleProviders,
            "rules": this.rules
        }
    }
}