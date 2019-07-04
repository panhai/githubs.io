function Nav() {
  //  list-title box
  var Nav_title = $('.nav-box .list-title');
  var Nav_box = $('.nav-box .box');
  console.log(Nav_title)
  Nav_title.on('click', function() {
    $(this).addClass('cur');
    $(this).parent().siblings('li').children('.list-title').removeClass('cur');

    if ($(this).siblings('.box').css('display') !== 'none') {
      $(this).siblings('.box').stop().slideUp(200);
      $(this).children('i.h').addClass('layui-icon-right').removeClass('layui-icon-down');
    } else {
      $(this).siblings('.box').stop().slideDown(200);
      $(this).parent().siblings('li').find('.box').stop().slideUp(200);
      // layui-icon-right layui-icon-down
      $(this).children('i.h').addClass('layui-icon-down').removeClass('layui-icon-right');
      $(this).parent().siblings('li').children('.list-title').children('i.h').addClass('layui-icon-right').removeClass(
        'layui-icon-down');
    }

  })
}
Nav();

// 左侧导航伸缩切换
var focu = true; //开关
$('.toggle-nav').on('click', function() {
  if (focu) {
    focu = !focu;
    $('.nav-left').animate({
      left: -220
    });
    $('.mian-content').animate({
      'padding-left': 10
    });
  } else {
    focu = !focu;
    $('.nav-left').animate({
      left: 0
    });
    $('.mian-content').animate({
      'padding-left': 235
    });
  }

})

// 将表单的所有数据拼接成object 对象 from 为jq对象 $('form')
var serializeObject = function(from) {
  var o = {};
  $.each(from.serializeArray(), function(index) {
    if (o[this['name']]) {
      o[this['name']] = o[this['name']] + "," + this['value'];
    } else {
      o[this['name']] = this['value'];
    }
  });
  console.log(o);
  return o;
}

// 显示切换用户设置
$('.userSet').hover(function() {
  $(this).children('div').stop().show()
}, function() {
  $(this).children('div').stop().slideUp()
})

//判断平台  'baidu','douying','toutiao','guangdiantou'
function isPlatform(str) {
  var url = document.referrer;
  var bol = url.indexOf(str) != -1;
  console.log(url)
  return bol;
}

// url,data,type,fn
// 增删 改查 ajax 封装 fn 是成功的回调函数

function add(url, data, type, fn) {
  $.ajax({
    url: url,
    type: type,
    data: data,
    async: true,
    cache: false,
    dataType: 'json',
    success: function(res) {
      fn(res)
    },
    error: function(XMLHttpRequest, textStatus, errorThrown) {
      console.log(XMLHttpRequest, textStatus, errorThrown)
      alert('提交失败')
    }
  })
}

function del(url, data, type, fn) {
  $.ajax({
    url: url,
    type: type,
    data: data,
    async: true,
    cache: false,
    dataType: 'json',
    success: function(res) {
      fn(res)
    },
    error: function(XMLHttpRequest, textStatus, errorThrown) {
      console.log(XMLHttpRequest, textStatus, errorThrown)
      alert('提交失败')
    }
  })
}

function search(url, data, type, fn) {
  $.ajax({
    url: url,
    type: type,
    data: data,
    async: true,
    cache: false,
    dataType: 'json',
    success: function(res) {
      fn(res)
    },
    error: function(XMLHttpRequest, textStatus, errorThrown) {
      console.log(XMLHttpRequest, textStatus, errorThrown)
      alert('提交失败')
    }
  })
}

function change(url, data, type, fn) {
  $.ajax({
    url: url,
    type: type,
    data: data,
    async: true,
    cache: false,
    dataType: 'json',
    success: function(res) {
      fn(res)
    },
    error: function(XMLHttpRequest, textStatus, errorThrown) {
      console.log(XMLHttpRequest, textStatus, errorThrown)
      alert('提交失败')
    }
  })
}

//中文转换unicode
function uniencode(text) {
  text = escape(text.toString()).replace(/\+/g, "%2B");
  var matches = text.match(/(%([0-9A-F]{2}))/gi);
  if (matches) {
    for (var matchid = 0; matchid < matches.length; matchid++) {
      var code = matches[matchid].substring(1, 3);
      if (parseInt(code, 16) >= 128) {
        text = text.replace(matches[matchid], '%u00' + code);
      }
    }
  }
  text = text.replace('%25', '%u0025');
  return text;
}


//  权限设置（设置角色）  添加 删除
function addDel() {
  var $add = null;
  var $del = null;
  var powerArr = []; //原有的data-power

  var add_power = function(res) { //处理回调函数
    // console.log(res)
    $('.right').append($add)
  }
  var del_power = function(res) { //删除成功的回调
    // console.log(res)
    $del.remove()

    $del.each(function(index, el) {
      var index = powerArr.indexOf($(el).attr('data-power'));
      powerArr.splice(index, 1)
    })
  }

  $('.left>span,.right>span').on('click', function() {
    $(this).toggleClass('cur')
  })
  $('.add-del-box .add').on('click', function() {
    $add = $('.left>span.cur').clone(true).removeClass('cur');
    //添加到right盒子后面

    $('.right>span').each(function(index, el) {
      powerArr.push($(this).attr('data-power'))
    })

    if ($add.length == 0) {
      layer.alert('请选择选项', {
        icon: 3,
        title: '提示'
      })
      return false;
    }
    if (powerArr.length == 0) {
      //发送请求
      add('../../js/data.json', '', 'get', add_power);
    } else {
      //如果不是空,则判断是否有重复的data-power
      $add.each(function() {
        if (powerArr.indexOf($(this).attr('data-power')) > -1) { //判断是否包含该data-power
          layer.alert('添加选项和原有的选项不可重复', {
            icon: 3,
            title: '提示'
          })
          return false;
        }
        //发送请求
        // url,data,type,fn
        // 增删 改查 ajax 封装 fn 是成功的回调函数
        add('../../js/data.json', '', 'get', add_power);
      })
    }
  })
  $('.add-del-box .del').on('click', function() {
    $del = $('.right>span.cur');
    //添加到left盒子后面
    //发送删除请求
    del('../../js/data.json', '', 'get', del_power);
  })
}
