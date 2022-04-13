<template>
  <div id="wrap">
    <router-view/>
  </div>
</template>

<script>
export default {
}
</script>

<style>
#wrap{
  height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;

  background: #0a0909 url(../../assets/img/login_back.jpg) no-repeat center;
  background-size: cover;
}

* {
  margin: 0;
  padding: 0;
}
</style>