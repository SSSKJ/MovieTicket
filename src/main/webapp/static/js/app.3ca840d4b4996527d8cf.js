webpackJsonp([0,2],[,function(e,t,r){e.exports=r.p+"static/img/poster1.393f903.jpg"},,,,function(e,t,r){r(58);var s=r(0)(r(22),r(97),"data-v-603f103a",null);e.exports=s.exports},function(e,t,r){r(61);var s=r(0)(r(23),r(100),"data-v-e036bb20",null);e.exports=s.exports},function(e,t,r){function s(e){return r(n(e))}function n(e){var t=i[e];if(!(t+1))throw new Error("Cannot find module '"+e+"'.");return t}var i={"./poster1.jpg":1,"./poster2.jpg":68,"./poster3.jpg":69,"./poster4.jpg":70,"./poster5.jpg":71,"./poster6.jpg":72};s.keys=function(){return Object.keys(i)},s.resolve=n,e.exports=s,s.id=7},,,,,,function(e,t,r){r(63);var s=r(0)(r(21),r(102),"data-v-f5300a24",null);e.exports=s.exports},function(e,t,r){r(59);var s=r(0)(r(25),r(98),"data-v-9222ec94",null);e.exports=s.exports},,,function(e,t,r){"use strict";var s=r(8),n=r(105),i=r(88),a=r.n(i),o=r(80),c=r.n(o),u=r(81),l=r.n(u),v=r(87),p=r.n(v),d=r(85),m=r.n(d),f=r(86),_=r.n(f),h=r(6),g=(r.n(h),r(13)),y=(r.n(g),r(5)),b=(r.n(y),r(84)),x=r.n(b),C=r(83),k=r.n(C),w=r(82),A=r.n(w),j=r(79),$=r.n(j),M=r(78),P=r.n(M);s.a.use(n.a),t.a=new n.a({routes:[{path:"/index",component:m.a},{path:"/welcome",name:"welcome",component:a.a,children:[{path:"signin",component:c.a},{path:"signup",component:l.a}]},{path:"/",redirect:"/index"},{path:"/movies",name:"movies",component:_.a},{path:"/movie/detail/:title",component:x.a},{path:"/cinemas",component:k.a},{path:"/search/:str",component:p.a},{path:"/account",component:A.a,children:[{path:"profile",component:$.a},{path:"orders",component:P.a}]}]})},function(e,t,r){r(53);var s=r(0)(r(20),r(92),null,null);e.exports=s.exports},,function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={name:"app",data:function(){return{login:document.cookie.length,search_str:""}},computed:{},methods:{logout:function(){var e=this;this.$http.get("/user/logout").then(function(t){console.log(t.data),0==document.cookie.length&&(window.location.reload(),e.$router.push("/welcome"))}).catch(function(e){console.log("服务器异常！"),console.log(e)})},mainpage:function(){this.$router.push("/index")},search:function(e){console.log(e),this.$router.push("/search/"+e)}}}},function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={name:"hot",created:function(){this.getMovies()},data:function(){return{movies:[{poster:r(1),title:"海边的曼彻斯特"}]}},methods:{getMovies:function(){var e=this;this.$http.get("/movie/hot").then(function(t){console.log("获取成功"),e.movies=t.data,e.movies.forEach(function(e){var t=e.poster;e.poster=r(7)("./"+t+".jpg")})}).catch(function(e){console.log("服务器异常！"),console.log(e)})},showDetail:function(e,t){this.$router.push("/movie/detail/"+e)}}}},function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={name:"hot",created:function(){this.getMovies()},data:function(){return{movies:[{poster:r(1),title:"海边的曼彻斯特"}]}},methods:{getMovies:function(){var e=this;this.$http.get("/movie/hot").then(function(t){console.log("获取成功"),e.movies=t.data,e.movies.forEach(function(e){var t=e.poster;e.poster=r(7)("./"+t+".jpg")})}).catch(function(e){console.log("服务器异常！"),console.log(e)})},buyTicket:function(e){this.$router.push("/movie/detail/"+e)}}}},function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={name:"hot",created:function(){this.getMovies()},data:function(){return{movies:[{poster:r(1),title:"海边的曼彻斯特"}]}},methods:{getMovies:function(){var e=this;this.$http.get("/movie/hot").then(function(t){console.log("获取成功"),e.movies=t.data,e.movies.forEach(function(e){var t=e.poster;e.poster=r(7)("./"+t+".jpg")})}).catch(function(e){console.log("服务器异常！"),console.log(e)})},buyTicket:function(e){this.$router.push("/movie/detail/"+e)}}}},function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={name:"orders",data:function(){return{}}}},function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={data:function(){return{topmovies:[{poster:"",name:""}],nowIndex:1,timer:""}},created:function(){this.getmovies()},mounted:function(){this.initSlider(),this.timer=setInterval(this.autoSlide,3e3)},methods:{clickSwitchSlider:function(e){clearInterval(this.timer),this.switchSlider(e),this.nowIndex=e,this.timer=setInterval(this.autoSlide,3e3)},initSlider:function(){var e=document.querySelector("#ctrl_0"),t=document.querySelector("#main_0");e.className+=" ctrl-item_active",t.className+=" main-item_active"},switchSlider:function(e){this.checkChange()&&clearInterval(this.timer),this.clearActive();var t=document.querySelector("#ctrl_"+e),r=document.querySelector("#main_"+e);t.className+=" ctrl-item_active",r.className+=" main-item_active"},clearActive:function(){for(var e=document.querySelectorAll(".ctrl-item"),t=document.querySelectorAll(".main-item"),r=0;r<e.length;r++)e[r].className="ctrl-item",t[r].className="main-item"},getmovies:function(){var e=this;this.$http.get("movie/topmovie").then(function(t){console.log("silder资源获取成功"),e.topmovies=t.data,e.topmovies.forEach(function(e){var t=e.poster;e.poster=r(108)("./"+t+".jpg")})}).catch(function(e){console.log("silder资源获取失败")})},autoSlide:function(){this.switchSlider(this.nowIndex),5===++this.nowIndex&&(this.nowIndex=0)},checkChange:function(){return document.URL.indexOf("index")==-1}}}},function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=r(37),n=r.n(s);t.default={name:"profile",data:function(){var e;return{user:(e={email:"",password:"",phone:""},n()(e,"email",""),n()(e,"pereference",[]),e)}},created:function(){this.getUser()},methods:{getUser:function(){var e=this;this.$http.get("/user/info").then(function(t){console.log("获取用户资料成功"),console.log(t.data),e.user=t.data}).catch(function(e){console.log("服务器异常！"),console.log(e)})}}}},function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=r(9),n=r.n(s);t.default={name:"signin",data:function(){return{user:{email:"",password:""},errMsg:"      "}},methods:{submit:function(){var e=this;if(this.check()){var t=n()(this.user);this.$http.post("/Login",t).then(function(t){console.log("response is"+t.data),"0"==t.data?e.errMsg="用户不存在":"1"==t.data?e.errMsg="密码错误":"2"==t.data&&document.cookie.length>0&&(window.location.reload(),e.$router.push("/index"))}).catch(function(e){console.log("服务器异常！"),console.log(e)})}},check:function(){return""===document.querySelector(".email").value?(this.errMsg="邮箱不能为空",!1):""===document.querySelector(".password").value?(this.errMsg="密码不能为空",!1):(this.errMsg="  ",!0)}}}},function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=r(9),n=r.n(s);t.default={name:"signup",data:function(){return{user:{email:"",password:"",phone:"",nickname:"",pereference:[]},vaild:!1,errMsg:""}},methods:{submit:function(){var e=this;if(this.valid&&this.check()){var t=n()(this.user);this.$http.post("/Register",t).then(function(t){"true"==t.data?(console.log("注册成功"),e.$router.push("/index")):"false"==t.data&&(e.errMsg="注册失败")}).catch(function(e){console.log("服务器异常！"),console.log(e)})}},check:function(){return""===document.querySelector(".email").value?(this.errMsg="邮箱不能为空",!1):""===document.querySelector(".password").value?(this.errMsg="密码不能为空",!1):document.querySelector(".password").value!=document.querySelector(".repeated-password").value?(this.errMsg="两次密码不一致",!1):(this.errMsg="",!0)},checkEmail:function(){var e=this,t={email:document.querySelector(".email").value};this.$http.post("/CheckEmail",n()(t)).then(function(t){"true"==t.data?(e.errMsg="用户已存在",e.valid=!1):"false"==t.data&&(e.errMsg="",e.valid=!0)}).catch(function(e){console.log("服务器异常！"),console.log(e)})}}}},function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={name:"account",data:function(){return{}}}},function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={name:"cinema",data:function(){return{movies:[{poster:r(1),title:"海边的曼彻斯特"}],days:[],cinemas:[],areas:["增城市","白云区","天河区","海珠区","越秀区","荔湾区","黄埔区","番禺区","花都区","南沙区","从化市"]}},created:function(){this.getDays()},methods:{getDayStr:function(e){var t=new Date;return t.setDate(t.getDate()+e),t.getMonth()+1+"月"+t.getDate()+"日"},buyTicket:function(e){this.$router.push("/movie/detail/"+e)},getDays:function(){for(var e=0;e<7;e++){var t=this.getDayStr(e);this.days.push(t)}console.log(this.days)}}}},function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={created:function(){this.getMovie(this.$route.params.title)},data:function(){return{movie:{},moviesession:[{time:"",price:""}],recentdays:[],cinemas:[]}},methods:{getMovie:function(e){var t=this;this.$http.get("https://bird.ioliu.cn/v1/?url=http://api.douban.com/v2/movie/search?q="+e).then(function(e){var r=e.data.subjects[0].id;r&&t.$http.get("https://bird.ioliu.cn/v1/?url=http://api.douban.com/v2/movie/subject/"+r).then(function(e){e.data&&(t.movie=e.data,setTimeout(function(){document.querySelector(".movie-poster").src=t.movie.images.large},0))}).catch(function(e){return console.log(e)})}).catch(function(e){return console.log(e)})},buyTicket:function(e){this.$router.push("/cinemas/"+e)}}}},function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=r(6),n=r.n(s),i=r(5),a=r.n(i),o=r(14),c=r.n(o);t.default={name:"movies",data:function(){return{username:" ",login:document.cookie.length}},components:{hot:n.a,guess:a.a,photoslider:c.a},methods:{}}},function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=r(6),n=r.n(s),i=r(13),a=r.n(i),o=r(5),c=r.n(o),u=r(14),l=r.n(u);t.default={name:"movies",data:function(){return{username:" ",types:["爱情","喜剧","冒险","恐怖","动作","其他"]}},components:{hot:n.a,coming:a.a,guess:c.a,photoslider:l.a},computed:{getuser:function(){return 0==document.cookie.length?"":this.$cookie.get("user")}},methods:{}}},function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={name:"search",data:function(){return{search_str:this.$route.params.str}},created:function(){this.search(this.search_str)},methods:{search:function(e){console.log(e)}}}},function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={name:"welcome",created:function(){0!=document.cookie.length&&this.$router.push("/movies")}}},,,,,,,,,,,,,,,function(e,t){},function(e,t){},function(e,t){},function(e,t){},function(e,t){},function(e,t){},function(e,t){},function(e,t){},function(e,t){},function(e,t){},function(e,t){},function(e,t){},function(e,t){},function(e,t){},function(e,t){},function(e,t){},function(e,t,r){e.exports=r.p+"static/img/icon.e896833.jpg"},function(e,t,r){e.exports=r.p+"static/img/movingbee.c1ea41f.gif"},function(e,t,r){e.exports=r.p+"static/img/poster2.0d09e72.jpg"},function(e,t,r){e.exports=r.p+"static/img/poster3.230c3fb.jpg"},function(e,t,r){e.exports=r.p+"static/img/poster4.1be2759.jpg"},function(e,t,r){e.exports=r.p+"static/img/poster5.5e37e73.jpg"},function(e,t,r){e.exports=r.p+"static/img/poster6.0fe5060.jpg"},function(e,t,r){e.exports=r.p+"static/img/top1.cfe8efb.jpg"},function(e,t,r){e.exports=r.p+"static/img/top2.11ba27f.jpg"},function(e,t,r){e.exports=r.p+"static/img/top3.b93ac6f.jpg"},function(e,t,r){e.exports=r.p+"static/img/top4.482c8a2.jpg"},function(e,t,r){e.exports=r.p+"static/img/top5.8e883a7.jpg"},function(e,t,r){r(56);var s=r(0)(r(24),r(95),null,null);e.exports=s.exports},function(e,t,r){r(62);var s=r(0)(r(26),r(101),null,null);e.exports=s.exports},function(e,t,r){r(55);var s=r(0)(r(27),r(94),"data-v-3d121162",null);e.exports=s.exports},function(e,t,r){r(52);var s=r(0)(r(28),r(91),"data-v-13e56476",null);e.exports=s.exports},function(e,t,r){r(60);var s=r(0)(r(29),r(99),"data-v-92dce0c0",null);e.exports=s.exports},function(e,t,r){r(51);var s=r(0)(r(30),r(90),"data-v-0ddd0764",null);e.exports=s.exports},function(e,t,r){r(54);var s=r(0)(r(31),r(93),"data-v-31bef1ae",null);e.exports=s.exports},function(e,t,r){r(65);var s=r(0)(r(32),r(104),"data-v-fe5c22f6",null);e.exports=s.exports},function(e,t,r){r(50);var s=r(0)(r(33),r(89),"data-v-0383b7a0",null);e.exports=s.exports},function(e,t,r){r(57);var s=r(0)(r(34),r(96),"data-v-452abb85",null);e.exports=s.exports},function(e,t,r){r(64);var s=r(0)(r(35),r(103),"data-v-fa900356",null);e.exports=s.exports},function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"movies"}},[r("h1",[e._v("请选择电影")]),e._v(" "),r("div",{staticClass:"select-bar"},[r("div",{staticClass:"type"},[r("label",[e._v("类型")]),e._v(" "),r("ul",{staticClass:"select-line"},e._l(e.types,function(t){return r("li",{staticClass:"select-item"},[e._v(e._s(t))])}))]),e._v(" "),r("div",{staticClass:"area"},[r("label",[e._v("区域")]),e._v(" "),r("ul",{staticClass:"select-line"},e._l(e.areas,function(t){return r("li",{staticClass:"select-item"},[e._v(e._s(t))])}))]),e._v(" "),r("div",{staticClass:"cinema"},[r("label"),e._v(" "),r("ul",{staticClass:"select-line"},e._l(e.cinemas,function(t){return r("li",{staticClass:"select-item"},[e._v(e._s(t))])}))])]),e._v(" "),r("div",{staticClass:"container"},[r("div",{staticClass:"sort-form-select"}),e._v(" "),r("hot"),e._v(" "),r("coming"),e._v(" "),r("guess")],1)])},staticRenderFns:[]}},function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"cinema"}},[r("h1",[e._v("请选择影院")]),e._v(" "),r("div",{staticClass:"select-bar"},[r("div",{staticClass:"date"},[r("label",[e._v("日期")]),e._v(" "),r("ul",{staticClass:"select-line"},e._l(e.days,function(t){return r("li",{staticClass:"select-item"},[e._v(e._s(t))])}))]),e._v(" "),r("div",{staticClass:"area"},[r("label",[e._v("区域")]),e._v(" "),r("ul",{staticClass:"select-line"},e._l(e.areas,function(t){return r("li",{staticClass:"select-item"},[e._v(e._s(t))])}))]),e._v(" "),r("div",{staticClass:"cinema"},[r("label",[e._v("影院")]),e._v(" "),r("ul",{staticClass:"select-line"},e._l(e.cinemas,function(t){return r("li",{staticClass:"select-item"},[e._v(e._s(t))])}))])]),e._v(" "),r("div",{staticClass:"movies"},[r("ul",{staticClass:"movies-list"},e._l(e.movies,function(t){return r("li",{staticClass:"movie-item"},[r("img",{attrs:{src:t.poster}}),e._v(" "),r("p",{staticClass:"movietitle"},[e._v(e._s(t.title))]),e._v(" "),r("button",{staticClass:"btn buy_ticket",on:{click:function(r){e.buyTicket(t.title)}}},[e._v("购票")])])}))])])},staticRenderFns:[]}},function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"signup"}},[r("p",{staticClass:"em"},[e._v(e._s(e.errMsg))]),e._v(" "),r("form",{on:{submit:function(t){t.preventDefault(),e.submit(t)}}},[r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.email,expression:"user.email"}],staticClass:"email text",attrs:{type:"email",name:"email",placeholder:"邮箱（必填）"},domProps:{value:e.user.email},on:{blur:e.checkEmail,input:function(t){t.target.composing||(e.user.email=t.target.value)}}}),e._v(" "),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.password,expression:"user.password"}],staticClass:"password text",attrs:{type:"password",name:"password",placeholder:"密码（必填）"},domProps:{value:e.user.password},on:{input:function(t){t.target.composing||(e.user.password=t.target.value)}}}),e._v(" "),r("input",{staticClass:"repeated-password text",attrs:{type:"password",name:"repeated",placeholder:"重复密码"}}),e._v(" "),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.nickname,expression:"user.nickname"}],staticClass:"nickname text",attrs:{type:"text",name:"nickname",placeholder:"用户昵称"},domProps:{value:e.user.nickname},on:{input:function(t){t.target.composing||(e.user.nickname=t.target.value)}}}),e._v(" "),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.phone,expression:"user.phone"}],staticClass:"phone text",attrs:{type:"text",name:"phone",placeholder:"手机号码"},domProps:{value:e.user.phone},on:{input:function(t){t.target.composing||(e.user.phone=t.target.value)}}}),e._v(" "),r("div",{staticClass:"per"},[r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.pereference,expression:"user.pereference"}],attrs:{type:"checkbox",id:"Romance",value:"Romance"},domProps:{checked:Array.isArray(e.user.pereference)?e._i(e.user.pereference,"Romance")>-1:e.user.pereference},on:{__c:function(t){var r=e.user.pereference,s=t.target,n=!!s.checked;if(Array.isArray(r)){var i="Romance",a=e._i(r,i);n?a<0&&(e.user.pereference=r.concat(i)):a>-1&&(e.user.pereference=r.slice(0,a).concat(r.slice(a+1)))}else e.user.pereference=n}}}),e._v(" "),r("label",{attrs:{for:"Romance"}},[e._v("爱情")]),e._v(" "),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.pereference,expression:"user.pereference"}],attrs:{type:"checkbox",id:"Comedy",value:"Comedy"},domProps:{checked:Array.isArray(e.user.pereference)?e._i(e.user.pereference,"Comedy")>-1:e.user.pereference},on:{__c:function(t){var r=e.user.pereference,s=t.target,n=!!s.checked;if(Array.isArray(r)){var i="Comedy",a=e._i(r,i);n?a<0&&(e.user.pereference=r.concat(i)):a>-1&&(e.user.pereference=r.slice(0,a).concat(r.slice(a+1)))}else e.user.pereference=n}}}),e._v(" "),r("label",{attrs:{for:"Comedy"}},[e._v("喜剧")]),e._v(" "),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.pereference,expression:"user.pereference"}],attrs:{type:"checkbox",id:"Adventure",value:"Adventure"},domProps:{checked:Array.isArray(e.user.pereference)?e._i(e.user.pereference,"Adventure")>-1:e.user.pereference},on:{__c:function(t){var r=e.user.pereference,s=t.target,n=!!s.checked;if(Array.isArray(r)){var i="Adventure",a=e._i(r,i);n?a<0&&(e.user.pereference=r.concat(i)):a>-1&&(e.user.pereference=r.slice(0,a).concat(r.slice(a+1)))}else e.user.pereference=n}}}),e._v(" "),r("label",{attrs:{for:"Adventure"}},[e._v("冒险")]),e._v(" "),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.pereference,expression:"user.pereference"}],attrs:{type:"checkbox",id:"Horror",value:"Horror"},domProps:{checked:Array.isArray(e.user.pereference)?e._i(e.user.pereference,"Horror")>-1:e.user.pereference},on:{__c:function(t){var r=e.user.pereference,s=t.target,n=!!s.checked;if(Array.isArray(r)){var i="Horror",a=e._i(r,i);n?a<0&&(e.user.pereference=r.concat(i)):a>-1&&(e.user.pereference=r.slice(0,a).concat(r.slice(a+1)))}else e.user.pereference=n}}}),e._v(" "),r("label",{attrs:{for:"Horror"}},[e._v("恐怖")]),e._v(" "),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.pereference,expression:"user.pereference"}],attrs:{type:"checkbox",id:"Action",value:"Action"},domProps:{checked:Array.isArray(e.user.pereference)?e._i(e.user.pereference,"Action")>-1:e.user.pereference},on:{__c:function(t){var r=e.user.pereference,s=t.target,n=!!s.checked;if(Array.isArray(r)){var i="Action",a=e._i(r,i);n?a<0&&(e.user.pereference=r.concat(i)):a>-1&&(e.user.pereference=r.slice(0,a).concat(r.slice(a+1)))}else e.user.pereference=n}}}),e._v(" "),r("label",{attrs:{for:"Action"}},[e._v("动作")]),e._v(" "),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.pereference,expression:"user.pereference"}],attrs:{type:"checkbox",id:"Others",value:"Others"},domProps:{checked:Array.isArray(e.user.pereference)?e._i(e.user.pereference,"Others")>-1:e.user.pereference},on:{__c:function(t){var r=e.user.pereference,s=t.target,n=!!s.checked;if(Array.isArray(r)){var i="Others",a=e._i(r,i);n?a<0&&(e.user.pereference=r.concat(i)):a>-1&&(e.user.pereference=r.slice(0,a).concat(r.slice(a+1)))}else e.user.pereference=n}}}),e._v(" "),r("label",{attrs:{for:"Others"}},[e._v("其它")])]),e._v(" "),r("input",{staticClass:"btn",attrs:{type:"submit",value:"提交"}})])])},staticRenderFns:[]}},function(e,t,r){e.exports={render:function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{attrs:{id:"app"}},[s("header",[s("div",{attrs:{id:"logo"},on:{click:e.mainpage}},[s("img",{attrs:{id:"icon",src:r(66)}}),e._v(" "),s("span",[e._v("BeeBee Movie")])]),e._v(" "),e._m(0),e._v(" "),s("div",[s("router-link",{attrs:{to:"/movies"}},[e._v("电影")]),e._v(" | \n        "),s("router-link",{attrs:{to:"/cinemas"}},[e._v("影院")])],1),e._v(" "),s("div",[s("form",[s("input",{directives:[{name:"model",rawName:"v-model",value:e.search_str,expression:"search_str"}],attrs:{type:"text",placeholder:"请输入电影名、影院名"},domProps:{value:e.search_str},on:{input:function(t){t.target.composing||(e.search_str=t.target.value)}}}),e._v(" "),s("button",{staticClass:"btn",on:{click:function(t){e.search(e.search_str)}}},[e._v("搜索")])])]),e._v(" "),e.login?s("div",{staticClass:"greeting"},[s("router-link",{attrs:{to:"/account"}},[e._v("个人中心")]),e._v(" "),s("button",{staticClass:"btn",on:{click:e.logout}},[e._v("退出登录")])],1):s("div",{staticClass:"greeting"},[s("router-link",{attrs:{to:"/welcome/signin"}},[e._v("登陆")]),e._v(" | \n    \t\t"),s("router-link",{attrs:{to:"/welcome/signup"}},[e._v("注册")])],1)]),e._v(" "),s("router-view")],1)},staticRenderFns:[function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("label",[e._v("城市：")]),e._v(" "),r("select",[r("option",[e._v("广州")])])])}]}},function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"container"}},[r("div",{staticClass:"detail"},[e._m(0),e._v(" "),r("div",{staticClass:"detail-right"},[r("h1",[e._v(e._s(e.movie.title)+" "+e._s(e.movie.original_title))]),e._v(" "),r("p",[r("span",{staticClass:"label"},[e._v("评分: ")]),e._v(" "),r("span",{staticClass:"content"},[e._v(e._s(e.movie.rating.average))])]),e._v(" "),r("p",[r("span",{staticClass:"label"},[e._v("国家: ")]),e._v(" "),r("span",{staticClass:"content"},[e._v(e._s(e.movie.countries.join(""))+" ("+e._s(e.movie.year)+")")])]),e._v(" "),r("p",[r("span",{staticClass:"label"},[e._v("导演: ")]),e._v(" "),r("span",{staticClass:"content"},e._l(e.movie.directors,function(t){return r("a",{attrs:{href:t.alt}},[e._v(e._s(t.name))])}))]),e._v(" "),r("p",[r("span",{staticClass:"label"},[e._v("演员: ")]),e._v(" "),r("span",{staticClass:"content"},e._l(e.movie.casts,function(t){return r("a",{attrs:{href:t.alt}},[e._v(e._s(t.name)+" / ")])}))]),e._v(" "),r("p",[r("span",{staticClass:"label"},[e._v("简介: ")]),e._v(" "),r("span",{staticClass:"content"},[e._v(e._s(e.movie.summary))])])])]),e._v(" "),r("div",{staticClass:"border"}),e._v(" "),r("div",{staticClass:"ticket-info"},[r("div",{staticClass:"select-bar"},[r("form",[r("select",{attrs:{name:"date"}},e._l(e.recentdays,function(t){return r("option",[e._v(e._s(t))])})),e._v(" "),e._m(1)]),e._v(" "),r("div",{staticClass:"cinema-select-bar"},e._l(e.cinemas,function(t){return r("span",[e._v(e._s(t))])}))]),e._v(" "),r("div",{staticClass:"session"},e._l(e.moviesession,function(t){return r("div",[r("span",{staticClass:"time"},[e._v(" "+e._s(t.time))]),e._v(" "),r("span",{staticClass:"price"},[e._v(" "+e._s(t.price))]),e._v(" "),r("button",[e._v("订座")])])}))])])},staticRenderFns:[function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"detail-left"},[r("img",{staticClass:"movie-poster"})])},function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("select",{attrs:{name:"city"}},[r("option",[e._v("广州")])])}]}},function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"signin"}},[r("p",{staticClass:"msg"},[e._v(e._s(e.errMsg))]),e._v(" "),r("form",{on:{submit:function(t){t.preventDefault(),e.submit(t)}}},[r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.email,expression:"user.email"}],staticClass:"email",attrs:{type:"email",name:"email",required:"required",placeholder:"邮箱"},domProps:{value:e.user.email},on:{input:function(t){t.target.composing||(e.user.email=t.target.value)}}}),e._v(" "),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.password,expression:"user.password"}],staticClass:"password",attrs:{type:"password",name:"password",required:"required",placeholder:"密码"},domProps:{value:e.user.password},on:{input:function(t){t.target.composing||(e.user.password=t.target.value)}}}),e._v(" "),r("input",{staticClass:"btn",attrs:{type:"submit",value:"提交"}})])])},staticRenderFns:[]}},function(e,t){e.exports={render:function(){var e=this,t=e.$createElement;e._self._c;return e._m(0)},staticRenderFns:[function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"orders"}},[r("h1",[e._v("我的订单")])])}]}},function(e,t){e.exports={render:function(){var e=this,t=e.$createElement;e._self._c;return e._m(0)},staticRenderFns:[function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"search"}},[r("h1",[e._v("搜索结果")]),e._v(" "),r("div")])}]}},function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"guess"}},[r("h1",[e._v("猜你喜欢")]),e._v(" "),r("ul",e._l(e.movies,function(t){return r("li",[r("img",{attrs:{src:t.poster}}),e._v(" "),r("p",{staticClass:"movietitle"},[e._v(e._s(t.title))]),e._v(" "),r("button",{staticClass:"btn buy_ticket",on:{click:function(r){e.buyTicket(t.title)}}},[e._v("购票")])])}))])},staticRenderFns:[]}},function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"silder"},[r("div",{staticClass:"main"},e._l(e.topmovies,function(e,t){return r("div",{staticClass:"main-item",attrs:{id:"main_"+t}},[r("img",{attrs:{src:e.poster}})])})),e._v(" "),r("div",{staticClass:"ctrl"},e._l(e.topmovies,function(t,s){return r("span",{staticClass:"ctrl-item",attrs:{id:"ctrl_"+s},on:{click:function(t){e.clickSwitchSlider(s)}}})}))])},staticRenderFns:[]}},function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"account"}},[r("div",{staticClass:"left-bar"},[r("router-link",{attrs:{to:"/account/profile"}},[e._v("基本信息")]),e._v(" "),r("router-link",{attrs:{to:"/account/orders"}},[e._v("我的订单")])],1),e._v(" "),r("div",{staticClass:"content"},[r("router-view")],1)])},staticRenderFns:[]}},function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"hot"}},[r("h1",[e._v("正在热映")]),e._v(" "),r("ul",e._l(e.movies,function(t){return r("li",[r("img",{attrs:{src:t.poster}}),e._v(" "),r("p",{staticClass:"movietitle"},[e._v(e._s(t.title))]),e._v(" "),r("button",{staticClass:"btn buy_ticket",on:{click:function(r){e.buyTicket(t.title)}}},[e._v("购票")])])}))])},staticRenderFns:[]}},function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"profile"}},[r("h1",[e._v("基本信息")]),e._v(" "),r("form",[r("div",{staticClass:"line"},[r("label",[e._v("邮箱：")]),e._v(" "),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.email,expression:"user.email"}],staticClass:"email",attrs:{type:"email",value:"user.email",readonly:"readonly"},domProps:{value:e.user.email},on:{input:function(t){t.target.composing||(e.user.email=t.target.value)}}})]),e._v(" "),r("div",{staticClass:"line"},[r("label",[e._v("昵称：")]),e._v(" "),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.nickname,expression:"user.nickname"}],staticClass:"nickname",attrs:{type:"text",name:"nickname",value:"user.nickname"},domProps:{value:e.user.nickname},on:{input:function(t){t.target.composing||(e.user.nickname=t.target.value)}}})]),e._v(" "),r("div",{staticClass:"line"},[r("label",[e._v("电话：")]),e._v(" "),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.phone,expression:"user.phone"}],attrs:{type:"text",name:"phone"},domProps:{value:e.user.phone},on:{input:function(t){t.target.composing||(e.user.phone=t.target.value)}}})]),e._v(" "),r("div",{staticClass:"line"},[r("label",[e._v("喜好：")]),e._v(" "),r("div",{staticClass:"per"},[r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.pereference,expression:"user.pereference"}],attrs:{type:"checkbox",id:"Romance",value:"Romance"},domProps:{checked:Array.isArray(e.user.pereference)?e._i(e.user.pereference,"Romance")>-1:e.user.pereference},on:{__c:function(t){var r=e.user.pereference,s=t.target,n=!!s.checked;if(Array.isArray(r)){var i="Romance",a=e._i(r,i);n?a<0&&(e.user.pereference=r.concat(i)):a>-1&&(e.user.pereference=r.slice(0,a).concat(r.slice(a+1)))}else e.user.pereference=n}}}),e._v(" "),r("label",{attrs:{for:"Romance"}},[e._v("爱情")]),e._v(" "),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.pereference,expression:"user.pereference"}],attrs:{type:"checkbox",id:"Comedy",value:"Comedy"},domProps:{checked:Array.isArray(e.user.pereference)?e._i(e.user.pereference,"Comedy")>-1:e.user.pereference},on:{__c:function(t){var r=e.user.pereference,s=t.target,n=!!s.checked;if(Array.isArray(r)){var i="Comedy",a=e._i(r,i);n?a<0&&(e.user.pereference=r.concat(i)):a>-1&&(e.user.pereference=r.slice(0,a).concat(r.slice(a+1)))}else e.user.pereference=n}}}),e._v(" "),r("label",{attrs:{for:"Comedy"}},[e._v("喜剧")]),e._v(" "),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.pereference,expression:"user.pereference"}],attrs:{type:"checkbox",id:"Adventure",value:"Adventure"},domProps:{checked:Array.isArray(e.user.pereference)?e._i(e.user.pereference,"Adventure")>-1:e.user.pereference},on:{__c:function(t){var r=e.user.pereference,s=t.target,n=!!s.checked;if(Array.isArray(r)){var i="Adventure",a=e._i(r,i);n?a<0&&(e.user.pereference=r.concat(i)):a>-1&&(e.user.pereference=r.slice(0,a).concat(r.slice(a+1)))}else e.user.pereference=n}}}),e._v(" "),r("label",{attrs:{for:"Adventure"}},[e._v("冒险")]),e._v(" "),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.pereference,expression:"user.pereference"}],attrs:{type:"checkbox",id:"Horror",value:"Horror"},domProps:{checked:Array.isArray(e.user.pereference)?e._i(e.user.pereference,"Horror")>-1:e.user.pereference},on:{__c:function(t){var r=e.user.pereference,s=t.target,n=!!s.checked;if(Array.isArray(r)){var i="Horror",a=e._i(r,i);n?a<0&&(e.user.pereference=r.concat(i)):a>-1&&(e.user.pereference=r.slice(0,a).concat(r.slice(a+1)))}else e.user.pereference=n}}}),e._v(" "),r("label",{attrs:{for:"Horror"}},[e._v("恐怖")]),e._v(" "),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.pereference,expression:"user.pereference"}],attrs:{type:"checkbox",id:"Action",value:"Action"},domProps:{checked:Array.isArray(e.user.pereference)?e._i(e.user.pereference,"Action")>-1:e.user.pereference},on:{__c:function(t){var r=e.user.pereference,s=t.target,n=!!s.checked;if(Array.isArray(r)){var i="Action",a=e._i(r,i);n?a<0&&(e.user.pereference=r.concat(i)):a>-1&&(e.user.pereference=r.slice(0,a).concat(r.slice(a+1)))}else e.user.pereference=n}}}),e._v(" "),r("label",{attrs:{for:"Action"}},[e._v("动作")]),e._v(" "),r("input",{directives:[{name:"model",rawName:"v-model",value:e.user.pereference,expression:"user.pereference"}],attrs:{type:"checkbox",id:"Others",value:"Others"},domProps:{checked:Array.isArray(e.user.pereference)?e._i(e.user.pereference,"Others")>-1:e.user.pereference},on:{__c:function(t){var r=e.user.pereference,s=t.target,n=!!s.checked;if(Array.isArray(r)){var i="Others",a=e._i(r,i);n?a<0&&(e.user.pereference=r.concat(i)):a>-1&&(e.user.pereference=r.slice(0,a).concat(r.slice(a+1)))}else e.user.pereference=n}}}),e._v(" "),r("label",{attrs:{for:"Others"}},[e._v("其它")])])]),e._v(" "),r("input",{staticClass:"btn",attrs:{type:"submit",value:"提交"}})])])},staticRenderFns:[]}},function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"coming"}},[r("h1",[e._v("即将上映")]),e._v(" "),r("ul",e._l(e.movies,function(t){return r("li",{on:{click:function(r){e.showDetail(t.title,r)}}},[r("img",{attrs:{src:t.poster}}),e._v(" "),r("p",{staticClass:"movietitle"},[e._v(e._s(t.title))])])}))])},staticRenderFns:[]}},function(e,t,r){e.exports={render:function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{attrs:{id:"welcome"}},[s("div",{staticClass:"left-part"},[s("img",{attrs:{src:r(67)}}),e._v(" "),s("h1",[e._v("欢迎来到 BeeBee!")]),e._v(" "),s("div",{staticClass:"enter"},[s("router-link",{attrs:{to:"/movies"}},[e._v("直接进入-->")])],1)]),e._v(" "),s("div",{staticClass:"right-part"},[s("router-link",{staticClass:"btn",attrs:{to:"/welcome/signin"}},[e._v("登陆")]),e._v(" "),s("router-link",{staticClass:"btn",attrs:{to:"/welcome/signup"}},[e._v("注册")]),e._v(" "),s("router-view")],1)])},staticRenderFns:[]}},function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"movies"}},[r("photoslider"),e._v(" "),r("div",{staticClass:"container"},[r(e.login?"guess":"hot")],1)],1)},staticRenderFns:[]}},,,,function(e,t,r){function s(e){return r(n(e))}function n(e){var t=i[e];if(!(t+1))throw new Error("Cannot find module '"+e+"'.");return t}var i={"./top1.jpg":73,"./top2.jpg":74,"./top3.jpg":75,"./top4.jpg":76,"./top5.jpg":77};s.keys=function(){return Object.keys(i)},s.resolve=n,e.exports=s,s.id=108},function(e,t){},function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=r(8),n=r(18),i=r.n(n),a=r(17),o=r(16),c=r.n(o),u=r(15),l=r.n(u);s.a.config.productionTip=!1,s.a.use(c.a),s.a.use(l.a),new s.a({el:"#app",router:a.a,template:"<App/>",components:{App:i.a}})}],[110]);
//# sourceMappingURL=app.3ca840d4b4996527d8cf.js.map