// 搜索产品功能------------------------------------------------------
function Search (that) {
    let value=$(that).siblings('.sea_content').children('input').val();

    $.ajax({
        type: "get",
        url: "http://10.168.1.135:10086/selectByProductName",
        data: {
            productName: value
        },
        dataType: "json",
        success: function (res) {
            console.log(res);
        }
    });

}

// 获取用户点击需要查看的商品----------------------------------------------------
function getName(that){
    let ordername = $(that).children("span").html();
    console.log(ordername);
    window.sessionStorage.setItem('orderName', ordername);
    window.location.href="./html/orderShow.html";
}

// --------------------------将用户所在地址存入本地存储----------------------------
function onComplete(obj) {
    window.sessionStorage.setItem('province', JSON.stringify(obj.addressComponent.province));
    window.sessionStorage.setItem('city', JSON.stringify(obj.addressComponent.city));
    window.sessionStorage.setItem('district', JSON.stringify(obj.addressComponent.district));
    window.sessionStorage.setItem('township', JSON.stringify(obj.addressComponent.township));
}

function onError(data){
    console.log(data);
}

$(function () {

    let username = JSON.parse(window.sessionStorage.getItem('username'));
    let nickname = JSON.parse(window.sessionStorage.getItem('nickname'));

    // --------------------------获取用户所在地址--------------------------
    let map = new AMap.Map('container', {
        zoom: 18, //级别
        viewMode: '3D' //使用3D视图
    });

    AMap.plugin('AMap.Geolocation', function () {
        var geolocation = new AMap.Geolocation({
            enableHighAccuracy: true,
            timeout: 30000,
            maximumAge: 0,
            convert: true,
            showButton: true,
            buttonPosition: 'LB',
            buttonOffset: new AMap.Pixel(10, 20),
            showMarker: true,
            showCircle: true,
            panToLocation: true,
            zoomToAccuracy: true

        });
        // console.log(geolocation);
        map.addControl(geolocation);
        geolocation.getCurrentPosition();
        AMap.event.addListener(geolocation, 'complete', onComplete); // 返回定位信息
        AMap.event.addListener(geolocation, 'error', onError)
    });

    // 登录状态判断---------------------------------------------------
    if (username==null){
        console.log('无参数');
    }else{
        $('.loginmsg').empty();
        $('.loginmsg').append(`
            <div class="shortcar">
					<i class="iconfont icon-gouwuche2"></i>
                <b>购物车</b>
                <span>(1)</span>
                <div class="shortlist">
                    <p>购物车中还没有商品，赶紧选购吧</p>
                    <ul></ul>
                </div>
            </div>
            <ul class="right">
                <li class="userid">
                    ${nickname}<i class="iconfont icon-xjiantou"></i>
                    <ol>
                        <li><a href="./html/personCenter.html">个人中心</a><li>
                        <li><a href="#">评价晒单</a><li>
                        <li><a href="./html/personCenter.html">我的喜欢</a><li>
                        <li><a href="#">小米账号</a><li>
                        <li><a href="#">退出登录</a><li>
                    </ol>
                </li>
                <li><a href="./html/register.html">消息通知</a></li>
                <li><a href="#">我的订单</a></li>
            </ul>
        `)

        $.ajax({
            type: "get",
            url: "http://10.168.1.135:10086/user/getShoppingCard",
            data: {
                name: username,
            },
            dataType: "json",
            success: function (res) {
                $('.shortlist p').remove();
                for (const i in res) {
                      console.log(res[i]);
                    $('.shortlist ul').append(`
                        <li onclick="window.location.href='./html/shopCart.html'">
                            <img src="${res[i].picture1}" alt="">
                            <div>
                                ${res[i].productName}
                                <p>${res[i].color}</p>
                            </div>
                            <span>${res[i].currentPrice} x ${res[i].quantity}</span>
                        </li>
                    `)


                }
                console.log(res);
                // window.sessionStorage.setItem('shopcarobj', JSON.stringify(shopcarobj));
                // if(res[i].shoppingcartid==''){
                //     let id=0;
                //     window.sessionStorage.setItem('id',id);
                // }else{

                // }
            }
        });

    }


    //主页图标效果---------------------------------------
    $('.logo').hover(function () {
        $('.logo>ul').stop().animate({
            'left': '0'
        }, 150)

    }, function () {
        $('.logo>ul').stop().animate({
            'left': '-55px'
        }, 150)
    });


    //左侧导航栏效果---------------------------------------
    $('.nav_left li').hover(function () {
        $(this).children('.navList_con').css({
            'visibility': 'visible'
        });
        $(this).siblings().children('.navList_con').css({
            'visibility': 'hidden'
        });
    }, function () {
        $('.navList_con').css({
            'visibility': 'hidden'
        });
    });

    // 右侧个人信息展示动画----------------------------------------------
    $('.userid').hover(function () {
           $(this).css({'background-color': '#fff','color':'#f60'});
            $(this).children('ol').slideDown(300);
            $(this).children('ol').css('color','#424242');

        }, function () {
            $(this).css({'background-color': '#333','color':'#b0b0b0'});
            $(this).children('ol').slideUp(300);
        }
    );

    $('.userid ol li').hover(function () {
            $(this).css({'background-color':'#ccc','color':'#f60'})

        }, function () {
            $(this).css({ 'background-color': '#fff', 'color': '#424242' })
        }
    );


    // 右侧购物车动画------------------------------------------------
    $('.shortcar').hover(function () {
        $('.shortlist').css('display', 'block');
        $('.shortcar>i').css('color', '#f60');
        $('.shortcar>b').css('color', '#f60');
        $('.shortcar>span').css('color', '#f60');
        }, function () {
            $('.shortlist').css('display', 'none');
            $('.shortcar>i').css('color', '#b0b0b0');
            $('.shortcar>b').css('color', '#b0b0b0');
            $('.shortcar>span').css('color', '#b0b0b0');
        }
    );

    //主页轮播图------------------------------------------------------
    // var num = 0;
    // var picLength = $(".lunbo a").length;

    // function fx(n) {
    //     $(".lunbo a").stop(true).fadeOut(500);
    //     $('.dote li').css("background", "#8f9499");
    //     $(".lunbo a").eq(n).stop(true).fadeIn(1000);
    //     $('.dote li').eq(n).css("background", "white");
    // }

    // $('#leftBtn').click(function (e) {
    //     num--;
    //     if (num < 0) {
    //         num = 4;
    //     }
    //     fx(num);
    // });

    // $('#rightBtn').click(function (e) {
    //     num++;
    //     if (num >= picLength) {
    //         num = 0;
    //     }
    //     fx(num);
    // });

    // var timer = setInterval(index, 2000);

    // $('#leftBtn').hover(function () {
    //     clearInterval(timer);

    // }, function () {
    //     timer = setInterval(index, 2000);
    // });

    // $('#rightBtn').hover(function () {
    //     clearInterval(timer);

    // }, function () {
    //     timer = setInterval(index, 2000);
    // });

    // $('.lunbo').hover(function () {
    //     clearInterval(timer);

    //     }, function () {
    //         timer = setInterval(index, 2000);
    //     }
    // );

    // function index() {
    //     fx(num);
    //     num++;
    //     if (num >= picLength) {
    //         num = 0;
    //     }

    // }

    // $('.dote li').hover(function () {
    //         $(this).css('background','white');

    //     }, function () {
    //         $(this).css('background', '#8f9499');
    //     }
    // );


})
