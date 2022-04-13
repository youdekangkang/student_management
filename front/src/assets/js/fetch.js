export default function request(options){
    //容错处理
    options.data = options.data || {};
    options.headers = options.headers || {};

    //设置默认的请求头
    const defaultHeaders = {
        'Content-Type': 'application/json'
    };

    //真正发头的请求头
    const requestHeaders = {
        method: options.method || 'GET',
        headers: Object.assign(options.headers, defaultHeaders),   //合并对象
    }

    if (requestHeaders.method == 'GET') {
        //get请求要求参数必需要拼到URL上：'/auth/user?username="kaivon"&password=123'
        const esc = encodeURIComponent;   //把字符串进行编码（十六进制）
        const queryParams = Object.keys(options.data).map(item => `${esc(item)}=${options.data[item]}`).join('&');
        /*
            Object.keys(options.data)       ['username','password']
            Object.keys(options.data).map   ['username="kaivon"','password=123']
         */

        if (queryParams) {
            options.url += `?${queryParams}`
        }
    }else{
        //其它请求，数据要放在body属性里
        requestHeaders.body=JSON.stringify(options.data);
    }

    return fetch('http://localhost:8081'+options.url, requestHeaders).then(res=>res.json());

}
