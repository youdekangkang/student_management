<template>
  <div class="login">
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <div class="title">
        <img src="../../assets/img/itmo.png" alt="">
      </div>
      <div class="info">
        <el-form-item label="Username" prop="username">
          <el-input v-model.number="ruleForm.username" style="width: 75vh"></el-input>
        </el-form-item>
        <el-form-item label="Password" prop="password">
          <el-input type="password" v-model="ruleForm.password" autocomplete="off" style="width: 75vh"></el-input>
        </el-form-item>
      </div>

      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')"><strong>Login</strong></el-button>
        <el-button @click="resetForm('ruleForm')"><strong>Reset</strong></el-button>
        <router-link to="/login/register" class="register">
          <el-button type="info"><strong>Register</strong></el-button>
        </router-link>
      </el-form-item>

    </el-form>
  </div>
</template>

<script>
import Cookies from '../../assets/js/cookie';
import global from '../../Global';
export default {
  name: "login",
  data(){
    var checkName = (rule,value,callback) =>{
      if(!value){
        callback(new Error('Please input your username'));
      }else{
        callback();
      }
    };
    var validatePass = (rule, value, callback) => {
        if (value === '') {
        callback(new Error('Please input your password'));
      } else {
        callback();
      }
    };
    return{
      ruleForm:{
        username:'',
        password:'',
      },
      userList:[],
      register:1,
      rules:{
        username:[
          {required: true,validator:checkName,trigger:'blur'},
        ],
        password:[
          {required: true,validator:validatePass,trigger:'blur'}
        ]
      }
    };
  },
  methods:{
    getRole(username){
      let temp = this.userList.find((x)=>{return x.username == username});
      console.log(temp.role);
      return temp.role;
    },

    submitForm(formName) {
      console.log(this.ruleForm.username);
      let name = this.ruleForm.username;
      let pass = this.ruleForm.password;

      this.$refs[formName].validate((valid)=>{
        if(valid){

          this.$fetch({
            url:'/user/login',
            method:'POST',
            data:{
              'username': name,
              'password': pass
            }
          }).then(res=>{
            var that = this
            if(res.code){
              //Login Success
              localStorage.setItem('username',this.ruleForm.username);
              localStorage.setItem('isLogin','true');
              localStorage.setItem('uid',res.data);

              this.$fetch({
                url:'/user/getRole/'+name,
              }).then(res=>{localStorage.setItem('role',res.data)})

              this.$message({
                message:res.msg+",jumping soon...",
                type:'success',
                duration:1000,
                onClose(){
                  that.$router.replace('/')
                }
              })
            }else{
              this.$message.error(res.msg);
              this.$refs[formName].resetFields();
            }

          });

        }else{
          this.$message.error('Please check your input again')
          this.$refs[formName].resetFields();
        }
      })
    },
    resetForm(formName) {
      this.$message('The login page is reset')
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped>
.login{
  height: 100vh;
  width: 100vh;
  padding: 20vh 40vh 0vh 35vh;
  text-align: center;
}
.info{
  padding-top: 5vh;
  padding-bottom: 5vh;
}
.title{
  text-align: center;
}
.title img{
  width: 60vh;
  height: 12vh;
}
.register{
  padding: 0px 0px 6px 10px;
}

.login /deep/ .el-form-item__label{
  color: #fff;
  font-size: 25px;
  width: 10px;
}


</style>