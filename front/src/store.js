import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
    state:{
        userList:[

        ],
        courseList:[

        ]
    },
    getters:{
        getUserList(state){
            return state.userList;
        },
        getCourseList(state){
            return state.courseList;
        }
    },
    mutations:{
        updateUserList(state,data){
            state.userList = data;
        },
        updateCourseList(state,data){
            state.courseList = data;
        }
    }
})

export default store