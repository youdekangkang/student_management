<template>
  <div class="search">
    <input type="text" v-model="keywords" @keyup.enter="search" placeholder="search name of the course here...">
    <button @click="search">
      <span class="iconfont">&#xe600;</span>
    </button>
  </div>
</template>

<script>
export default {
  data(){
    return {
      keywords:''
    }
  },
  mounted() {
    this.search()
  },
  methods:{
    search(){
      console.log(this.keywords)

      if(this.keywords == ""){
        this.$getCourseList()
        this.$fetch({
          url:'/course/findAll/',
          data:{current:1}
        })
        .then(res=>{
          this.$emit('pageNum',1,parseInt(res.msg)*10-10+res.data.length || 0)
        });

      }else{
        this.$fetch({
          url:'/course/findByName/'+this.keywords,
          data:{current:1}
        })
        .then(res=>{
          this.$store.commit("updateCourseList", res.data);  //update the course list
          this.keywords='';   //clear the input box
          this.$emit('pageNum',1,parseInt(res.msg)*10-10+res.data.length || 0)
        });
      }

    }
  }
};
</script>

<style scoped>
.search{
  width: 45vh;
  height: 30px;
  box-sizing: border-box;
  display: flex;
  border: 1px solid #fff;
  border-radius: 50px;
}
.search input{
  border: none;
  width: 43vh;
  font-size: 16px;
  padding-left: 15px;
  border-radius: 15px;
}
.search button{
  width: 30px;
  color: cadetblue;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
}
</style>