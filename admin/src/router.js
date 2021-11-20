import Vue from 'vue'
import Router from 'vue-router'
import Login from './views/login.vue'
import Admin from './views/admin.vue'
import Wellcome from './views/admin/wellcome.vue'
import Chapter from './views/admin/chapter.vue'
import Course from './views/admin/course.vue'
import Section from './views/admin/section.vue'



Vue.use(Router)

export default new Router({
    mode: 'history',
    // base: 'process.env.BASE_URL',
    routes: [{
        path: '*',
        redirect: "/login",
    }, {
        path: "/login",
        component: Login
    }, {
        path: "/",
        name: "admin",
        component: Admin,
        children: [{
            path: "wellcome",
            name: "wellcome",
            component: Wellcome
        },{
            path: "business/chapter",
            name: "business/chapter",
            component: Chapter
        },{
            path: "business/course",
            name: "business/course",
            component: Course
        },{
            path: "business/section",
            name: "business/section",
            component: Section
        }]
    }]
})