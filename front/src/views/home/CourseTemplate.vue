<template>
  <div>
    <el-dialog title="Course information" :visible.sync="dialogvisible" top="15vh" :before-close="handleClose">
      <el-form :model="curCourse" :rules="rules" ref="form" label-width="auto">
        <el-form-item label="Course name" prop="name">
          <el-input v-model="curCourse.name"></el-input>
        </el-form-item>
        <el-form-item label="Teacher(s)" prop="teacher">
          <el-input v-model.number="curCourse.teacher" ></el-input>
        </el-form-item>
        <el-form-item label="Designed hours" prop="hours">
          <el-input v-model.number="curCourse.hours" ></el-input>
        </el-form-item>
        <el-form-item label="Description" prop="description">
          <el-input type="textarea" rows="5" v-model="curCourse.description"></el-input>
        </el-form-item>
      </el-form>
      <p>Syllabus upload</p>
      <el-upload
          class="upload-demo"
          name="syllabus"
          action="http://localhost:8081/course/upload"
          :on-preview="handlePreview"
          :on-remove="handleRemove"
          :on-error="handleFail"
          :before-remove="beforeRemove"
          :on-success="successHandle"
          multiple
          :limit="1"
          :on-exceed="handleExceed"
          :file-list="fileList">
        <el-button size="small" type="primary">Click to upload</el-button>
        <div slot="tip" class="el-upload__tip">Only one file submitted</div>
      </el-upload>

      <div slot="footer" class="dialog-footer">
        <el-button @click="handleClose">Cancel</el-button>
        <el-button type="primary" @click="submitForm">Sure</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data(){
    return{
      fileList:[],
      syllabus:'',
      rules:{
        name:[{
          required:true,
          message:'Please input the course name',
          trigger:'blur'
        }],
        teacher:[{
          required:true,
          message:'Please at least input one teacher',
          trigger:'blur'
        }],
        hours:[{
          required:true,
          message:'The duration must be numbers',
          type:'number',
          trigger:'blur'
        }],
        description:[{
          required:true,
          message:'Please input the description',
          trigger:'blur'
        }],
      }
    }
  },
  props:{
    dialogvisible:Boolean,
    curCourse:Object
  },
  methods:{
    handleClose(){  //浮层关闭前的回调
      this.$refs['form'].resetFields();
      this.$emit('closeDialog');
    },
    submitForm(){
      //先验证表单
      let id = this.curCourse.id
      this.$refs['form'].validate()
          .then(()=>{
            console.log(this.curCourse)
            this.$fetch({
              url:id == null? '/course/add' : '/course/update',
              method:id == null ? 'POST' : 'PUT',
              data:{
                id:id,
                name:this.curCourse.name,
                teacher:localStorage.getItem("uid"),
                hours:this.curCourse.hours,
                description : this.curCourse.description,
                syllabus : this.syllabus
              }
            }).then(()=>{
              this.$message.success('Modify Success!')
              this.handleClose()
            }).catch(res=>{
              console.log(res)
            })
          }).catch(()=>{})
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    handleExceed(files, fileList) {
      this.$message.warning(`Only one file allowed`);
    },
    beforeRemove(file, fileList) {
      return this.$confirm(`Sure to remove ${ file.name }？`);
    },
    successHandle(res){
      console.log(res)
      if(res.code == 1){
        this.$message.success(res.msg)
        this.syllabus = res.code
      }else{
        this.$message.error(res.msg)
      }
    },
    handleFail(res){
      this.$message.error('Upload Failed,please check the file or the network')
    }
  }
}
</script>

<style scoped>
</style>