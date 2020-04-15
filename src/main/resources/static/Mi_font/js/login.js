// 请求登录接口
function commit(that) {
	let username = $(that).parents().siblings('p').eq(1).children().val();
	let password = $(that).parents().siblings('p').eq(2).children().val();

	

	$.ajax({
		url: 'http://10.168.1.135:10086/user/login',
		type: 'get',
		dataType: 'json',
		data: {
			userName: username,
			passWord: password
		},
		success: (data) => {
			
			// 将用户名存入本地存储
			console.log(data);
			if (data.result == 0) {
				alert('账户未注册');
			}else{
				window.sessionStorage.setItem('nickname', JSON.stringify(data.nickName));
				window.sessionStorage.setItem('username', JSON.stringify(username));
				window.location.href = `../index.html`;
			}
		}
	})
}


$(function () {

	// 获取用户注册时的默认账号
	let username;
	window.sessionStorage.getItem('username') == null ? username = '' : username = JSON.parse(window.localStorage.getItem('username'));
	
	
	// 账号登录与扫码登录的切换动画
	$('.title span').click(function () {
		$(this).addClass('check').siblings().removeClass('check');
		$('.login_msg>div').eq($('.title span.check').index()).css('display', 'block').siblings('div').css('display', 'none');
	});

	$('input[type="text"]').attr('value', username);

})