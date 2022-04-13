<template>
  <div class="register">
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <div class="title">
        <h1>Register</h1>
      </div>

      <el-form-item label="Username" prop="username">
        <el-input v-model.number="ruleForm.username" style="width: 70vh"></el-input>
      </el-form-item>
      <el-form-item label="Password" prop="password">
        <el-input type="password" v-model="ruleForm.password" autocomplete="off" style="width: 70vh"></el-input>
      </el-form-item>
      <el-form-item label="Comfirm" prop="checkPass">
        <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off" style="width: 70vh"></el-input>
      </el-form-item>
      <el-form-item label="Role" prop="type">
        <el-radio-group v-model="ruleForm.type" class="role">
          <el-radio label="teacher"></el-radio>
          <el-radio label="student"></el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">Submit</el-button>
        <el-button @click="resetForm('ruleForm')">Reset</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "Register",
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
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass');
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('Please input password again'));
      } else if (value !== this.ruleForm.password) {
        callback(new Error('the password are not in the same!'));
      } else {
        callback();
      }
    };
    return{
      ruleForm:{
        username:'',
        password:'',
        checkPass:'',
        type:''
      },
      rules:{
        username:[
          {required: true,validator:checkName,message:'Please at least input something',trigger:'blur'},
        ],
        password:[
          {required: true,validator:validatePass,message:'Please input your password',trigger:'blur'}
        ],
        checkPass:[
          {required: true,validator:validatePass2,message:'Please fill in right password',trigger:'blur'}
        ],
        type: [
          {required: true, message: 'Please at least choose one', trigger: 'change' }
        ],
      }
    };
  },
  methods:{
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {

          this.$fetch({
            url:'/user/register',
            method:'POST',
            data:{
              'username' : this.ruleForm.username,
              'password' : this.ruleForm.password,
              'role' : this.ruleForm.type
            }
          }).then(res=>{
            if(res.code){
              this.$message.success(res.msg);
              this.$router.replace('/login');
            }else{
              this.$message.error(res.msg);
            }
            this.$refs[formName].resetFields();
          }).catch(()=>{})

        }else{
          this.$message.error('error SUBMIT!!!')
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$message('The login page is reset')
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped>
.register{
  height: 100vh;
  width: 100vh;
  text-align: center;
  padding: 30vh 20vh 0vh 20vh;
}
.register h1{
 padding-bottom: 5vh;
  font-size: 50px;
  color: #ffffff;
}
.register  /deep/ .el-form-item__label{
  color: #fff;
  font-size: 25px;
  width: 10px;
}
.register  /deep/ .el-radio__label{
  color: #fff;
  font-size: 25px;
  width: 10px;
}
</style>