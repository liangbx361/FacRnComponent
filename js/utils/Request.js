'use Strict';

/**
 * 封装请求处理
 * FIXME 1. 需要完成uc错误处理
 * FIXME 2. 如何替换path参数
 * FIXME 3. ENV选择环境有问题
 */

import {ENV} from '../Env'
import SdpUc from '../modules/UcModule'

/**
 * 封装uc请求，对外提供统一的请求方式
 * @param path 请求路径
 * @param method 请求方式
 * @param params 请求参数
 * @returns {Promise} json对象
 */
 export async function request(baseUrl, path, method, params) {
    let url = baseUrl + path;
    //let url = ("http://elearning-gateway.edu.web.sdp.101.com" + path).replace("{project_id}", ENV.projectId);
    if(params != '') {
        url += "?" + params;
    }
    console.log("request url", url);
    let ucHeaders = await SdpUc.getUcHeader(url, method);
    console.log("uc headers", ucHeaders);

    let request = new Request(url, {
        method: method,
        headers: ucHeaders,
    });
    console.log("request", ucHeaders);

    return new Promise((resolve, reject) => {
        fetch(request)
            .then((response) => response.text())
            .then((responseText) => {
              resolve(JSON.parse(responseText));
            })
            .catch((error) => {
                reject(error);
            });
    });
}

