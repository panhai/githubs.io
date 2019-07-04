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



// 客服窗口代码
function kefu() {
  var _53code = document.createElement("script");
  _53code.src = '//tb.53kf.com/code/code/c762816c46f81ba33560df7feac9ded1/1';
  var s = document.getElementsByTagName("script")[0];
  s.parentNode.insertBefore(_53code, s);
}

// 倒计时
/**
 * src  图片地址结构
 * timebox  倒数计时盒子
 * time_img 图片class
 * 例如：
 * 'img/img_m/','img/img_m/07.png','time-box','day_time_img'
 */

function showDay(srcq, src, timebox, time_img) {
  var date = new Date();
  var year = date.getFullYear();
  var lastDate = new Date(year, 4, 19, "00", "00");
  var firstDay = new Date(year, 4, 12, "00", "00");
  var src = src;
  var srcq = srcq;

  var index1 = src.lastIndexOf("/") + 1;
  var index2 = src.lastIndexOf(".");

  var len = src.length;
  var src2 = src.substring(index1, index2);

  console.log(src2, index1, index2)
  var d = lastDate - date; // 时间戳

  if (firstDay > date) {
    $('.' + timebox).addClass('None')
  }

  if (d < 0) {
    $('.' + timebox).hide()
  } else {
    var dayNum = Math.floor(d / 1000 / 60 / 60 / 24) + 1;
    var t = "0" + dayNum;
    src2 = t;
    var newsrc = srcq + src2 + ".png";
    $('.' + time_img).attr('src', newsrc)
  }

}

// 获取验证码ajax
function getMa(data) {
  $.ajax({
    url: "js/data.json",
    type: "GET",
    data: data,
    dataType: "json",
    success: function(res) {
      if (res.success == "success") {
        ma = res.code;
        console.log(ma)
      }
      console.log(res)
    },
    error: function(res) {
      console.log(res)
    }
  })
}

//获取地址参数部分即为需要的参数地址
function getUrlString() {
  var url = window.location.href.split('?')[1].split('=')[1];
  return url
}

function move() {
  var $lists = $('.box p');
  var $box = $('.box');

  var step = $('.box p').eq(0).height();
  var timer = null;
  var index = 0;
  var len = $lists.length;
  var num = 0;

  var timer = setInterval(function() {
    num++;
    if (num > len - 1) {
      num = 0;
    }
    $box.animate({
      top: -num * step
    }, 100)
    console.log(len)
  }, 2500)

  // console.log(step)

}

function move2(box) {
  var $lists = $(box + ' p');
  var $box = $(box);

  var step = $(box + ' p').eq(0).height();
  var timer = null;
  var index = 0;
  var len = $lists.length;
  var num = 0;

  var timer = setInterval(function() {
    num++;
    if (num > len - 1) {
      num = 0;
    }
    $box.animate({
      top: -num * step
    }, 100)
  }, 2500)

  // console.log(step)

}

function sourceLink() {
  var sourceLink = "";
  if (document.referrer) {
    sourceLink = document.referrer
  } else {
    sourceLink = window.location.href;
  }
  return sourceLink;
}
// 判断是否是某个平台
function ispingtai(str, sourceLinks) {
  sourceLinks = sourceLinks.split('/')[2];
  console.log(sourceLinks)
  return sourceLinks.indexOf(str) != -1;
}
