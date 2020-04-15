function commit(that) {

	let username = $(that).siblings('div').eq(0).children('input').val();
	let nickname = $(that).siblings('div').eq(1).children('input').val();
	let password = $(that).siblings('div').eq(2).children('input').val();
	$.ajax({
		url: 'http://10.168.1.135:10086/user/register',
		type: 'post',
		dataType: 'json',
		data: {
			userName: username,
			nickName: nickname,
			passWord: password
		},
		success: (data) => {
			console.log(data);
			if (data == 0) {
				alert('注册失败');
			} else if (data == 2) {
				alert('账号已存在');
			} else {
				alert('注册成功');
				window.sessionStorage.setItem('username', JSON.stringify(username));
				
				window.location.href = `../html/login.html?username`;
			}
		}
	})
}