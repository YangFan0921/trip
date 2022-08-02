let vm_product = new Vue({
    el:"#vm_product",
    data:{
        product_arr:[],
        view_arr:[],
        like_arr:[],
    },
    created(){
        // 获取地址中的参数
        let str = location.search
        // 判断点击搜索按钮
        if (str.lastIndexOf("wd") != -1){
            let wd = str.split("=")[1]
            axios.get("/findbywd?wd="+wd).then(function (response) {
                vm_product.product_arr = response.data
                console.log(vm_product.product_arr)
            }).catch(function (error) {
                console.log(error)
            })
        }
        // 判断点击分类
        if (str.lastIndexOf("cid") != -1){
            let cid = str.split("=")[1]
            // 获取导航栏的分类作品
            axios.get("/findbycid?id="+cid).then(function (response) {
                vm_product.product_arr = response.data
            }).catch(function (error) {
                console.log(error)
            })
        }else {
            // 获取所有作品
            axios.get("/selectProduct").then(function (response) {
                vm_product.product_arr = response.data
            }).catch(function (error) {
                console.log(error)
            })
        }

        axios.get("/viewlist").then(function (response) {
            vm_product.view_arr = response.data
        }).catch(function (error) {
            console.log(error)
        })
        axios.get("/likelist").then(function (response) {
            vm_product.like_arr = response.data
        }).catch(function (error) {
            console.log(error)
        })
    },
    updated(){ // 当vue中变量发生改变页面更新后执行
        // 让瀑布流在图片加载完之后初始化
        $(".grid").imagesLoaded().progress(function () {
            $(".grid").masonry({
                itemSelector:".grid-item", //告诉瀑布流框架 如何找到瀑布流里面的元素
                columnWidth:210 //设置瀑布流元素每一列所占宽度(元素宽度200+间距10)
            })
        })
        // 鼠标移入移出事件
        $(".grid-item").hover(function () {
            // 得到鼠标移入div里面的蓝条div  .stop()停止所有动画
            $(this).children("div").stop().fadeIn(500)
        },function () {
            $(this).children("div").stop().fadeOut(500)
        })
    },
    methods:{

    },
})