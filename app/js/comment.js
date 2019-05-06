// 设计思想 显示自定义弹框  显示和隐藏方法  Show None

// 显示 ['.a','.b],['.j','.h]  Show None 为显示隐藏的class 参数可以调换用达到显示和隐藏双重应用
function Show_motai(ShowArrClass) {
	var len = ShowArrClass.length;
	for (var i = 0; i < len; i++) {
		$(ShowArrClass[i]).addClass('Show').removeClass('None');
	}
}

function Hide_motai(HideArrClass) {
	var len = HideArrClass.length;
	for (var i = 0; i < len; i++) {
		$(HideArrClass[i]).addClass('None').removeClass('Show');
	}
}
// 手机字符串修改格式 422****325
function strchange(str) {
	var newstr = "";
	var a = str.substring(0, 3)
	var b = '****';
	var c = str.substring(8)
	newstr = a + b + c;
	// console.log(newstr)
	return newstr;
}

// 个人信息弹框 按钮点击 弹框 关闭按钮

function OpenMsg(btnClass, taget) {
	$(btnClass).on('click', function() {
		Show_motai(['.motal', taget])
	})
}

function CloseMsg(CloseBtnClass, taget) {
	$(CloseBtnClass).on('click', function() {
		Hide_motai(['.motal', taget])
	})
}

// radio 单选框判断 $radio(单选框jq对象集合)
function isRadioChecked($radio) {
	var $radioArr = Array.prototype.slice.call($radio);
	return $radioArr.some(function(el) {
		return $(el).prop('checked') === true;
	})
}


// 验证手机 用户名 邮箱 url地址 
function MyRegExp() {
	return {
		isPhone: function(str) {
			var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
			if (!myreg.test(str)) {
				return false;
			} else {
				return true;
			}
		},
		isUrl: function(str) {
			var myreg = /^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$/;
			if (!myreg.test(str)) {
				return false;
			} else {
				return true;
			}
		},
		isEmail: function(str) {
			var myreg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			if (!myreg.test(str)) {
				return false;
			} else {
				return true;
			}
		},
		isUseName: function(str) {
			var myreg = /^[a-z0-9_-]{3,16}$/;
			if (!myreg.test(str)) {
				return false;
			} else {
				return true;
				/^[a-z0-9_-]{3,16}$/
			}
		},
		isPassWord: function(str) {
			var myreg = /^[a-z0-9_-]{6,18}$/;
			if (!myreg.test(str)) {
				return false;
			} else {
				return true;
				/^[a-z0-9_-]{3,16}$/
			}
		}
	}
}
