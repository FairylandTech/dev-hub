/****************************************************
 * @software: PyCharm
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-11 11:59:35 UTC+08:00
 ***************************************************/

import fs from "fs";
import yaml from "js-yaml";


export default function loadYamlFile(filePath) {
    try {
        return yaml.load(fs.readFileSync(filePath), {"json": true});
    } catch (exception) {
        console.error(`Error loading YAML file: ${exception}`);
        return null;
    }
}