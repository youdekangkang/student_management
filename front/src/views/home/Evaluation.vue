<template>
  <div class="evaluation">


    <div v-if="ifShow">

      <el-row v-for="teacher in teachers" :key="teacher.id" style="margin-top: 10px;" :gutter="10">

        <el-col :span="2">
          <div class="grid-content bg-purple-dark">{{teacher.teacher}}</div>
        </el-col>

          <el-col :span="4">
            <div class="grid-content bg-purple">
            <el-rate v-model="teacher.score_.toFixed(2)" show-score score-template="Score:{value}" disabled :colors="colors" allow-half></el-rate>
            </div>
          </el-col>

        <el-col :span="4">
          <div class="grid-content bg-purple-light">
          <el-rate v-model="teacher.score"  score-template="{value}分" show-text :texts="texts" allow-half></el-rate>
           </div>
        </el-col>

          <el-col :span="4">
            <el-button type="primary" @click="submitReview(teacher)" >submit review<i class="el-icon-upload el-icon--right"></i></el-button>
          </el-col>
      </el-row>

    </div>
    <div v-else><nodata/></div>

  </div>
</template>

<script>
import Nodata from "@/views/Nodata";
import axios from "axios";

export default {
  name: "Evaluation",
  components: {Nodata},
  mounted(){
    this.begTeachers()
  },
  methods:{
    submitReview(t){
      const url=this.backendLocation+"/score/update"
      let {id,score,teacherId}=t
      let obj={id,score,teacherId}
      axios.put(url,obj).then(
          (response)=>{
            this.begTeachers()
            alert("succeed to review teacher@"+t.teacher)
          },
          (error)=>{alert("submit wrong!")}
      )
    },
    begTeachers(){
      const url=this.backendLocation+"/score/findAll"
      console.log(url)
      axios.get(url).then(
          (response)=>{
            this.teachers=response.data.data
            this.teachers.forEach((t)=>{this.$set(t,"score_",t.score)})
            // console.log(this.teachers)
            this.ifShow=true

          },
          (error)=>{
            this.ifShow=false
            //if there is no data
          }
      )
    }
  },
  data(){
    return{
      backendLocation:"http://localhost:8081",
      colors: ['#99A9BF', '#F7BA2A', '#FF9900'],
      texts:["disgusting","bad","medium","fine","wonderful"],
      teachers:[],
      ifShow:false,
    }
  },

}
</script>

<style scoped>
.el-row {
  margin-bottom: 20px;
&:last-child {
   margin-bottom: 0;
 }
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
</style>