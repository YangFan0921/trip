let vm_banner = new Vue({
    el:"#myCarousel",
    data:{
        banners:[],
    },
    created(){
        axios.get("/selectBanner").then(function (response) {
            vm_banner.banners = response.data
            // console.log(vm_banner.banners)
        }).catch(function (error) {
            console.log(error)
        })
    },
    methods:{
        deleteById(id) {
            if ( !confirm("确认删除此轮播图？") ){
                return
            }
            axios.get("/deletebanner?id="+id).then(function (response) {
                location.reload()
            }).catch(function (error) {
                console.log(error)
            })
        },
        upload(){
            let data = new FormData($("form")[0])
            axios.post("/uploadbanner",data).then(function (response) {
                location.href="home.html"
            }).catch(function (error) {
                console.log(error)
            })
        }
    },

})