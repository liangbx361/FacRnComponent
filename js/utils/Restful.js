'use Strict';



export default function path(url, name, value) {
    return url.replace(name, value);
}

export default function query(url, name, value) {
    if(url.indexOf('?')) {
        url += '?';
    }
    return url.replace(url, name, value);
}

/**
 * [{
 *  type: 'path',
 *  name: 'xxx',
 *  value: 'xxx'
 * }]
 */
export default function addParams(url, params) {

}