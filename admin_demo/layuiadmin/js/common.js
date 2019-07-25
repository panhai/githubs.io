/**
 * idArr 行数据的id 数组
 * url 请求的url 接口
 * fn 删除完成后的回调操作
 */
function delRow(idArr, url, fn) {
  var ids = idArr;
  $.ajax({
    url: url,
    type: 'post',
    data: {
      ids: ids
    },
    success: function(data) {
      layer.alert('删除数据成功！', {
        icon: 1
      }, function() {
        if (fn) {
          fn()
          layer.closeAll();
        }
        layer.closeAll();
      });

    },
    error: function(data) {
      layer.alert('删除数据失败！', {
        icon: 1
      }, function() {
        layer.closeAll();
      });
    }
  })

}

// 表单提交请求
function AjaxData(url, data, fn) {
  $.ajax({
    url: url,
    type: 'post',
    data: data,
    success: function(data) {
      fn()
    },
    error: function(data) {
      layer.alert('数据提交失败！', {
        icon: 1
      }, function() {
        layer.closeAll();
      });
    }
  })

}

//刷新表格
function suaTable(mytable, option) {
  mytable.reload(option);
}

/**
 * 选择日期
 * 
 */
function selectDate(id) {
  //常规用法
  laydate.render({
    elem: id
  });
}

// 清楚表单
/**
 * form id/class
 * imgId 图片id/class
 */

function clearForm(id, imgId) {
  $(id)[0].reset();
  $(imgId).attr('src', '');
}

function clearForms(id) {
  $(id)[0].reset();
}


//提交表单
/**
 * formId 表单的id
 * data 上传的数据
 * url 上传的接口
 * fn 上传成功的回调操作
 */

function sendAjax(data, url, fn) {
  $.ajax({
    type: 'post',
    url: url,
    success: function(data) {
      fn(data)
      layer.alert('数据提交成功！', {
        icon: 1
      }, function() {
        layer.closeAll();
      });
    }
  })
}

function sendAjax2(data, url, fn) {
  $.ajax({
    type: 'post',
    url: url,
    success: function(data) {
      fn()
    }
  })
}

//取消关闭layer弹框
$('.disqualify').on('click', function() {
  layer.closeAll();
})


/**
 * arr 选项数据数据 ["name","name",......]
 * id select 元素的id 或者class
 */

function showOption(arr, id) {
  var html = '';
  for (var i = 0; i < arr.length; i++) {
    html += '<option value="' + arr[i] + '">' + arr[i] + '</option>';
  }
  // $(id).html(html);
  $(id).html('<option value="">请输入</option>');
  $(id).append(html);
  //重新渲染from
  form.render(); //更新全部
}
/**
 * arr 选项数据数据 [{},{},.....]
 * id select 元素的id 或者class
 */
function showOption2(data, id) {
  var html = '';
  for (var i = 0; i < data.length; i++) {
    html += '<option value="' + data[i].name + '">' + data[i].name + '</option>';
  }

  // $(id).html(html);
  // $(id).html(''); //先制空
  $(id).append(html);
  //重新渲染from
  form.render(); //更新全部

}
function showOption3(data, id,roleId,roleName) {
  var html = '';
  for (var i = 0; i < data.length; i++) {
    html += '<option value="' + data[i].roleId + '">' + data[i].roleName + '</option>';
  }

  // $(id).html(html);
  // $(id).html(''); //先制空
  $(id).append(html);
  //重新渲染from
  form.render(); //更新全部

}

//渲染权限函数

function showResourceId(data, id) {
  var html = '';
  for (var i = 0; i < data.length; i++) {
    html += '<input type="checkbox" name="resourceId" value="' + data[i].id + '" lay-skin="primary" title="' + data[i].resourceName +
      '">';
  }
  $(id).html('');
  $(id).append(html);
  //重新渲染from
  form.render(); //更新全部
}


//getdata 获取数据

function getdata(url, data, fn) {
  $.ajax({
    type: 'get',
    url: url,
    data: data,
    success: function(data) {
      fn(data)
    }
  })
}

//获取校区数据option
function getcompanyId() {
  $.ajax({
    type: 'get',
    url: baseUrl + '/getcompanyId',
    success: function(data) {

      var data = data.data;
      var arr = [];

      for (var i = 0; i < data.length; i++) {
        arr.push(data[i].companyName);
      }
      console.log(data, arr);
      //渲染校区 option
      showOption(arr, '#companyId');

    }
  });

}
//获取部门数据option
function getdptId() {
  $.ajax({
    type: 'get',
    url: baseUrl + '/section',
    success: function(data) {

      var data = data.data;
      var arr = [];

      for (var i = 0; i < data.length; i++) {
        arr.push(data[i].dptName);
      }
      console.log(data, arr);
      //渲染校区 option
      showOption(arr, '#dptId');

    }
  });
}
