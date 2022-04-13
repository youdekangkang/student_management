<template>
	<div id="subBar">
    <router-link to="/">
      <img src="~@/assets/img/itmo.png" class="logo" alt="">
    </router-link>
		<div class="message">
			<p>Welcome</p>
      <p><strong>{{username}}</strong></p>
      <p>Your role is : <strong>{{role}}</strong></p>
      <p v-if="role ==='Admin'">You have all the rights</p>
      <p v-if="role === 'Teacher'">You can modify the course</p>
      <p>Have a nice day!</p>
      <span><el-button type="primary" plain @click="changePass"><strong>change Password</strong></el-button></span>
		</div>
		<ul class="action">
      <router-link to="/course" tag="li">
          <span class="iconfont">&#xe680;</span>Course
      </router-link>
      <router-link to="/modify" tag="li" v-if="role ==='Admin' || role === 'teacher'">
          <span class="iconfont">&#xe644;</span>Modify
      </router-link>
      <router-link to="/Rights" tag="li" v-if="role ==='Admin' ">
          <span class="iconfont">&#xe687;</span>Rights
      </router-link>
      <router-link to="/evaluation/teacher" tag="li" v-if="role ==='student' ">
        <span class="iconfont">&#xe687;</span>evaluate
      </router-link>
			<li @click='logout'>
        <span class="iconfont">&#xe623;</span>Logout
      </li>
		</ul>
	</div>
</template>

<script>

export default {
    data(){
        return {
          username: localStorage.getItem('username'),
          role:localStorage.getItem('role')
        }
    },
    methods:{
      logout(){
          localStorage.removeItem('isLogin');
          localStorage.removeItem('role');
          localStorage.removeItem('username');
          this.$router.replace('/login');
      },
      changePass(){
        this.$emit('showDialog');
      }
    }
};
</script>

<style scoped>
#subBar{
    width: 300px;
    height: 100vh;
    position: fixed;
}
.logo{
    width: 80%;
    display: block;
    margin: 50px auto;
}
.message{
    width: 200px;
    box-sizing: border-box;
    padding: 30px 0;
    margin: 0 auto 30px;

    color: #fff;
    line-height: 40px;
    text-align: center;
    position: relative;
}
.message::before,.message::after,.action::before,.action::after{
    content: '';
    position: absolute;
    width: 100%;
    height: 1px;
    left: 0;
    background: linear-gradient(90deg, transparent, rgba(255,255,255,.6), transparent);
}
.message::before{
    top: 0;
}
.message::after{
    bottom: 0;
}
.action{
    height: 300px;
    display: flex;
    flex-wrap: wrap;
    position: relative;
}
.action li{
    width: 50%;
    height: 50%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;

    color: #fff;
    font-size: 20px;
    cursor: pointer;
    position: relative;
}
.action span{
    font-size: 40px;
    margin-bottom: 10px;
}
.action li.ac,.action li:hover{
    color: #f9d163;
}
.action i{
    width: 20px;
    height: 20px;
    background: #ff8400;
    border-radius: 50%;
    font-size: 14px;
    color: #fff;
    text-align: center;
    line-height: 20px;
    font-style: normal;

    position: absolute;
    left: 70px;
    top: 26px;
}
.action::before{
    top: 50%;
}
.action::after{
    top: 50%;
    transform: rotate(90deg);
}
</style>