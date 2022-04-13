import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import store from './store';


Vue.config.productionTip = false
Vue.use(ElementUI)

//挂载封装好的fetch
import Fetch from'../src/assets/js/fetch'
Vue.prototype.$fetch = Fetch

//引入全局方法
import './common'


new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app')

