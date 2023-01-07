const proxy = require('http-proxy-middleware')
module.exports = function(app) {
    app.use(
        proxy.createProxyMiddleware('/js', { //`api`是需要转发的请求
            target: 'ttp://fundgz.1234567.com.cn/', // 这里是接口服务器地址
            changeOrigin: true

        })
    )
}