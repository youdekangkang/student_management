import Vue from "vue";
import VueRouter from "vue-router";
import Cookie from './assets/js/cookie'

Vue.use(VueRouter)    //安装路由插件

const routes=[
    {
        path:'/login',
        name:'login',
        component:()=>import('./views/user/LoginHome'),
        children:[
            {
                path:'entrance',
                component:()=>import('./views/user/Login')
            },
            {
                path:'register',
                component:()=>import('./views/user/Register')
            }
        ],
        redirect:'/login/entrance'
    },
    {
        path:'/',
        component:()=>import('./views/home/Home'),
        children: [
            {
                path:"evaluation/:who",
                component:()=>import("./views/home/Evaluation"),
            },
            {
                path:'welcome',
                component:()=>import('./views/home/Welcome')
            },
            {
                path:'course',
                component:()=>import('./views/home/Course')
            },
            {
                path:'modify',
                component:()=>import('./views/home/Modify')
            },
            {
                path:'rights',
                component:()=>import('./views/home/Rights')
            }
        ],
        redirect: '/Welcome',
        meta:{
            requireLogin:true
        }
    }
]

const router = new VueRouter({
    routes,
    linkActiveClass: "ac",
    linkExactActiveClass: "active",
    mode: "history",
})

//Global Guard of router
router.beforeEach((to, from, next) => {

    const isRequire = to.matched.some(item => item.meta.requireLogin);

    if (isRequire) {	//If the router have this meta that means it can't be reached unless being logged
        if(localStorage.getItem('isLogin')==null){
            next('/login')
        }else{
            next()
        }
    } else {
        next();
    }
});


export default router;