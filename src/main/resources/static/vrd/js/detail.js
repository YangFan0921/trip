let vm_detail = new Vue({
    el:"#vm_detail",
    data:{
        product:{},
        isLogin:false,
    },
    created(){

        // 判断是否登录
        axios.get("/checklogin").then(function (response) {
            vm_detail.isLogin = response.data
        }).catch(function (error) {
            console.log(error)
        })

        let id = location.search.split("=")[1]
        axios.get("/selectbyid?id="+id).then(function (response) {
            vm_detail.product = response.data
            //格式化时间格式
            vm_detail.product.created = moment(vm_detail.product.created).format("YYYY年MM月DD日 HH:mm:ss")
        }).catch(function (error) {
            console.log(error)
        })

    },
    updated(){},
    methods:{
        likeById(id){
            axios.get("/likebyid?id="+id).then(function (response) {
                if (response.data == 1){
                    vm_detail.product.likeCount++;
                }else {
                    alert("您今天已经点过赞了！")
                }

            }).catch(function (error) {
                console.log(error)
            })
        },
        deleteById(id){
            if (confirm("确认删除此作品？")){
                axios.get("/delete?id="+id).then(function (response) {
                    location.href = "home.html"
                }).catch(function (error) {
                    console.log(error)
                })
            }

        }
    },
})