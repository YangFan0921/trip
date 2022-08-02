//自定义模板
Vue.component('myview',{
    props:["names","myName","isShow"],
    template:
    `
        <div id="vm">
            <ul>
                <li v-for="name in names" v-text="name" @click="myName(name)"></li>
            </ul>
            <h1 v-if="isShow">这是h1</h1>
        </div>
    `
})
let vm = new Vue({
    el:"#vm",
    data:{
        names:["张三","李四","王五"],
        isShow:true,

    },
    methods:{
        myName(name){
            // alert(name)
            vm.isShow = !vm.isShow
        }
    },
})