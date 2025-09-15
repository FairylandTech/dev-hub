/****************************************************
 * @software: PyCharm
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-14 12:08:17 UTC+08:00
 ***************************************************/

import mockRequest from "./request.js";


async function run() {
    try {
        const response = await mockRequest();
        console.log("Response:", response);
        console.log(JSON.stringify(response, null, 2));
    } catch (error) {
        console.error("Error:", error);
    }
}

run();


