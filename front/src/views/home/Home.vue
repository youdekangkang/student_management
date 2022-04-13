<template>
  <div class="app">
    <el-container>
      <el-aside width="200px">
        <SubBar @showDialog = 'showDia'/>
      </el-aside>
      <el-container>
        <el-header class="title">
          ITMO&HDU Educational Administration System
          <img src="~@/assets/img/stu.png" alt="" style="height: 12vh;width: 12vh"></el-header>
        <el-main class="right">
          <router-view/>
        </el-main>
      </el-container>
    </el-container>

    <el-dialog title="Change Password" :visible.sync="dialogFormVisible" :before-close="handleClose">

      <el-form :model="form" :rule="rules" ref="ruleForm" label-width="auto">
        <el-form-item label="Old Password" prop="oldPass">
          <el-input type="password" v-model="form.oldPass"></el-input>
        </el-form-item>
        <el-form-item label="New Password" prop="newPass1">
          <el-input type="password" v-model="form.newPass1"></el-input>
        </el-form-item>
        <el-form-item label="Input your new password again" prop="newPass2">
          <el-input type="password" v-model="form.newPass2"></el-input>
        </el-form-item>
      </el-form>

      <div slot="footer" class="dialog-footer">
        <el-button @click="handleClose()">取 消</el-button>
        <el-button type="primary" @click="submitForm()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import SubBar from "@/components/SubBar";

export default {
  data(){
    return{
      isLogin:0,
      dialogFormVisible:false,
      form:{
        oldPass:'',
        newPass2: '',
        newPass1: ''
      },
      rules:{
        oldPass: [{
            required: true,message:'Please at least input something',trigger:'blur'
        }],
        newPass1: [{
          required: true,message:'Please at least input something',trigger:'blur'
        }],
        newPass2: [{
          required: true,message:'Please at least input something',trigger:'blur'
        }],
      }
    }
  },
  methods: {
    showDia() {
      this.dialogFormVisible = true
    },
    handleClose() {
      this.dialogFormVisible = false
      this.$refs['ruleForm'].resetFields();
    },
    submitForm() {
      this.$refs['ruleForm'].validate()
      .then(()=>{

        this.$fetch({
          url:'/user/changePassword',
          method:'PUT',
          data:{
            username : localStorage.getItem('username'),
            newPassword : this.form.newPass1,
            oldPassword : this.form.oldPass
          }
        }).then(res=>{

          if(res.code){
            this.$message.success("Password changed successfully");
            this.$getUserList();
            this.handleClose();
          }else{
            this.$message.error(res.msg)
            this.$refs['ruleForm'].resetFields();
          }

        })

      })
    }
  },
  components:{
    SubBar,
  }
}
</script>

<style>
body{
  background: url(../../assets/img/course_bg.jpg) no-repeat top;
  background-size: cover;
  background-attachment: fixed;   /* 图片固定不会跟着滚动条走动 */
}
.logo img{
  height: 100%;
  width: 100%;
}

.function p{
  color: #409EFF;
  text-align: center;
  padding: 5px 0;
  margin-left: 0px;
  font-size: 24px;
  text-decoration:none;
}
.function p:hover{
  color: #cccccc;
  cursor: pointer;
}

.main{
  border: 1px solid #cccccc;
  height: 800px;
}
.router-link-active{
  text-decoration: none;
}
a{
  text-decoration: none;
}

.right{
  width: 100%;
  padding-left: 12vh;
}
.title{
  align-items: center;
  font-size: 30px;
  padding:5vh 10vh 7vh 50vh;
  display: flex;
  text-align: center;
}
</style>