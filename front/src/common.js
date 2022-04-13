import Vue from "vue";

Vue.prototype.$getUserList = function (current = 1){
    this.$fetch({
        url:'/user/findAll',
        data:{current}
    }).then(res=>this.$store.commit('updateUserList',res.data))
}

Vue.prototype.$getCourseList = function (current = 1){
    this.$fetch({
        url:'/course/findAll',
        data:{current}
    }).then(res=>this.$store.commit('updateCourseList', res.data))
}
