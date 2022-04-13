export default {
    //设置cookie
    set: function (name, value, date) {
        //date  过期时间节点（秒数，多少秒后过期）
        document.cookie = name + '=' + value + '; max-age=' + date;
    },
    //移除cookie
    remove: function (name) {
        this.set(name, '', 0);
    },
    //获取cookie
    get: function (name) {
        var cookies = document.cookie.split('; ');

        for (var i = 0; i < cookies.length; i++) {
            var item = cookies[i].split('=');

            if (item[0] == name) {
                return item[1];
            }
        }
    }
}