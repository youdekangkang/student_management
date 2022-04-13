<template>
  <div class="course">
    <Searchbar @pageNum="getNum"/>
    <el-row>
      <el-table
          ref = 'CourseList'
          :data="pageData"
          stripe
          style="width: 100%">
        <el-table-column
            prop="id"
            label="Index"
            width="60">
        </el-table-column>
        <el-table-column
            prop="name"
            column-key="Course"
            label="Course"
            width="160">
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
            width = "800">
        </el-table-column>
        <el-table-column
            prop="syllabus"
            label="Syllabus">
          <template slot-scope="scope">
            <el-button @click="download(scope.row)">Download</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-row>
    <el-row>
      <el-pagination
          background
          @current-change="pageChange"
          layout="prev, pager, next"
          :total="totalItems">
      </el-pagination>
    </el-row>
  </div>
</template>

<script>
import Searchbar from "@/components/searchBar";
import Nodata from "@/views/Nodata";

export default {
  name: "Course",
  data() {
    return {
      currentPage: 1,
      pageSize: 10,
      totalItems:100,
      inputValue: '',
    }
  },

  computed:{
    pageData(){
      return this.$store.getters.getCourseList;
    }
  },
  methods:{
    pageChange(val){
      this.$getCourseList(val);
    },
    getNum(num,size){
      this.pageSize = num
      this.totalItems = size
    },
    download(row){
      window.open('http://localhost:8081/course/download/'+row.id)
    }
  },

  components:{
    Nodata,
    Searchbar
  }

}
</script>

<style scoped>
</style>