/****************************************************
 * @software: PyCharm
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-14 11:51:30 UTC+08:00
 ***************************************************/

export async function fetchTest() {
    return new Promise((resolve, reject) => {
        $.ajax({
            url: 'http://127.0.0.1:51005/example/test',
            method: 'GET',
            dataType: 'text',
            timeout: 10000,
            success: function (data, textStatus, jqXHR) {
                resolve({
                    data,
                    textStatus,
                    status: jqXHR.status,
                    headers: jqXHR.getAllResponseHeaders()
                });
            },
            error: function (jqXHR, textStatus, errorThrown) {
                const err = new Error(errorThrown || textStatus || 'AJAX error');
                err.status = jqXHR && jqXHR.status;
                err.responseText = jqXHR && jqXHR.responseText;
                reject(err);
            }
        });
    });
}

export default fetchTest;