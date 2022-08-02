let vm_header = new Vue({
    el:"#vm_header",
    data:{
        categories:[],
        isLogin:false,
        wd:"",
    },
    created(){
        axios.get("/selectCategory").then(function (response) {
            vm_header.categories = response.data
            // console.log(response.data)
        }).catch(function (error) {
            console.log(error)
        })
        // 判断是否登录
        axios.get("/checklogin").then(function (response) {
            vm_header.isLogin = response.data
        }).catch(function (error) {
            console.log(error)
        })
    },
    methods:{
        logout(){
            if (confirm("您确认退出登录？")){
                axios.get("/logout").then(function (response) {
                    // console.log(response.data)
                    // vm_header.isLogin=false
                    location.reload()
                }).catch(function (error) {
                    console.log(error)
                })
            }

        },
        findById(id){
            axios.get("/findbycid?id="+id).then(function (response) {
                vm_product.product_arr = response.data
            }).catch(function (error) {
                console.log(error)
            })
        },
        search(wd){
            location.href="home.html?wd="+wd
        }
    },
})