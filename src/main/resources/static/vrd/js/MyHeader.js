Vue.component('MyHeader', {
    props: ["categories","isLogin","wd","search","logout"],
    template:
        `
            <div id="vm_header">
                <header class="container">
                    <!--导航条开始-->
                    <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="home.html">
                                <img alt="Brand" src="images/logo.png">
                            </a>
                        </div>
                        <!--首页和分类-->
                        <ul class="nav navbar-nav">
                            <li><a href="home.html">首页</a></li>
    <!--                        <li v-for="category in categories"><a href="#" v-text="category.name" @click="findById(category.id)"></a></li>-->
                            <li v-for="category in categories"><a :href="'home.html?cid='+category.id" v-text="category.name" ></a></li>
                            <li>
                                <!--文本框中敲回车会自动触发form表单的提交
                                form表单的submit事件是提交事件 此场景需要阻止form表单事件的提交
                                .prevent是阻止事件触发-->
                                <form action="" @submit.prevent>
                                    <input type="text" v-model="wd" @keyup.enter="search(wd)" placeholder="Search">
<!--                                    <input type="text" v-model="wd"  placeholder="Search">-->
                                    <button>
                                        <a class="fa fa-search" :href="'home.html?wd='+wd"></a>
                                    </button>
                                </form>
                            </li>
                        </ul>
                        <!--右侧内容-->
                        <ul class="nav navbar-nav navbar-right">
                            <li v-if="!isLogin"><a id="login_a" class="fa fa-user-circle" href="login.html">管理员入口</a></li>
                            <li v-if="isLogin"><a class="fa fa-user-circle" href="send.html" >发布作品</a></li>
                            <li v-if="isLogin"><a class="fa fa-user-circle" href="banner.html">轮播图</a></li>
                            <li v-if="isLogin"><a class="fa fa-user-circle" href="#" @click="logout()">登出</a></li>
                        </ul>
                    </div>
                    </nav>
                    <!--导航条结束-->
                </header>
            </div>
        `
})