<template>
  <div class="rights">
    <el-table
        stripe
        :data="userList"
        style="width: 100%">
      <el-table-column
          prop="username"
          label="Username"
          width="350">
      </el-table-column>
      <el-table-column
          prop="password"
          label="Password"
          width="350">
      </el-table-column>
      <el-table-column
          prop="role"
          label="Role"
      width="250">
      </el-table-column>
      <el-table-column
          prop="modify"
          label="Modify">
        <template slot-scope="scope">
          <el-button
              size="mini"
              type="info"
              @click="changeRole(scope.row)"
              v-show="scope.row['role']!='Admin'">Change</el-button>
          <el-button
              size="mini"
              type="danger"
              @click="Delete(scope.row)"
              v-show="scope.row['role']!='Admin'">Delete</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "Rights",
  mounted() {
    this.$getUserList();
  },
  computed:{
    userList(){
      return this.$store.getters.getUserList;
    }
  },
  methods:{
    changeRole(row){
      console.log(row.username)
      this.$fetch({
        url:'/user/changeIdentity?username='+row.username,
        method:'put',
      }).then(()=>{this.$getUserList()})
    },
    Delete(row){
      this.$confirm('Sure to delete'+row.username+'?')
          .then(()=>{
            this.$fetch({
              url:'/user/delete/'+row.username,
              method:'DELETE',
            }).then(()=>this.$getUserList())   //删除成功后要更新数据
          }).catch(()=>{})
    }
  }
}
</script>

<style scoped>

</style>