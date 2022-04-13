<template>
  <div class="modify">
    <Nodata v-if="Notshow"/>
    <el-row v-if="!Notshow">
      <el-button size="small" type="info" @click="showDialog()">Add Course</el-button>
      <el-table
          ref = 'CourseList'
          :data="courses"
          stripe
          height="86vh"
          style="width: 100%">
        <el-table-column
            prop="id"
            label="id"
            width="60">
        </el-table-column>
        <el-table-column
            prop="name"
            column-key="Course"
            label="Course"
            width="180">
        </el-table-column>
        <el-table-column
            prop="teacher"
            label="Instructor"
            column-key="Instructor"
            width="180">
        </el-table-column>
        <el-table-column
            prop="hours"
            label="Designed duration"
            width = "180">
        </el-table-column>
        <el-table-column
            prop="description"
            label="Description"
            width = "500">
        </el-table-column>
        <el-table-column
            prop="syllabus"
            label="Syllabus"
        width="200">
          <template slot-scope="scope">
            <el-button @click="download(scope.row)">Download</el-button>
          </template>
        </el-table-column>
        <el-table-column label="Modify">
          <template slot-scope="scope">
            <el-button size="mini" type="primary" @click="showDialog(scope.row)">Modify</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.row)">Delete</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-row>
    <CourseTemplate :dialogvisible="show" :cur-course="curCourse" @closeDialog="close"/>
  </div>
</template>

<script>
import Nodata from "@/views/Nodata";
import CourseTemplate from "@/views/home/CourseTemplate";

export default {
  name: "Modify",
  data(){
    return{
      Notshow:false,
      show:false,
      curCourse:{},
      courses:[],
    }
  },
  mounted() {
    this.getCourseById()
  },
  methods:{
    getCourseById(){
      this.$fetch({
        url:'/course/findByTeacherId/'+localStorage.getItem('uid'),
        data:{current:1}
      }).then(res=>{
        this.courses = res.data;
      })
    },
    handleDelete(row) {
      console.log(row);
      this.$fetch({
        url:'/course/delete/'+row.id,
        method:'DELETE'
      }).then((res)=>{
        if(res.code){
          this.$message.success('Delete Success')
          this.getCourseById();
        }else{
          this.$message.error('Please try again')
        }
      })
    },
    close(){
      this.getCourseById();
      this.show = false;
    },
    showDialog(obj={}) {
      this.show = true;

      this.curCourse = obj;
    },
    download(row){
      window.open('http://localhost:8081/course/download/'+row.id)
    }
  },
  components:{
    Nodata,
    CourseTemplate
  }
}
</script>


<style scoped>

</style>