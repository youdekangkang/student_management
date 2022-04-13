<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
import Vue from "vue";
import ElementUI from "element-ui";

Vue.use(ElementUI);
export default {

}
</script>

<style>
#app {
  font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
@font-face {
  font-family: 'iconfont';  /* Project id 2947619 */
  src: url('//at.alicdn.com/t/font_2947619_m16udpz4z1r.woff2?t=1637214869690') format('woff2'),
  url('//at.alicdn.com/t/font_2947619_m16udpz4z1r.woff?t=1637214869690') format('woff'),
  url('//at.alicdn.com/t/font_2947619_m16udpz4z1r.ttf?t=1637214869690') format('truetype');
}
.iconfont {
  font-family: "iconfont" !important;
  font-size: 16px;
  font-style: normal;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
</style>
